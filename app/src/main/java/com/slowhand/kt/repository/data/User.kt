package com.slowhand.kt.repository.data

import com.squareup.moshi.Json

data class User(
    @Json(name = "login") val login: String,
    @Json(name = "id") val id: Long,
    @Json(name = "url") val url: String,
    @Json(name = "html_url") val htmlUrl: String,
    @Json(name = "followers_url") val followersUrl: String,
    @Json(name = "following_url") val followingUrl: String,
    @Json(name = "starred_url") val starredUrl: String,
    @Json(name = "gists_url") val gistsUrl: String,
    @Json(name = "type") val type: String,
    @Json(name = "score") val score: String
)

data class Result (
    val total_count: Int,
    val incomplete_results: Boolean,
    val items: List<User>
)