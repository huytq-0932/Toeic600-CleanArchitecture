package vn.sun.asterisk.presentation.di

import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import vn.sun.asterisk.presentation.viewmodel.*

val presentationModule = module {
    viewModel {
        MainViewModel()
    }

    viewModel {
        CategoryViewModel(getCategoriesUseCase = get())
    }

    viewModel {
        StudyViewModel()
    }

    viewModel {
        HomeViewModel()
    }

    viewModel {
        TestSkillsViewModel()
    }
}
