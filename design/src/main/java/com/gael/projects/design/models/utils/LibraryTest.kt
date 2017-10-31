package com.gael.projects.design.models.utils

import android.content.Context
import com.gael.projects.design.models.entities.User
import com.gael.projects.design.models.login.LoginActivity

/**
 * Created by gael on 30.10.17.
 */

open class LibraryBuilder {

    private lateinit var user : User

    companion object {
        private var instance_library : LibraryBuilder? = null

        /**
         * create @Library if NULL
         */
        fun initialize() {
            if(instance_library == null) {
                instance_library = LibraryBuilder()
            }
        }

        fun getInstance() : LibraryBuilder {
            initialize()
            return this.instance_library!!
        }
    }

    /**
     * create user without parameters
     */
    fun defaultUser() {
        user = User()
    }

    /**
     * ccreate user without parameters
     */
    fun createUser(name :String, lastName : String, email : String, number : String, picture : String, context : Context) {
        user = User.UserBuilder()
                .addName(name)
                .addLastName(lastName)
                .addEmail(email)
                .addEmail(number)
                .addPicture(picture)
                .build()
        if(name.isEmpty() || lastName.isEmpty() || email.isEmpty() || number.isEmpty() || picture.isEmpty()) {
            context.startActivity(LoginActivity.newIntent(context,user))

        }

    }

    fun getUser() : User { return user}

    fun setUserName(newValue : String) : Boolean {
        if(user == null){
            return false
        }
        user.name = newValue
        return true
    }

    fun setEmail(newValue : String) : Boolean {
        if(user == null){
            return false
        }
        user.email = newValue
        return true
    }
}