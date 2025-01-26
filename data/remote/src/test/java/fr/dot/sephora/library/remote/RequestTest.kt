package fr.dot.sephora.library.remote

import fr.dot.sephora.library.remote.response.items
import fr.dot.sephora.library.remote.source.product.ProductService
import fr.dot.sephora.library.remote.source.review.ReviewService
import io.ktor.client.engine.mock.MockEngine
import io.ktor.client.engine.mock.respond
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpStatusCode
import io.ktor.http.headersOf
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test

class RequestTest {

    @Test
    fun testProductRequest() = runTest {
        val mockEngine = MockEngine { request ->
            respond(
                content = items,
                status = HttpStatusCode.OK,
                headers = headersOf(HttpHeaders.ContentType to listOf(ContentType.Application.Json.toString()))
            )
        }
        val json = provideJson()
        val client = provideClient(mockEngine, json)
        val service = ProductService(client)
        val products = service.getProducts()

        assertEquals(
            /* expected = */ 6,
            /* actual = */ products.size
        )
    }

    @Test
    fun testReviewRequest() = runTest {
        val mockEngine = MockEngine { request ->
            respond(
                content = items,
                status = HttpStatusCode.OK,
                headers = headersOf(HttpHeaders.ContentType to listOf(ContentType.Application.Json.toString()))
            )
        }
        val json = provideJson()
        val client = provideClient(mockEngine, json)
        val service = ReviewService(client)
        val reviews = service.getReviews()

        assertEquals(
            /* expected = */ 6,
            /* actual = */ reviews.size
        )
    }

}