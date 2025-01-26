package fr.dot.sephora.library.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import fr.dot.sephora.library.domain.models.Reviews

@Entity(
    tableName = ReviewsEntity.TABLE_NAME
)
internal data class ReviewsEntity(

    @ColumnInfo("product_id")
    @PrimaryKey
    val id: Int,

    @ColumnInfo("hide")
    val hide: Boolean

) {

    companion object {

        const val TABLE_NAME = "reviews"

    }

}

internal fun ReviewsEntity.toDomain(reviews: List<ReviewEntity>) = Reviews(
    productId = id,
    hide = hide,
    reviews = reviews.map { review ->
        Reviews.Review(
            id = review.id,
            name = review.name,
            text = review.text,
            rating = review.rating
        )
    }
)

internal fun Reviews.toLocal() = ReviewsEntity(
    id = productId,
    hide = hide
) to reviews.map { review ->
    ReviewEntity(
        id = review.id,
        name = review.name,
        productId = productId,
        text = review.text,
        rating = review.rating
    )
}