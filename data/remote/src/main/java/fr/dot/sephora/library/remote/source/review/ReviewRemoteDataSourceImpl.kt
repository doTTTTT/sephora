package fr.dot.sephora.library.remote.source.review

import fr.dot.sephora.library.core.source.reviews.ReviewRemoteDataSource
import fr.dot.sephora.library.domain.models.Reviews
import fr.dot.sephora.library.remote.entity.ReviewsEntity
import fr.dot.sephora.library.remote.entity.toDomain

internal class ReviewRemoteDataSourceImpl(
    private val service: ReviewService
) : ReviewRemoteDataSource {

    override suspend fun getReviews(): List<Reviews> {
        return service.getReviews()
            .map(ReviewsEntity::toDomain)
    }

}