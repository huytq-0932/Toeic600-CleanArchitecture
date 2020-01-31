package vn.sun.asterisk.domain.di

import org.koin.dsl.module
import vn.sun.asterisk.domain.model.Category
import vn.sun.asterisk.domain.model.Part
import vn.sun.asterisk.domain.use.case.GetCategoriesUseCaseImpl
import vn.sun.asterisk.domain.use.case.GetPartsUseCaseImpl
import vn.sun.asterisk.domain.use.case.UseCaseNoParam

val domainModule = module {

    single<UseCaseNoParam<List<Category>>> {
        GetCategoriesUseCaseImpl(repository = get())
    }

    single<UseCaseNoParam<List<Part>>> {
        GetPartsUseCaseImpl(repository = get())
    }
}
