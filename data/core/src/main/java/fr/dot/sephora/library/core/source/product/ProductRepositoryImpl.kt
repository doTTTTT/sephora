package fr.dot.sephora.library.core.source.product

import fr.dot.sephora.library.domain.models.Product
import fr.dot.sephora.library.domain.repository.ProductRepository
import kotlinx.coroutines.flow.Flow

internal class ProductRepositoryImpl(
    private val remote: ProductRemoteDataSource,
    private val local: ProductLocalDataSource
) : ProductRepository {

    override suspend fun getProducts(): List<Product> {
        val entities = remote.getProducts()

        local.upsert(entities)

        return entities
    }

    override fun flowOfProducts(): Flow<List<Product>> {
        return local.flowOfProducts()
    }

}