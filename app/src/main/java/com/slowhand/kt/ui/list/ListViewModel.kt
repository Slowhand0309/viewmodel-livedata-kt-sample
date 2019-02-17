package com.slowhand.kt.ui.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.slowhand.kt.repository.UserRepository
import com.slowhand.kt.repository.data.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ListViewModel(private val userRepository: UserRepository): ViewModel() {
    private var users = MutableLiveData<List<User>>()

    fun getUsersLiveData(): LiveData<List<User>> = users

    fun reload(query: String) {
        GlobalScope.launch(Dispatchers.Main) {
            users.value = userRepository.getUsers(query)?.items
        }
    }
}