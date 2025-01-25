package fr.dot.sephora.library.domain.repository

import fr.dot.sephora.library.domain.models.Product

interface ProductRepository {

    suspend fun getProducts(): List<Product>

}