package com.example.todoapplication

import android.os.Bundle
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todoapplication.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //val recyclerTodos: RecyclerView = findViewById(R.id.recyclerTodos)
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
            duration = 700
            interpolator = AccelerateDecelerateInterpolator()
        }

        binding.newItemBtn.setOnClickListener {
            binding.apply {
                newItemBtn.isVisible = false
                circle.isVisible = true
            }
            binding.circle.startAnimation(animation){
                binding.root.setBackgroundColor(ContextCompat.getColor(this, R.color.teal_200))
            }
        }
    }
}