package com.dev.elearning.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dev.elearning.room.CartItem
import com.dev.elearning.room.Course

class CourseViewModel : ViewModel() {

    // Hardcoded list of courses
    private val courses = listOf(
        Course(1, "Math 101", "Basic Mathematics", 100.0),
        Course(2, "Physics 101", "Introduction to Physics", 150.0),
        Course(3, "History 101", "World History Overview", 120.0)
    )

    private val _courseList = MutableLiveData<List<Course>>(courses)
    val courseList: LiveData<List<Course>> get() = _courseList

    private val _cartItems = MutableLiveData<MutableList<CartItem>>(mutableListOf())
    val cartItems: MutableLiveData<MutableList<CartItem>> get() = _cartItems

    fun addCourseToCart(course: Course) {
        val updatedCart = _cartItems.value ?: mutableListOf()
        updatedCart.add(CartItem(course))
        _cartItems.value = updatedCart
    }

    fun calculateTotalPrice(): Double {
        return _cartItems.value?.sumOf { it.course.price } ?: 0.0
    }
}
