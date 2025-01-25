package fr.dot.sephora.library.core.source.reviews

import fr.dot.sephora.library.domain.models.Reviews

interface ReviewRemoteDataSource {

    suspend fun getReviews(): List<Reviews>

}