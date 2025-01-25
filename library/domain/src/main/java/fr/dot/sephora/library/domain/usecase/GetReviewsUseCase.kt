package fr.dot.sephora.library.domain.usecase

import fr.dot.sephora.library.domain.models.Reviews
import fr.dot.sephora.library.domain.repository.ReviewRepository

class GetReviewsUseCase internal constructor(
    private val repository: ReviewRepository
) : IUseCase<List<Reviews>, GetReviewsUseCase.Params> {

    override suspend fun execute(params: Params): List<Reviews> {
        return repository.getReviews()
    }

    data object Params : IUseCase.IParams

}