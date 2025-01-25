package fr.dot.sephora.library.domain

import fr.dot.sephora.library.domain.usecase.GetProductsUseCase
import fr.dot.sephora.library.domain.usecase.GetReviewsUseCase
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val domainDi = module {
    factoryOf(::GetProductsUseCase)
    factoryOf(::GetReviewsUseCase)
}