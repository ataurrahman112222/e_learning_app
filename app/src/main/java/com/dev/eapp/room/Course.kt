package com.dev.elearning.room

data class Course(
    val id: Int,
    val name: String,
    val description: String,
    val price: Double,
    var isOffline: Boolean = false
)
