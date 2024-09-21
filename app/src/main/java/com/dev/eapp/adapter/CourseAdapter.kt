package com.dev.elearning.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dev.eapp.R
import com.dev.elearning.room.Course

class CourseAdapter(
    private val courseList: List<Course>,
    private val onAddToCartClick: (Course) -> Unit
) : RecyclerView.Adapter<CourseAdapter.CourseViewHolder>() {

    class CourseViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val courseName: TextView = view.findViewById(R.id.textViewCourseName)
        val courseDescription: TextView = view.findViewById(R.id.textViewCourseDescription)
        val coursePrice: TextView = view.findViewById(R.id.textViewCoursePrice)
        val addToCartButton: Button = view.findViewById(R.id.buttonAddToCart)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_course, parent, false)
        return CourseViewHolder(view)
    }

    override fun onBindViewHolder(holder: CourseViewHolder, position: Int) {
        val course = courseList[position]
        holder.courseName.text = course.name
        holder.courseDescription.text = course.description
        holder.coursePrice.text = "$${course.price}"

        holder.addToCartButton.setOnClickListener {
            onAddToCartClick(course)
        }
    }

    override fun getItemCount(): Int = courseList.size
}
