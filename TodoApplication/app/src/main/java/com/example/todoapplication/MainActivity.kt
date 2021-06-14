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
TODO Organize code
TODO currently replaces last todo when new todo added
TODO initially item null on list, set code to only display when new item not null
 */

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    companion object {
        const val TASKTITLE = "title"
    }

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
        val taskTitle = intent?.extras?.getString(TASKTITLE).toString()
        if (taskTitle != "null") {
            val newestTodo = Todo(taskTitle, false)
            todoList.add(newestTodo)
            adapter.notifyDataSetChanged()
            adapter.notifyItemInserted(todoList.size - 1)
        }


        val animation = AnimationUtils.loadAnimation(this, R.anim.circle_explotion_animation).apply {
            duration = 700
            interpolator = AccelerateDecelerateInterpolator()
        }

        binding.newItemBtn.setOnClickListener {
            binding.apply {
                newItemBtn.isVisible = false
                circle.isVisible = true
            }
            binding.circle.startAnimation(animation){}
            animation.setAnimationListener(object : Animation.AnimationListener {
                override fun onAnimationStart(animation: Animation?) {}
                override fun onAnimationEnd(animation: Animation?) {
                    binding.root.setBackgroundColor(ContextCompat.getColor(this@MainActivity, R.color.teal_200))
                    binding.recyclerTodos.isVisible = false
                    intent = Intent(this@MainActivity, Activity2AddTodo::class.java)
                    Handler(Looper.getMainLooper()).postDelayed(Runnable { startActivity(intent) }, 2000)
                }
                override fun onAnimationRepeat(animation: Animation?) {}
            })
        }
    }
}