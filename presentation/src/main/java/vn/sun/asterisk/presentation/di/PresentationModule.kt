package vn.sun.asterisk.presentation.di

import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import vn.sun.asterisk.presentation.viewmodel.CategoryViewModel
import vn.sun.asterisk.presentation.viewmodel.MainViewModel

val presentationModule = module {
    viewModel {
        MainViewModel()
    }

    viewModel {
        CategoryViewModel()
    }
}