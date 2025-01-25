package fr.dot.sephora.library.domain.repository

import fr.dot.sephora.library.domain.models.Product
import fr.dot.sephora.library.domain.models.Reviews

interface ReviewRepository {

    suspend fun getReviews(): List<Reviews>

}