package com.example.forarchitecturestudy.presentation.detail

import com.example.forarchitecturestudy.data.entity.ToDoEntity
import com.example.forarchitecturestudy.presentation.list.ToDoListState

sealed class ToDoDetailState {
    object UnInitialized: ToDoDetailState()

    object Loading: ToDoDetailState()

    data class Success(
            val toDoItem: ToDoEntity
    ): ToDoDetailState()

    object Delete: ToDoDetailState()

    object Modify: ToDoDetailState()

    object Write: ToDoDetailState()

    object Error: ToDoDetailState()
}