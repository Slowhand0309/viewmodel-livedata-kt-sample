package com.slowhand.kt

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.slowhand.kt.di.KoinModule
import com.slowhand.kt.ui.list.ListViewModel
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.koin.standalone.StandAloneContext.startKoin
import org.koin.standalone.inject
import org.koin.test.KoinTest
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import repository.data.User

class ListViewModelTest: KoinTest {

    private val viewModel: ListViewModel by inject()

    @Mock
    lateinit var userData: Observer<List<User>>

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    @Before
    fun before() {
        MockitoAnnotations.initMocks(this)
        startKoin(listOf(KoinModule.module()))
    }

    @Test
    fun testUserList() {

        // Observe
        viewModel.getUsersLiveData().observeForever(userData)
        // 初期データチェック
        Assert.assertNotNull(viewModel.getUsersLiveData().value)
    }
}