package com.gael.projects.libraryadn

import android.app.Application
import com.gael.projects.design.models.LibraryAdn

/**
 * Created on 31.10.17.
 */

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        //instanciate the library
        LibraryAdn.initialize(applicationContext)
    }
}