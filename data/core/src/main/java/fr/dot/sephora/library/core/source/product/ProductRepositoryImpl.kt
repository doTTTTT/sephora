package fr.dot.sephora.library.core.source.product

import fr.dot.sephora.library.domain.models.Product
import fr.dot.sephora.library.domain.repository.ProductRepository

internal class ProductRepositoryImpl(
    private val remote: ProductRemoteDataSource
) : ProductRepository {

    override suspend fun getProducts(): List<Product> {
        return remote.getProducts()
    }

}