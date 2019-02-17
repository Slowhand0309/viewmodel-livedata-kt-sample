package com.slowhand.kt.repository.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.slowhand.kt.repository.data.Result
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface GithubApiService {

    @GET("search/users")
    fun search(
        @Query("q") query: String,
        @Query("page") page: Int = 1,
        @Query("per_page") perPage: Int = 20): Deferred<Response<Result>>

    companion object {
        fun create(): GithubApiService {
            val retrofit = Retrofit.Builder()
                            .baseUrl("https://api.github.com/")
                            .addConverterFactory(MoshiConverterFactory.create())
                            .addCallAdapterFactory(CoroutineCallAdapterFactory())
                            .build()
            return retrofit.create(GithubApiService::class.java)
        }
    }
}