package com.gael.projects.design.models.login

/**
 * Created by gael on 30.10.17.
 */

class LoginPresenter (mView : LoginContract.View): LoginContract.Presenter {

    lateinit var view : LoginContract.View
    init {
        view = mView
        view.setPresenter(this)
    }

}