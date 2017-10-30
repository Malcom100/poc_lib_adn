package com.gael.projects.libraryadn.login

import android.content.Context
import com.gael.projects.libraryadn.BasePresenter
import com.gael.projects.libraryadn.BaseView

/**
 * Created by gael on 30.10.17.
 */

interface LoginContract {
    interface View : BaseView<Presenter> {
        fun displayToastLoginError()
    }
    interface Presenter : BasePresenter {
        fun viewIsNotNull () : Boolean
        fun login(name : String, lastName : String, email : String, number : String, picture : String, context : Context)
    }
}