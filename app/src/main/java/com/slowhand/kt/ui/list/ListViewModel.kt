package com.slowhand.kt.ui.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.slowhand.kt.repository.UserRepository
import com.slowhand.kt.repository.data.User
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class ListViewModel(private val userRepository: UserRepository): ViewModel() {
    private var users = MutableLiveData<List<User>>()

    fun getUsersLiveData(): LiveData<List<User>> = users

    fun reload(query: String) {
        viewModelScope.launch {
            users.value = userRepository.getUsers(query)?.items
        }
    }
}