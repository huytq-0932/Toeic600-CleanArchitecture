package vn.sun.asterisk.data.di

import org.koin.dsl.module
import vn.sun.asterisk.data.repository.CategoryRepositoryImpl
import vn.sun.asterisk.data.repository.PartRepositoryImpl
import vn.sun.asterisk.data.repository.TopicRepositoryImpl
import vn.sun.asterisk.domain.repository.CategoryRepository
import vn.sun.asterisk.domain.repository.PartRepository
import vn.sun.asterisk.domain.repository.TopicRepository

val dataModule = module {

    single<CategoryRepository> {
        CategoryRepositoryImpl(categoryDataSource = get(), topicDataSource = get())
    }

    single<TopicRepository> {
        TopicRepositoryImpl(topicDataSource = get())
    }

    single<PartRepository> {
        PartRepositoryImpl(dataSource = get())
    }
}
