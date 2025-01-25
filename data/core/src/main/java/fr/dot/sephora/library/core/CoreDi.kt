package fr.dot.sephora.library.core

import fr.dot.sephora.library.core.source.product.ProductRepositoryImpl
import fr.dot.sephora.library.core.source.reviews.ReviewRepositoryImpl
import fr.dot.sephora.library.domain.repository.ProductRepository
import fr.dot.sephora.library.domain.repository.ReviewRepository
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val coreDi = module {
    singleOf(::ProductRepositoryImpl) bind ProductRepository::class
    singleOf(::ReviewRepositoryImpl) bind ReviewRepository::class
}