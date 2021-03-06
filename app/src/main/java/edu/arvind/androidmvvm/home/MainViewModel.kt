package edu.arvind.androidmvvm.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MainViewModel(val navigator: MainNavigator) : ViewModel() {
    internal class Factory(private val navigator: MainNavigator) : ViewModelProvider.Factory {
        companion object {
            var newInstance = { navigator: MainNavigator -> Factory(navigator) }
        }

        override fun <T : ViewModel?> create(modelClass: Class<T>): T =
            MainViewModel(navigator) as T
                ?: throw IllegalArgumentException("this creates only MainViewModel")
    }

    fun onReviewMeClicked() {
        navigator.reviewButtonTrigger.postValue(Unit)
    }

    fun onShowListOfMovies(){

    }
}

fun getMainViewModel(scope: MainActivity) =
    ViewModelProvider(
        scope,
        MainViewModel.Factory.newInstance(MainNavigator())
    ).get(MainViewModel::class.java)

