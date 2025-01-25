package fr.dot.sephora.library.local.source

import fr.dot.sephora.library.core.source.product.ProductLocalDataSource
import fr.dot.sephora.library.domain.models.Product
import fr.dot.sephora.library.local.dao.ProductDao
import fr.dot.sephora.library.local.entity.ProductEntity
import fr.dot.sephora.library.local.entity.toDomain
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

internal class ProductLocalDataSourceImpl(
    private val local: ProductDao
) : ProductLocalDataSource {

    override suspend fun upsert(entities: List<Product>) {
        local.upsert(entities.map(Product::toDomain))
    }

    override fun flowOfProducts(): Flow<List<Product>> {
        return local.flowOfProducts()
            .map { list -> list.map(ProductEntity::toDomain) }
    }


}