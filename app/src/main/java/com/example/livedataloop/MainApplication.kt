package com.example.livedataloop

import android.app.Application
import timber.log.Timber

/**
 * Created by andre
on 2018/06/15.
 */
class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}