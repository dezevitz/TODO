package com.example.todoapplication

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.example.todoapplication.databinding.ActivityActivity2AddTodoBinding

class Activity2AddTodo : AppCompatActivity() {
    private lateinit var binding: ActivityActivity2AddTodoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_activity2_add_todo)
        binding = ActivityActivity2AddTodoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.addButton.setOnClickListener {
            binding.addButton.isVisible = false
            openMainActivity()
        }
    }
    fun openMainActivity(){
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra(MainActivity.TASKTITLE, binding.editText.text.toString())
        this.startActivity(intent)
    }
}