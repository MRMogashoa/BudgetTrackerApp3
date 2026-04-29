package com.example.budgettrackerapp

object DataStore {
    val users = mutableListOf<User>()
}

data class User(
    val username: String,
    val password: String
)