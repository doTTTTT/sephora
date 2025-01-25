package fr.dot.sephora.library.core.source.product

import fr.dot.sephora.library.domain.models.Product

interface ProductRemoteDataSource {

    suspend fun getProducts(): List<Product>

}