package com.example.forarchitecturestudy.viewmodel.todo

import com.example.forarchitecturestudy.ViewModelTest
import com.example.forarchitecturestudy.data.entity.ToDoEntity
import com.example.forarchitecturestudy.domain.todo.GetToDoItemUseCase
import com.example.forarchitecturestudy.domain.todo.InsertToDoListUseCase
import com.example.forarchitecturestudy.presentation.list.ListViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Test
import org.koin.test.inject

@ExperimentalCoroutinesApi
internal class ListViewModelTest: ViewModelTest() {

    private val viewModel: ListViewModel by inject()

    private val insertToDoListUseCase: InsertToDoListUseCase by inject()

    private val getToDoItemUseCase : GetToDoItemUseCase by inject()

    private val mockList = (0 until 10).map {
        ToDoEntity(
            id = it.toLong(),
            title = "title $it",
            description = "decription $it",
            hasCompleted = false
        )
    }

    @Before
    fun init() {
        initData()
    }

    private fun initData() = runBlockingTest {
        insertToDoListUseCase(mockList)
    }

    @Test
    fun `test viewModel fetch`(): Unit = runBlockingTest {
        val testObserverable = viewModel.todoListLiveData.test()
        viewModel.fetchData()
        testObserverable.assertValueSequence(
            listOf(
                mockList
            )
        )
    }

    @Test
    fun `test Item Update`(): Unit = runBlockingTest {
        val todo = ToDoEntity(
            id = 1,
            title = "title 1",
            description = "decription 1",
            hasCompleted = true
        )
        viewModel.updateEntity(todo)
        assert(getToDoItemUseCase(todo.id)?.hasCompleted?:false == todo.hasCompleted )
    }

    @Test
    fun `test Item Delete All`(): Unit = runBlockingTest {
        val testObserverable = viewModel.todoListLiveData.test()
        viewModel.deleteAll()
        testObserverable.assertValueSequence(
                listOf(
                        mockList,
                        listOf()
                )
        )
    }
}
