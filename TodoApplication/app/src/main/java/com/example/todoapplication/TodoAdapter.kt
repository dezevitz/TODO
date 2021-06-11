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


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_todo, parent, false)
        return TodoViewHolder(view)
    }
    /*
    * Holder used to access the view holder
    * */
    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.taskDesc.text = todos[position].title
        holder.doneCB.isChecked = todos[position].isChecked
    }

    override fun getItemCount(): Int {
        return todos.size
    }
}
