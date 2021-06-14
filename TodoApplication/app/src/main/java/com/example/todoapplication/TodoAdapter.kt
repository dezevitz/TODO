package com.example.todoapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TodoAdapter (
    var todos: List<Todo>
        ): RecyclerView.Adapter<TodoAdapter.TodoViewHolder>(){
    inner class TodoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val taskDesc: TextView = itemView.findViewById((R.id.tvTitle))
        val doneCB: CheckBox = itemView.findViewById(R.id.cbDone)
    }

    /**
     * Creates the view holder
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_todo, parent, false)
        return TodoViewHolder(view)
    }

    /**
     * Updates the information in the recycler view when the items move off screen
     */
    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.taskDesc.text = todos[position].title
        holder.doneCB.isChecked = todos[position].isChecked
    }

    /**
     * Gets the size of the recycler view
     */
    override fun getItemCount(): Int {
        return todos.size
    }
}
