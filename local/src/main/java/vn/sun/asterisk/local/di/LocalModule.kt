package vn.sun.asterisk.local.di

import org.koin.core.qualifier.named
import org.koin.dsl.module
import vn.sun.asterisk.common.KoinTags
import vn.sun.asterisk.data.data.source.CategoryDataSource
import vn.sun.asterisk.data.data.source.PartDataSource
import vn.sun.asterisk.data.data.source.TopicDataSource
import vn.sun.asterisk.local.data.source.CategoryDataSourceImpl
import vn.sun.asterisk.local.data.source.PartDataSourceImpl
import vn.sun.asterisk.local.data.source.TopicDataSourceImpl
import vn.sun.asterisk.local.db.AppDatabase

val localModule = module {

    single {
        AppDatabase.getDatabase(context = get(named(KoinTags.ANDROID_CONTEXT)))
    }

    single<CategoryDataSource> {
        CategoryDataSourceImpl(database = get())
    }

    single<TopicDataSource> {
        TopicDataSourceImpl(database = get())
    }

    single<PartDataSource> {
        PartDataSourceImpl(database = get())
    }
}
