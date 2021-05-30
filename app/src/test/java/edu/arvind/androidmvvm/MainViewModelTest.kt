package edu.arvind.androidmvvm

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleRegistry
import edu.arvind.androidmvvm.home.MainNavigator
import edu.arvind.androidmvvm.home.MainViewModel
import edu.arvind.androidmvvm.home.getMainViewModel
import io.mockk.every
import io.mockk.mockk
import org.junit.Assert
import org.junit.Rule
import org.junit.Test

class MainViewModelTest {

    @Rule
    @JvmField
    val rule = InstantTaskExecutorRule()

    @Test
    fun onReviewMeClicked() {
        val navigator = MainNavigator()

        val lifecycle = LifecycleRegistry(mockk()).apply {
            handleLifecycleEvent(Lifecycle.Event.ON_RESUME)
        }
        val visibleResultObserver = mockk<(Unit?) -> Unit>().also {
            every { it.invoke(Unit) } returns Unit // for initial value
        }
        val viewModel = MainViewModel(navigator)
            viewModel.navigator.reviewButtonTrigger.observe({ lifecycle }, visibleResultObserver)

        Assert.assertNull(viewModel.navigator.reviewButtonTrigger.value)
    }
}