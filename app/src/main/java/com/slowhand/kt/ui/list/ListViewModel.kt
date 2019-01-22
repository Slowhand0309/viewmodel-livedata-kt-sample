package com.slowhand.kt.ui.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.slowhand.kt.repository.UserRepository
import repository.data.User

class ListViewModel: ViewModel() {
    private var users = MutableLiveData<List<User>>()
    private val userRepository = UserRepository()

    init {
        // 初期化時にUserRepositoryから読み込んだリストをLiveDataへ設定
        users.value = userRepository.getUsers()
    }

    fun getUsersLiveData(): LiveData<List<User>> = users
}