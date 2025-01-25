package fr.dot.sephora.library.domain.usecase

import fr.dot.sephora.library.domain.models.Product
import fr.dot.sephora.library.domain.repository.ProductRepository

class GetProductsUseCase internal constructor(
    private val repository: ProductRepository
) : IUseCase<List<Product>, GetProductsUseCase.Params> {

    override suspend fun execute(params: Params): List<Product> {
        return repository.getProducts()
    }

    data object Params : IUseCase.IParams

}