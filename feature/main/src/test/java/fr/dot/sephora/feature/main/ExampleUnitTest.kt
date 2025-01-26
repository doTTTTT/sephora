package fr.dot.sephora.feature.main

import fr.dot.sephora.library.domain.usecase.FlowOfProductsUseCase
import fr.dot.sephora.library.domain.usecase.FlowOfReviewsUseCase
import fr.dot.sephora.library.domain.usecase.GetProductsUseCase
import fr.dot.sephora.library.domain.usecase.GetReviewsUseCase
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.flow.flowOf
import org.junit.Rule
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    @Test
    fun addition_isCorrect() {
        val flowOfReviewsUseCase = mockk<FlowOfReviewsUseCase> {
            every { this@mockk(FlowOfReviewsUseCase.Params) } returns flowOf(emptyList())
        }
        val flowOfProductsUseCase = mockk<FlowOfProductsUseCase> {
            every { this@mockk(FlowOfProductsUseCase.Params) } returns flowOf(emptyList())
        }
        val productsUseCase = mockk<GetProductsUseCase> {
            coEvery { this@mockk(GetProductsUseCase.Params) } returns Result.success(emptyList())
        }
        val reviewsUseCase = mockk<GetReviewsUseCase> {
            coEvery { this@mockk(GetReviewsUseCase.Params) } returns Result.success(emptyList())
        }
        val viewModel = MainViewModel(
            flowOfReviewsUseCase = flowOfReviewsUseCase,
            flowOfProductsUseCase = flowOfProductsUseCase,
            productsUseCase = productsUseCase,
            reviewsUseCase = reviewsUseCase
        )

        viewModel.onRefresh { }

        coVerify { productsUseCase(GetProductsUseCase.Params) }
        coVerify { reviewsUseCase(GetReviewsUseCase.Params) }
    }

}