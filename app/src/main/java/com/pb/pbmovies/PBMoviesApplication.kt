package com.pb.pbmovies

import android.app.Application
import com.pb.pbmovies.data.dataModule
import com.pb.pbmovies.domain.domainModule
import com.pb.pbmovies.ui.uiModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin
import org.koin.core.logger.Level

class PBMoviesApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin()
    }

    private fun startKoin() = startKoin {
        androidLogger(Level.DEBUG)
        androidContext(this@PBMoviesApplication)
        modules(dataModule + domainModule + uiModule)
    }
}
