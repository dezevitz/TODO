package com.example.todoapplication

import android.view.View
import androidx.recyclerview.widget.RecyclerView

class TodoAdapter (
    var todos: List<Todo>
        ){
    inner class TodoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}
