package fr.dot.sephora.library.domain.repository

import fr.dot.sephora.library.domain.models.Product
import kotlinx.coroutines.flow.Flow

interface ProductRepository {

    suspend fun getProducts(): List<Product>

    fun flowOfProducts(): Flow<List<Product>>

}