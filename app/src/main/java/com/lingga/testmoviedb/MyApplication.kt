package com.lingga.testmoviedb

import android.app.Application
import com.lingga.testmoviedb.core.di.databaseModule
import com.lingga.testmoviedb.core.di.networkModule
import com.lingga.testmoviedb.core.di.repositoryModule
import com.lingga.testmoviedb.di.useCaseModule
import com.lingga.testmoviedb.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@MyApplication)
            modules(
                listOf(
                    databaseModule,
                    networkModule,
                    repositoryModule,
                    useCaseModule,
                    viewModelModule
                )
            )
        }
    }
}