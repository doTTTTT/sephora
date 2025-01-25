package fr.dot.sephora.library.core.source.product

import fr.dot.sephora.library.domain.models.Product
import kotlinx.coroutines.flow.Flow

interface ProductLocalDataSource {

    suspend fun upsert(entities: List<Product>)

    fun flowOfProducts(): Flow<List<Product>>

}