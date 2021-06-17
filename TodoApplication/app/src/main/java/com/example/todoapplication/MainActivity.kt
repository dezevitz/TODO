package com.example.todoapplication

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todoapplication.databinding.ActivityMainBinding

/*
TODO currently replaces last todo when new todo added (newest item is forgotten)
TODO closing animation when add is clicked
TODO readd the ability to add a new item
 */

/*
ACTIVITY 1
This activity is the landing screen for the app. On this screen the user can see all of their todos
on a recycler view. There is a FAB in the corner for adding items
 */

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    companion object {
        const val TASKTITLE = "title"
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        // General setup of binding and content
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val sharedPreferences = getSharedPreferences("SP_INFO", MODE_PRIVATE)

        // Sample list
        var todoStrings = sharedPreferences.getString("TODOITEMS", "Empty")
        var todoList = todoStrings?.split(",")?.toMutableList()

        // Recycler view setup
        val adapter = todoList?.let { TodoAdapter(this, it) }
        binding.recyclerTodos.adapter = adapter
        binding.recyclerTodos.layoutManager = LinearLayoutManager(this)

        // Animation between Activity 1 and 2
        val animation = AnimationUtils.loadAnimation(this, R.anim.circle_explotion_animation).apply {
            duration = 700
            interpolator = AccelerateDecelerateInterpolator()
        }

        // FAB button listener/transition to Activity 2
        binding.newItemBtn.setOnClickListener {
            binding.apply {
                newItemBtn.isVisible = false
                circle.isVisible = true
            }
            // Between Activity Animation
            binding.circle.startAnimation(animation){}
            animation.setAnimationListener(object : Animation.AnimationListener {
                override fun onAnimationStart(animation: Animation?) {}
                override fun onAnimationEnd(animation: Animation?) {
                    binding.root.setBackgroundColor(ContextCompat.getColor(this@MainActivity, R.color.teal_200))
                    binding.recyclerTodos.isVisible = false
                    intent = Intent(this@MainActivity, Activity2AddTodo::class.java)
                    Handler(Looper.getMainLooper()).postDelayed(Runnable {
                        startActivity(intent)
                        overridePendingTransition(0,0)}, 2000)
                }
                override fun onAnimationRepeat(animation: Animation?) {}
            })
        }
    }
}