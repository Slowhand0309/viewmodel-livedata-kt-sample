package com.slowhand.kt

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.slowhand.kt.di.KoinModule
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.koin.test.KoinTest
import org.koin.test.checkModules

class KoinModuleTest: KoinTest {

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    @Test
    fun `dry run`(){
        checkModules(listOf(KoinModule.module()))
    }
}