package vn.sun.asterisk.toeic600.di

import org.koin.android.ext.koin.androidContext
import org.koin.core.qualifier.named
import org.koin.dsl.module
import vn.sun.asterisk.common.KoinTags
import vn.sun.asterisk.toeic600.R

val appModule = module {
    single(named(KoinTags.ANDROID_CONTEXT)) {
        androidContext()
    }

    single(named(KoinTags.PART_PHOTO_RES_IDS)) {
        listOf(
            R.drawable.ic_exam,
            R.drawable.ic_exam,
            R.drawable.ic_exam,
            R.drawable.ic_exam,
            R.drawable.ic_exam,
            R.drawable.ic_exam
        )
    }
}
