package com.example.todoapplication.data

import com.example.todoapplication.model.Todo

class Datasource {
    fun loadTodos(): MutableList<Todo>{
        return mutableListOf<Todo>(
            Todo("Eat 10 pizzas from papa johns"),
            Todo("What is going onnnnn"),
            Todo("This is a string")
        )
    }
}