package com.example.forarchitecturestudy.presentation.list

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
        private var _toDoListLiveData = MutableLiveData<ToDoListState>(ToDoListState.UnInitialized)
        val todoListLiveData: LiveData<ToDoListState> = _toDoListLiveData

        fun fetchData(): Job = viewModelScope.launch {
                _toDoListLiveData.postValue(ToDoListState.Loading)
                _toDoListLiveData.postValue(ToDoListState.Success(getToDoListUseCase()))
        }

        fun updateEntity(toDoEntity: ToDoEntity) = viewModelScope.launch {
                updateToDoUseCase(toDoEntity)
        }

        fun deleteAll() = viewModelScope.launch {
                _toDoListLiveData.postValue(ToDoListState.Loading)
                deleteAllToDoListUseCase()
                _toDoListLiveData.postValue(ToDoListState.Success(getToDoListUseCase()))
        }
}