package com.gael.projects.libraryadn

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment


import com.gael.projects.libraryadn.login.LoginContract
import com.gael.projects.libraryadn.login.LoginFragment
import com.gael.projects.libraryadn.login.LoginPresenter

class MainActivity : AppCompatActivity() {

    lateinit var  presenterLogin : LoginContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var fragment : LoginFragment? = supportFragmentManager.findFragmentById(R.id.container) as? LoginFragment
        if(fragment == null){
            fragment = LoginFragment.newInstance()
            supportFragmentManager.beginTransaction().add(R.id.container,fragment,"").commit()
        }
        presenterLogin = LoginPresenter(fragment)
    }
}
