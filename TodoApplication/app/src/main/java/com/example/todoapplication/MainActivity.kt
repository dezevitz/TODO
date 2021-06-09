package com.example.todoapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todoapplication.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar


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
        binding.newItemBtn.setOnClickListener { view ->
            Snackbar.make(view, "Here's a Snackbar", Snackbar.LENGTH_LONG)
                .setAction("Action", null)
                .show()

        }
    }
}