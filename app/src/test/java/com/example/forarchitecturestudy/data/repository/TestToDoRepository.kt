package com.example.forarchitecturestudy.data.repository

import com.example.forarchitecturestudy.data.entity.ToDoEntity

class TestToDoRepository: ToDoRepository {

    private val toDoList: MutableList<ToDoEntity> = mutableListOf()

    override suspend fun getToDoList(): List<ToDoEntity> {
        return toDoList
    }

    override suspend fun insertToDoList(toDoList: List<ToDoEntity>) {
        this.toDoList.addAll(toDoList)
    }

    override suspend fun insertToDoItem(toDoItem: ToDoEntity) {
        this.toDoList.add(toDoItem)
    }

    override suspend fun updateToDoItem(toDoItem: ToDoEntity): Boolean {
        val foundToDoEntity = toDoList.find { it.id == toDoItem.id }
        if (foundToDoEntity == null) {
            return false
        } else {
            this.toDoList[toDoList.indexOf(foundToDoEntity)] = toDoItem
            return true
        }
    }

    override suspend fun deleteAllToDoItem() {
        toDoList.clear()
    }

    override suspend fun getToDoItem(itemId: Long): ToDoEntity? {
        return toDoList.find { it.id == itemId }
    }
}