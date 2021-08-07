package com.example.forarchitecturestudy.data.repository

import com.example.forarchitecturestudy.data.entity.ToDoEntity

interface ToDoRepository {

    suspend fun getToDoList(): List<ToDoEntity>

    suspend fun insertToDoList(toDoList: List<ToDoEntity>)
}