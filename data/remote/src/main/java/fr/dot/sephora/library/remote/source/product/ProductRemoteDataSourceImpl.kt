package fr.dot.sephora.library.remote.source.product

import fr.dot.sephora.library.core.source.product.ProductRemoteDataSource
import fr.dot.sephora.library.domain.models.Product
import fr.dot.sephora.library.remote.entity.ProductEntity
import fr.dot.sephora.library.remote.entity.toDomain

internal class ProductRemoteDataSourceImpl(
    private val service: ProductService
) : ProductRemoteDataSource {

    override suspend fun getProducts(): List<Product> {
        return service.getProducts()
            .map(ProductEntity::toDomain)
    }

}