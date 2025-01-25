package fr.dot.sephora.library.remote.entity

import fr.dot.sephora.library.domain.models.Reviews
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class ReviewsEntity(

    @SerialName("product_id")
    val id: Int,

    @SerialName("hide")
    val hide: Boolean = false,

    @SerialName("reviews")
    val reviews: List<Review> = emptyList()

) {

    @Serializable
    data class Review(

        @SerialName("name")
        val name: String? = null,

        @SerialName("text")
        val text: String? = null,

        @SerialName("rating")
        val rating: Float? = null

    )

}

internal fun ReviewsEntity.toDomain() = Reviews(
    productId = id,
    hide = hide,
    reviews = reviews.map { review ->
        Reviews.Review(
            name = review.name,
            text = review.text,
            rating = review.rating
        )
    }
)