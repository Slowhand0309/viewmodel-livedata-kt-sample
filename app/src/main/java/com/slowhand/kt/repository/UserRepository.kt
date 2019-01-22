package com.slowhand.kt.repository

import repository.data.User

class UserRepository {

    fun getUsers(): List<User> {
        return listOf<User>(
            User(1, "tarou"),
            User(2, "hanako")
        )
    }
}