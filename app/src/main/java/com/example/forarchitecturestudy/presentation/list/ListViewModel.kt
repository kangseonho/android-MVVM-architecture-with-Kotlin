package com.example.forarchitecturestudy.presentation.list

import androidx.lifecycle.ViewModel
import com.example.forarchitecturestudy.domain.todo.GetToDoListUseCase

internal class ListViewModel(
        private val getToDoListUseCase: GetToDoListUseCase
): ViewModel() {
}