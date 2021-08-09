package com.example.forarchitecturestudy.domain.todo

import com.example.forarchitecturestudy.data.entity.ToDoEntity
import com.example.forarchitecturestudy.data.repository.ToDoRepository
import com.example.forarchitecturestudy.domain.UseCase

internal class GetToDoItemUseCase(
    private val toDoRepository: ToDoRepository
): UseCase {

    suspend operator fun invoke(itemId: Long): ToDoEntity? {
        return toDoRepository.getToDoItem(itemId)
    }
}