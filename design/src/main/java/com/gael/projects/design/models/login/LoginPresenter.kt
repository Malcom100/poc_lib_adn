package com.gael.projects.design.models.login

import com.gael.projects.design.models.entities.User
import com.gael.projects.design.models.utils.LibraryBuilder

/**
 * Created by gael on 30.10.17.
 */

class LoginPresenter (mView : LoginContract.View): LoginContract.Presenter {

    lateinit var view : LoginContract.View
    init {
        view = mView
        view.setPresenter(this)
    }

    override fun saveUser(user: User) {
        /*LibraryBuilder.getInstance().user.name = user.name
        LibraryBuilder.getInstance().user.lastName = user.lastName
        LibraryBuilder.getInstance().user.email = user.email
        LibraryBuilder.getInstance().user.number = user.number*/

        LibraryBuilder.getInstance().setUserName(user.name)
        LibraryBuilder.getInstance().setEmail(user.email)

        LibraryBuilder.getInstance().getUser().email = "vfxvxc"
    }
}