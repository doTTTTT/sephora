package fr.dot.sephora.feature.main

import android.widget.Filter
import android.widget.Filterable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import fr.dot.sephora.library.domain.usecase.FlowOfProductsUseCase
import fr.dot.sephora.library.domain.usecase.FlowOfReviewsUseCase
import fr.dot.sephora.library.domain.usecase.GetProductsUseCase
import fr.dot.sephora.library.domain.usecase.GetReviewsUseCase
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch

internal class MainViewModel(
    private val flowOfProductsUseCase: FlowOfProductsUseCase,
    private val flowOfReviewsUseCase: FlowOfReviewsUseCase,
    private val productsUseCase: GetProductsUseCase,
    private val reviewsUseCase: GetReviewsUseCase
) : ViewModel() {

    val adapter = ProductAdapter()

    private val fullList: MutableList<ProductWithReviews> = mutableListOf()
    private val filter = Filterable { ProductFilter() }

    init {
        viewModelScope.launch {
            combine(
                flowOfProductsUseCase(FlowOfProductsUseCase.Params),
                flowOfReviewsUseCase(FlowOfReviewsUseCase.Params)
            ) { products, reviews ->
                products.map { product ->
                    val review = reviews.find { it.productId == product.id }

                    ProductWithReviews(
                        product = product,
                        hidden = review?.hide ?: false,
                        reviews = review?.reviews.orEmpty()
                    )
                }
            }
                .catch { it.printStackTrace() }
                .collect { list ->
                    if (list.isEmpty()) {
                        refresh()
                    }
                    fullList.addAll(list)
                    adapter.submitList(list)
                }
        }
    }

    fun onSearch(query: String) {
        filter.filter.filter(query)
    }

    fun onCloseSearch() {
        adapter.submitList(fullList)
    }

    fun onRefresh(callback: () -> Unit) {
        viewModelScope.launch {
            refresh()
            callback()
        }
    }

    private suspend fun refresh() {
        productsUseCase(GetProductsUseCase.Params)
        reviewsUseCase(GetReviewsUseCase.Params)
    }

    private inner class ProductFilter : Filter() {

        override fun performFiltering(constraint: CharSequence?): FilterResults {
            val results = FilterResults()
            val filter = if (constraint.isNullOrEmpty()) {
                fullList
            } else {
                fullList.filter { product ->
                    product.product.name.contains(constraint.toString(), true)
                }
            }

            results.values = filter

            return results
        }

        override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
            val values = results?.values ?: return

            if (values is List<*>) {
                adapter.submitList(values.filterIsInstance<ProductWithReviews>())
            }
        }

    }

}