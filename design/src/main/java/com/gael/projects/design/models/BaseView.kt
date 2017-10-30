package com.gael.projects.design.models

/**
 * Created by gael on 30.10.17.
 */

interface BaseView<T> {
    fun setPresenter(mPresenter : T)
}