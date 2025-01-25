package fr.dot.sephora.library.domain.usecase

interface IUseCase<R, P : IUseCase.IParams> {

    suspend fun execute(params: P): R

    suspend operator fun invoke(params: P): Result<R> = runCatching {
        execute(params)
    }

    interface IParams

}
