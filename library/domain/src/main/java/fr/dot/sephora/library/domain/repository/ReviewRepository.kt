package fr.dot.sephora.library.domain.repository

import fr.dot.sephora.library.domain.models.Product
import fr.dot.sephora.library.domain.models.Reviews
import kotlinx.coroutines.flow.Flow

interface ReviewRepository {

    suspend fun getReviews(): List<Reviews>

    fun flowOfReviews(): Flow<List<Reviews>>

}