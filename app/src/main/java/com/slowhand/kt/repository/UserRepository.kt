package com.slowhand.kt.repository

import com.slowhand.kt.repository.data.Result
import com.slowhand.kt.repository.network.GithubApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class UserRepository {

    private val service: GithubApiService by lazy {
        GithubApiService.create()
    }

    suspend fun getUsers(query: String): Result? =
        withContext(Dispatchers.Default) {
            service.search(query).await().body()
        }
}