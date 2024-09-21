package com.dev.eapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dev.elearning.adapter.CourseAdapter
import com.dev.elearning.viewModel.CourseViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var courseAdapter: CourseAdapter
    private val courseViewModel: CourseViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val recyclerViewCourses = findViewById<RecyclerView>(R.id.recyclerViewCourses)
        recyclerViewCourses.layoutManager = LinearLayoutManager(this)

        courseViewModel.courseList.observe(this) { courseList ->
            courseAdapter = CourseAdapter(courseList) { course ->
                courseViewModel.addCourseToCart(course)
            }
            recyclerViewCourses.adapter = courseAdapter
        }

        // Observe changes in cart and print total price (for now just print)
        courseViewModel.cartItems.observe(this) {
            val totalPrice = courseViewModel.calculateTotalPrice()
            println("Total Price: $$totalPrice")
            println("Total Price2: $$totalPrice")
        }

    }
}