package com.example.forarchitecturestudy.presentation.list

import com.example.forarchitecturestudy.data.entity.ToDoEntity

sealed class ToDoListState {

    object UnInitialized: ToDoListState()

    object Loading: ToDoListState()

    data class Success(
            val toDoList: List<ToDoEntity>
    ): ToDoListState()

    object Error: ToDoListState()
}
