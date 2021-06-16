package com.example.todoapplication.data

import com.example.todoapplication.model.Todo

class Datasource {
    fun loadTodos(): MutableList<Todo>{
        return mutableListOf<Todo>(
            Todo("Eat 10 pizzas from papa johns", false),
            Todo("What is going onnnnn", false),
            Todo("This is a string", false)
        )
    }
}