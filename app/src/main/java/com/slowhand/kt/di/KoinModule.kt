package com.slowhand.kt.di

import com.slowhand.kt.repository.UserRepository
import com.slowhand.kt.ui.list.ListViewModel
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

object KoinModule {
    fun module() = module {

        // viewModelのinjection
        viewModel { ListViewModel(get()) }

        // singleton 同じインスタンスを使う
        single { UserRepository() }
    }
}