package fr.dot.sephora.library.core.source.reviews

import fr.dot.sephora.library.domain.models.Reviews
import kotlinx.coroutines.flow.Flow

interface ReviewLocalDataSource {

    suspend fun upsert(entities: List<Reviews>)

    fun flowOfReviews(): Flow<List<Reviews>>

}