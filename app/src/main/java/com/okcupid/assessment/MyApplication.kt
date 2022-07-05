package com.okcupid.assessment

import android.app.Application
import com.okcupid.assessment.modules.databaseModule
import com.okcupid.assessment.modules.repositoryModule
import com.okcupid.assessment.modules.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

/**
 * [Application] class used on the project
 */
class MyApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MyApplication)
            modules(databaseModule, repositoryModule, viewModelModule)
        }
    }
}