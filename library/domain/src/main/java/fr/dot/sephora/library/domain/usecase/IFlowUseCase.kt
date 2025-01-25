package fr.dot.sephora.library.domain.usecase

import kotlinx.coroutines.flow.Flow

interface IFlowUseCase<R, P : IUseCase.IParams> {

    fun execute(params: P): Flow<R>

    operator fun invoke(params: P): Flow<R> = execute(params)

}
