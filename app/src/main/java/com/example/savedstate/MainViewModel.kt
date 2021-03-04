package com.example.savedstate

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

class MainViewModel(state : SavedStateHandle): ViewModel() {

    private val savedStateHandle = state
    private val _userId : MutableLiveData<String> = savedStateHandle.getLiveData(USER_KEY)

    val userId : LiveData<String> = _userId
    companion object {
        private val USER_KEY = "userId"
    }

    fun saveCurrentUser(userId: String) {
        savedStateHandle.set(USER_KEY, userId)
    }

    fun getCurrentUser(): String {
        return savedStateHandle.get(USER_KEY)?: ""
    }
}