package com.gael.projects.design.models

import android.content.Context
import com.gael.projects.design.models.entities.LibraryFacade
import com.gael.projects.design.models.exceptions.LibraryException

/**
 * Created on 31.10.17.
 */

class LibraryAdn {

    companion object {

        private var instance : LibraryFacade? = null

        /**
         * pattern @singleton, only instance
         */
        fun initialize(cxt : Context){
            if(instance == null){
                instance = LibraryFacade(cxt)
            }
        }

        fun getInstanceLibraryAdn() : LibraryFacade {
            if(instance == null){
                throw LibraryException ("instance cannot be null ")
            }
            return instance!!
        }
    }
}