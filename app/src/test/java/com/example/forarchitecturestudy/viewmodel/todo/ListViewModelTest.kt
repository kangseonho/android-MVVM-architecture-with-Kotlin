package com.example.forarchitecturestudy.viewmodel.todo

import com.example.forarchitecturestudy.ViewModelTest
import com.example.forarchitecturestudy.domain.todo.InsertToDoListUseCase
import com.example.forarchitecturestudy.presentation.list.ListViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.koin.test.inject

@ExperimentalCoroutinesApi
internal class ListViewModelTest: ViewModelTest() {

    private val viewModel: ListViewModel by inject()

    private val insertToDoListUseCase: InsertToDoListUseCase by inject()
    @Before
    fun init() {
        initData()
    }

    private fun initData() = runBlockingTest {  }
}
