package com.example.tutorial_recyclerview_youtube

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tutorial_recyclerview_youtube.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        var todoList = mutableListOf(
            TodoModel("A", false),
            TodoModel("B", false),
            TodoModel("C", false),
            TodoModel("D", false),
            TodoModel("E", false),
        )

        val adapter = TodoAdapter(todoList)

        binding.rvTodos.adapter = adapter
        binding.rvTodos.layoutManager = LinearLayoutManager(this)

        binding.btnAddTodo.setOnClickListener {
            val todoText = binding.etAddTodo.text.toString()
            val todoModel = TodoModel(todoText, false)
            todoList.add(todoModel)
            adapter.notifyItemInserted(todoList.size - 1)
            binding.etAddTodo.text.clear()
        }
    }
}