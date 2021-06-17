package com.example.todoapplication

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.example.todoapplication.databinding.ActivityActivity2AddTodoBinding

/**
 * ACTIVITY 2
 * This activity allows the user to add a new item to the list.
 */

class Activity2AddTodo : AppCompatActivity() {
    private lateinit var binding: ActivityActivity2AddTodoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        // General setup and binding
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_activity2_add_todo)
        binding = ActivityActivity2AddTodoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val sharedPreferences = getSharedPreferences("SP_INFO", Context.MODE_PRIVATE)

        // When add button is pressed
        binding.addButton.setOnClickListener {
            binding.addButton.isVisible = false
            val editor = sharedPreferences.edit()
            editor.putString("TODOITEMS", binding.editText.text.toString())
            editor.apply()
            openMainActivity()
        }
    }

    /**
     * Opens up the main activity (Activity one) and passes the text in the EditText view.
     */
    private fun openMainActivity(){
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra(MainActivity.TASKTITLE, binding.editText.text.toString())
        this.startActivity(intent)
    }
}