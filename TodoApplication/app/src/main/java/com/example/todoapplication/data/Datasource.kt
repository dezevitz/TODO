package com.example.todoapplication.data

import com.example.todoapplication.R
import com.example.todoapplication.model.Todo

class Datasource {
    fun loadTodos(): List<Todo>{
        return listOf<Todo>(
            Todo(R.string.Todo1, false),
            Todo(R.string.Todo2, false),
            Todo(R.string.Todo3, false),
            Todo(R.string.Todo4, false),
            Todo(R.string.Todo5, false),
            Todo(R.string.Todo6, false),
            Todo(R.string.Todo7, false),
            Todo(R.string.Todo8, false),
            Todo(R.string.Todo9, false),
            Todo(R.string.Todo10, false)
        )
    }
}