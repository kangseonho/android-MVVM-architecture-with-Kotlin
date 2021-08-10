package com.example.forarchitecturestudy.presentation.list

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.forarchitecturestudy.data.entity.ToDoEntity
import com.example.forarchitecturestudy.domain.todo.DeleteAllToDoListUseCase
import com.example.forarchitecturestudy.domain.todo.GetToDoListUseCase
import com.example.forarchitecturestudy.domain.todo.UpdateToDoListUseCase
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

internal class ListViewModel(
        private val getToDoListUseCase: GetToDoListUseCase,
        private val updateToDoUseCase: UpdateToDoListUseCase,
        private val deleteAllToDoListUseCase: DeleteAllToDoListUseCase
): ViewModel() {
        private var _toDoListLiveData = MutableLiveData<List<ToDoEntity>>()
        val todoListLiveData: LiveData<List<ToDoEntity>> = _toDoListLiveData

        fun fetchData(): Job = viewModelScope.launch {
                _toDoListLiveData.postValue(getToDoListUseCase())
        }

        fun updateEntity(toDoEntity: ToDoEntity) = viewModelScope.launch {
                updateToDoUseCase(toDoEntity)
        }

        fun deleteAll() = viewModelScope.launch {
                deleteAllToDoListUseCase()
                _toDoListLiveData.postValue(listOf())
        }
}