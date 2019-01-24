package com.slowhand.kt.ui.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.slowhand.kt.repository.UserRepository
import repository.data.User

class ListViewModel(private val userRepository: UserRepository): ViewModel() {
    private var users = MutableLiveData<List<User>>()

    init {
        // 初期化時にUserRepositoryから読み込んだリストをLiveDataへ設定
        users.value = userRepository.getUsers()
    }

    fun getUsersLiveData(): LiveData<List<User>> = users
}