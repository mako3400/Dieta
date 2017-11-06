package pl.com.example.dietplus

import android.app.Application


/**
 * Domyślna klasa aplikacji
 */
class App : Application() {

    override fun onCreate() {
        super.onCreate()
        appContext = this
    }

    companion object {
        lateinit var appContext:App
    }
}