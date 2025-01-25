package fr.dot.sephora.library.domain.usecase

import fr.dot.sephora.library.domain.models.Reviews
import fr.dot.sephora.library.domain.repository.ReviewRepository
import kotlinx.coroutines.flow.Flow

class FlowOfReviewsUseCase internal constructor(
    private val repository: ReviewRepository
) : IFlowUseCase<List<Reviews>, FlowOfReviewsUseCase.Params> {

    override fun execute(params: Params): Flow<List<Reviews>> {
        return repository.flowOfReviews()
    }

    data object Params : IUseCase.IParams

}