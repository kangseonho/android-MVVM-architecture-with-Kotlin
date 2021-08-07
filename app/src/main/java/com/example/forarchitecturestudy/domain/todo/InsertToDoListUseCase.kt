package com.example.forarchitecturestudy.domain.todo

import com.example.forarchitecturestudy.data.repository.ToDoRepository
import com.example.forarchitecturestudy.domain.UseCase

internal class InsertToDoListUseCase(
        private val toDoRepository: ToDoRepository
): UseCase {
}