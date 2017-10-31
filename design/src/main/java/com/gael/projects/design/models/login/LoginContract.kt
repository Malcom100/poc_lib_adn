package com.gael.projects.design.models.login

import com.gael.projects.design.models.BasePresenter
import com.gael.projects.design.models.BaseView
import com.gael.projects.design.models.entities.User

/**
 * Created by gael on 30.10.17.
 */

interface LoginContract {

    interface View : BaseView<Presenter>{}
    interface Presenter : BasePresenter{
        fun saveUser(user : User)
    }
}