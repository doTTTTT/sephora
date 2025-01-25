package fr.dot.sephora.feature.main

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

            adapter.submitList(productsWithReviews)
        }
    }

}