@file:OptIn(ExperimentalCoroutinesApi::class)

package fr.dot.sephora.library.local.source

import fr.dot.sephora.library.core.source.reviews.ReviewLocalDataSource
import fr.dot.sephora.library.domain.models.Reviews
import fr.dot.sephora.library.local.dao.ReviewDao
import fr.dot.sephora.library.local.dao.ReviewsDao
import fr.dot.sephora.library.local.entity.toDomain
import fr.dot.sephora.library.local.entity.toLocal
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.transformLatest

internal class ReviewLocalDataSourceImpl(
    private val reviewsDao: ReviewsDao,
    private val reviewDao: ReviewDao
) : ReviewLocalDataSource {

    override suspend fun upsert(entities: List<Reviews>) {
        entities.map(Reviews::toLocal)
            .forEach { (review, reviews) ->
                reviewDao.upsert(reviews)
                reviewsDao.upsert(review)
            }
    }

    override fun flowOfReviews(): Flow<List<Reviews>> {
        return reviewsDao.flowOfReviews()
            .transformLatest { list ->
                if (list.isEmpty()) {
                    emitAll(flowOf(emptyList()))
                } else {
                    emitAll(
                        combine<Reviews, List<Reviews>>(
                            list.map { review ->
                                reviewDao.flowOfReviews(review.id)
                                    .map { review.toDomain(it) }
                            },
                            Array<Reviews>::toList
                        )
                    )
                }
            }
    }

}