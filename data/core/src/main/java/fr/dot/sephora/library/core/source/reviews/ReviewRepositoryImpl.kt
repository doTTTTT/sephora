package fr.dot.sephora.library.core.source.reviews

import fr.dot.sephora.library.domain.models.Reviews
import fr.dot.sephora.library.domain.repository.ReviewRepository
import kotlinx.coroutines.flow.Flow

internal class ReviewRepositoryImpl(
    private val remote: ReviewRemoteDataSource,
    private val local: ReviewLocalDataSource
) : ReviewRepository {

    override suspend fun getReviews(): List<Reviews> {
        val entities = remote.getReviews()

        local.upsert(entities)

        return entities
    }

    override fun flowOfReviews(): Flow<List<Reviews>> {
        return local.flowOfReviews()
    }

}