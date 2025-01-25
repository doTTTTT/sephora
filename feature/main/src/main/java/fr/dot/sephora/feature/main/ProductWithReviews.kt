package fr.dot.sephora.feature.main

import fr.dot.sephora.library.domain.models.Product
import fr.dot.sephora.library.domain.models.Reviews

data class ProductWithReviews(
    val product: Product,
    val hidden: Boolean,
    val reviews: List<Reviews.Review>
)