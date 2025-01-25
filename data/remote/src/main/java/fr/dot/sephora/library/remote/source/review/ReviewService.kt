package fr.dot.sephora.library.remote.source.review

import fr.dot.sephora.library.remote.entity.ReviewsEntity
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.http.ContentType
import io.ktor.http.contentType

internal class ReviewService(
    private val client: HttpClient
) {

    suspend fun getReviews(): List<ReviewsEntity> {
        return client.get("/testProject/reviews.json") {
            contentType(ContentType.Application.Json)
        }
            .body()
    }

}