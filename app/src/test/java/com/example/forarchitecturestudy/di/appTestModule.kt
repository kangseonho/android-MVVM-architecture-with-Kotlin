package com.example.forarchitecturestudy.di

import com.example.forarchitecturestudy.data.repository.TestToDoRepository
import com.example.forarchitecturestudy.data.repository.ToDoRepository
import com.example.forarchitecturestudy.domain.todo.*
import com.example.forarchitecturestudy.presentation.detail.DetailMode
import com.example.forarchitecturestudy.presentation.detail.DetailViewModel
import com.example.forarchitecturestudy.presentation.list.ListViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

internal val appTestModule = module {

    viewModel { ListViewModel(get(), get(), get())}
    viewModel { (detailMode: DetailMode, id: Long) ->
        DetailViewModel(
                detailMode = detailMode,
                id = id,
                get()
        )
    }

    factory { GetToDoListUseCase(get()) }
    factory { InsertToDoListUseCase(get()) }
    factory { InsertToDoItemUseCase(get()) }
    factory { UpdateToDoListUseCase(get()) }
    factory { GetToDoItemUseCase(get()) }
    factory { DeleteAllToDoListUseCase(get()) }

    single<ToDoRepository> { TestToDoRepository() }
}