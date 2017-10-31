package com.gael.projects.design.models.entities

import android.content.Context
import com.gael.projects.design.models.exceptions.LibraryException
import com.gael.projects.design.models.login.LoginActivity

/**
 * The @LibraryFacade
 * Created on 31.10.17.
 */

class LibraryFacade (cxt : Context) {

    private lateinit var context : Context
    init {
        context = cxt
    }

    /**
     * This properties are hidden to client
     */
    private var user : User? = null
    private var equipment : Equipment? = null


    fun createUser(name :String, lastName : String, email : String, number : String, picture : String) {
        user = User.UserBuilder()
                .addName(name)
                .addLastName(lastName)
                .addEmail(email)
                .addEmail(number)
                .addPicture(picture)
                .build()

        showMissingInformations()
    }

    /**
     * @exception : throw exception if @user is null
     */
    fun showMissingInformations() {
        if(user == null) {
            throw LibraryException(" user cannot be null")
        }
        if(user!!.name.isEmpty() || user!!.lastName.isEmpty() || user!!.email.isEmpty() || user!!.number.isEmpty() || user!!.picture.isEmpty()) {
            context!!.startActivity(LoginActivity.newIntent(context!!,user!!))
        }
    }

    fun createEquipment() {

    }

    fun getUser() : User {
        return user!!
    }

    fun getEquipment() : Equipment {
        return equipment!!
    }
}