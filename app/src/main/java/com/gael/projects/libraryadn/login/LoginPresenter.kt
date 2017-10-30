package com.gael.projects.libraryadn.login

import android.content.Context
import com.gael.projects.design.models.utils.LibraryBuilder

/**
 * Created by gael on 30.10.17.
 */

class LoginPresenter(mView: LoginContract.View) : LoginContract.Presenter {

    lateinit var view : LoginContract.View
    init {
        view = mView
        view.setPresenter(this)
    }
    override fun viewIsNotNull(): Boolean {
        return view != null
    }

    override fun login(name: String, lastName: String, email: String, number: String, picture: String, context : Context) {
            LibraryBuilder.getInstance().createUser(name,lastName,email,number,picture,context)
        }
    }
