package com.example.savedstate

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

class MainViewModel(state: SavedStateHandle) : ViewModel() {

    private val savedStateHandle = state
    private var _name: MutableLiveData<String> = MutableLiveData()
    val name: LiveData<String> = _name

    companion object {
        private const val USER_KEY = "userId"
    }

    fun saveCurrentUserViewModel(userId: String) {
        _name.value = userId
    }

    fun saveCurrentUserState(userId: String) {
        savedStateHandle.set(USER_KEY, userId)
    }

    fun getCurrentUser(): LiveData<String> {
        return savedStateHandle.getLiveData(USER_KEY)
    }
}