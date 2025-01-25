package fr.dot.sephora.library.remote

import fr.dot.sephora.library.core.source.product.ProductRemoteDataSource
import fr.dot.sephora.library.core.source.reviews.ReviewRemoteDataSource
import fr.dot.sephora.library.remote.source.product.ProductRemoteDataSourceImpl
import fr.dot.sephora.library.remote.source.product.ProductService
import fr.dot.sephora.library.remote.source.review.ReviewRemoteDataSourceImpl
import fr.dot.sephora.library.remote.source.review.ReviewService
import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val remoteDi = module {
    single { provideJson() }
    single { provideClient(get()) }

    singleOf(::ProductService)
    singleOf(::ReviewService)

    singleOf(::ProductRemoteDataSourceImpl) bind ProductRemoteDataSource::class
    singleOf(::ReviewRemoteDataSourceImpl) bind ReviewRemoteDataSource::class
}

internal fun provideJson(): Json {
    return Json {
        ignoreUnknownKeys = true
    }
}

internal fun provideClient(json: Json): HttpClient {
    return HttpClient(OkHttp) {
        install(ContentNegotiation) {
            json(json)
        }

        install(Logging) {
            level = LogLevel.ALL
        }

        defaultRequest {
            url("https://sephoraandroid.github.io")
        }
    }
}