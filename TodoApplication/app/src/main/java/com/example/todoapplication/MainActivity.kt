package com.example.todoapplication

import android.content.Intent
import android.os.Bundle
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todoapplication.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        var todoList = mutableListOf(
            Todo("Implement Checkboxes", false),
            Todo("Filter by Date", false),
            Todo("Eat Breakfast", false),
            Todo("Goat Yoga", false),
            Todo("Call mom", false),
            Todo("Call dad", false),
            Todo("Filter out checked", false),
            Todo("Create page for checked", false),
            Todo("Pray to the penny lords", false)
        )
        val adapter = TodoAdapter(todoList)
        binding.recyclerTodos.adapter = adapter
        binding.recyclerTodos.layoutManager = LinearLayoutManager(this)

        /* Add new Item code */
        val animation = AnimationUtils.loadAnimation(this, R.anim.circle_explotion_animation).apply {
            duration = 1500
            interpolator = AccelerateDecelerateInterpolator()
        }

        binding.newItemBtn.setOnClickListener {
            binding.apply {
                newItemBtn.isVisible = false
                circle.isVisible = true
            }
            binding.circle.startAnimation(animation){}
            openActivity2()
        }
    }
    private fun openActivity2(){
        val intent = Intent(this, Activity2AddTodo::class.java)
        this.startActivity(intent)
    }
}