package com.example.tutorial_recyclerview_youtube

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TodoAdapter(val todoModelList : List<TodoModel>) : RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_todo, parent, false)
        return TodoViewHolder(view)
    }

    override fun getItemCount(): Int {
        return todoModelList.size
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.itemView.apply {
            val tvTodo = findViewById<TextView>(R.id.tvTodo)
            val cbCompleted = findViewById<CheckBox>(R.id.cbCompleted)

            tvTodo.text = todoModelList[position].todoText
            cbCompleted.isChecked = todoModelList[position].isChecked

        }
    }


    inner class TodoViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView)
}