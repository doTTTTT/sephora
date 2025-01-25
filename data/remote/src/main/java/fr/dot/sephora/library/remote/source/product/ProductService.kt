package fr.dot.sephora.library.remote.source.product

import fr.dot.sephora.library.domain.models.Product
import fr.dot.sephora.library.remote.entity.ProductEntity
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.http.ContentType
import io.ktor.http.contentType

internal class ProductService(private val client: HttpClient) {

    suspend fun getProducts(): List<ProductEntity> {
        return client.get("/testProject/items.json") {
            contentType(ContentType.Application.Json)
        }
            .body()
    }

}