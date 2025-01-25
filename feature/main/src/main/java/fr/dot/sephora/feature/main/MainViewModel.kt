package fr.dot.sephora.feature.main

import android.widget.Filter
import android.widget.Filterable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import fr.dot.sephora.library.domain.usecase.GetProductsUseCase
import fr.dot.sephora.library.domain.usecase.GetReviewsUseCase
import kotlinx.coroutines.launch

internal class MainViewModel(
    private val productsUseCase: GetProductsUseCase,
    private val reviewsUseCase: GetReviewsUseCase
) : ViewModel() {

    val adapter = ProductAdapter()

    private val fullList: MutableList<ProductWithReviews> = mutableListOf()
    private val filter = Filterable { ProductFilter() }

    init {
        viewModelScope.launch {
            val products = productsUseCase(GetProductsUseCase.Params)
                .onFailure(Throwable::printStackTrace)
                .getOrDefault(emptyList())
            val reviews = reviewsUseCase(GetReviewsUseCase.Params)
                .onFailure(Throwable::printStackTrace)
                .getOrDefault(emptyList())
            val productsWithReviews = products.map { product ->
                val review = reviews.find { it.productId == product.id }

                ProductWithReviews(
                    product = product,
                    hidden = review?.hide ?: false,
                    reviews = review?.reviews.orEmpty()
                )
            }

            fullList.addAll(productsWithReviews)
            adapter.submitList(productsWithReviews)
        }
    }

    fun onSearch(query: String) {
        filter.filter.filter(query)
    }

    fun onCloseSearch() {
        println("FULLLIST")
        adapter.submitList(fullList)
    }

    private inner class ProductFilter : Filter() {

        override fun performFiltering(constraint: CharSequence?): FilterResults {
            val results = FilterResults()
            val filter = if (constraint.isNullOrEmpty()) {
                fullList
            } else {
                fullList.filter { product ->
                    product.product.name.contains(constraint.toString().orEmpty(), true)
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