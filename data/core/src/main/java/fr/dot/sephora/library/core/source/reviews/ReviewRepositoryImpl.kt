package fr.dot.sephora.library.core.source.reviews

import fr.dot.sephora.library.domain.models.Reviews
import fr.dot.sephora.library.domain.repository.ReviewRepository

internal class ReviewRepositoryImpl(
    private val remote: ReviewRemoteDataSource
) : ReviewRepository {

    override suspend fun getReviews(): List<Reviews> {
        return remote.getReviews()
    }

}