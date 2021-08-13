package com.example.forarchitecturestudy.viewmodel.todo

import com.example.forarchitecturestudy.ViewModelTest
import com.example.forarchitecturestudy.data.entity.ToDoEntity
import com.example.forarchitecturestudy.domain.todo.InsertToDoItemUseCase
import com.example.forarchitecturestudy.presentation.detail.DetailMode
import com.example.forarchitecturestudy.presentation.detail.DetailViewModel
import com.example.forarchitecturestudy.presentation.detail.ToDoDetailState
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Test
import org.koin.core.parameter.parametersOf
import org.koin.test.inject

@ExperimentalCoroutinesApi
internal class DetailViewModelTest: ViewModelTest() {

    private val id = 1L

    private val detailViewModel by inject<DetailViewModel> { parametersOf(DetailMode.DETAIL, id)}

    private val insertToDoUseCase: InsertToDoItemUseCase by inject()

    private val todo = ToDoEntity(
            id= id,
            title = "title $id",
            description = "description $id",
            hasCompleted = false
    )

    @Before
    fun init() {
        initData()
    }

    private fun initData() = runBlockingTest {
        insertToDoUseCase(todo)
    }

    @Test
    fun `test viewModel fetch`() = runBlockingTest {
        val testObservable = detailViewModel.toDoDetailLiveData.test()

        detailViewModel.fetchData()

        testObservable.assertValueSequence(
                listOf(
                        ToDoDetailState.UnInitialized,
                        ToDoDetailState.Loading,
                        ToDoDetailState.Success(todo)
                )
        )
    }

}