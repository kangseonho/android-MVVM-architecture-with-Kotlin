package com.example.forarchitecturestudy.presentation.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.forarchitecturestudy.domain.todo.GetToDoItemUseCase
import com.example.forarchitecturestudy.presentation.BaseViewModel
import com.example.forarchitecturestudy.presentation.list.ToDoListState
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

internal class DetailViewModel(
        var detailMode: DetailMode,
        var id: Long = -1,
        private val getToDoItemUseCase: GetToDoItemUseCase
): BaseViewModel() {

    private var _toDoDetailLiveData = MutableLiveData<ToDoDetailState>(ToDoDetailState.UnInitialized)
    var toDoDetailLiveData: LiveData<ToDoDetailState> = _toDoDetailLiveData

    override fun fetchData(): Job = viewModelScope.launch{
        when (detailMode) {
            DetailMode.WRITE -> {

            }
            DetailMode.DETAIL -> {
                _toDoDetailLiveData.postValue(ToDoDetailState.Loading)
                try {
                    getToDoItemUseCase(id)?.let {
                        _toDoDetailLiveData.postValue(ToDoDetailState.Success(it))
                    }?: kotlin.run{
                        _toDoDetailLiveData.postValue(ToDoDetailState.Error )
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                    _toDoDetailLiveData.postValue(ToDoDetailState.Error)
                }
            }
        }
    }
}