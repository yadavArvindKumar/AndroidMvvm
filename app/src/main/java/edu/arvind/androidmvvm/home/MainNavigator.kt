package edu.arvind.androidmvvm.home

import androidx.lifecycle.MutableLiveData

data class MainNavigator(
    val reviewButtonTrigger: MutableLiveData<Unit> = MutableLiveData(),
    val displayMoviesListTrigger: MutableLiveData<Unit> = MutableLiveData()
)
