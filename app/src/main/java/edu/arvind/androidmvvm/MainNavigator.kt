package edu.arvind.androidmvvm

import androidx.lifecycle.MutableLiveData

data class MainNavigator(
    val reviewButtonTrigger: MutableLiveData<Unit> = MutableLiveData<Unit>()
)
