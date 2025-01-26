package fr.dot.sephora.library.domain.models

data class Reviews(
    val productId: Int,
    val hide: Boolean,
    val reviews: List<Review>
) {

    data class Review(
        val id: Int,
        val name: String?,
        val text: String?,
        val rating: Float?
    )

}