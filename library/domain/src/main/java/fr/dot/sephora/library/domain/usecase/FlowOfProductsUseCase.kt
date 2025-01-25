package fr.dot.sephora.library.domain.usecase

import fr.dot.sephora.library.domain.models.Product
import fr.dot.sephora.library.domain.repository.ProductRepository
import kotlinx.coroutines.flow.Flow

class FlowOfProductsUseCase internal constructor(
    private val repository: ProductRepository
) : IFlowUseCase<List<Product>, FlowOfProductsUseCase.Params> {

    override fun execute(params: Params): Flow<List<Product>> {
        return repository.flowOfProducts()
    }

    data object Params : IUseCase.IParams

}