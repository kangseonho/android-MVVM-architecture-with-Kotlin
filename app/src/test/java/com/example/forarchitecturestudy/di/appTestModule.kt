package com.example.forarchitecturestudy.di

import com.example.forarchitecturestudy.data.repository.TestToDoRepository
import com.example.forarchitecturestudy.data.repository.ToDoRepository
import com.example.forarchitecturestudy.domain.todo.GetToDoItemUseCase
import com.example.forarchitecturestudy.domain.todo.GetToDoListUseCase
import com.example.forarchitecturestudy.domain.todo.InsertToDoListUseCase
import com.example.forarchitecturestudy.domain.todo.UpdateToDoListUseCase
import com.example.forarchitecturestudy.presentation.list.ListViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

internal val appTestModule = module {

    viewModel { ListViewModel(get(), get())}

    factory { GetToDoListUseCase(get()) }
    factory { InsertToDoListUseCase(get()) }
    factory { UpdateToDoListUseCase(get()) }
    factory { GetToDoItemUseCase(get()) }

    single<ToDoRepository> { TestToDoRepository() }
}