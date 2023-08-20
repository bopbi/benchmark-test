package com.bobbyprabowo.benchmarktest

import android.app.Application
import android.os.StrictMode

class MainApplication : Application() {

    override fun onCreate() {
        StrictMode.setThreadPolicy(
            StrictMode.ThreadPolicy.Builder()
            .detectDiskReads()
            .detectDiskWrites()
            .detectNetwork()   // or .detectAll() for all detectable problems
            .penaltyLog()
            .build()
        )
        StrictMode.setVmPolicy(
            StrictMode.VmPolicy.Builder()
            .detectLeakedSqlLiteObjects()
            .detectLeakedClosableObjects()
            .penaltyLog()
            .penaltyDeath()
            .build()
        )
        super.onCreate()
    }
}
