package com.bobbyprabowo.benchmarktest

import android.app.Application
import android.content.Context
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

        val sharedPref = getSharedPreferences("benchmark-app",Context.MODE_PRIVATE)
        with(sharedPref.edit()) {
            (1..100).forEach {
                putString("key + ${it.toString()}", it.toString())
            }
            apply()
        }
    }
}
