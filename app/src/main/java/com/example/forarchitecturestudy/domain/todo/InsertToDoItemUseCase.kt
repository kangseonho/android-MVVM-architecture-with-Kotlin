package com.example.forarchitecturestudy.domain.todo

import com.example.forarchitecturestudy.data.entity.ToDoEntity
import com.example.forarchitecturestudy.data.repository.ToDoRepository
import com.example.forarchitecturestudy.domain.UseCase

internal class InsertToDoItemUseCase(
        private val toDoRepository: ToDoRepository
): UseCase {

    suspend operator fun invoke(toDoItem: ToDoEntity) {
        return toDoRepository.insertToDoItem(toDoItem)
    }
}