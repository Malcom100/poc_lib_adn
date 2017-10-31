package com.gael.projects.design.models.login

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.gael.projects.design.R
import com.gael.projects.design.models.entities.User

/**
 * Created by gael on 30.10.17.
 */

class LoginActivity : AppCompatActivity() {

    lateinit var loginPresenter : LoginContract.Presenter

    companion object {
        val KEY_USER = "key_lib_user"

        fun newIntent(cxt : Context,user : User) : Intent {
            var intent : Intent = Intent(cxt,LoginActivity::class.java)
            intent.putExtra(KEY_USER,user)
            return intent
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        var fragment : LoginFragment? = supportFragmentManager.findFragmentById(R.id.container) as? LoginFragment
        if(fragment == null){
            fragment = LoginFragment.newInstance(getUser(intent))
        }
        supportFragmentManager.beginTransaction().add(R.id.container,fragment,"").commit()

        loginPresenter = LoginPresenter(fragment)
    }

    private fun getUser(intent : Intent) : User {
        var user : User? = null
        if(intent != null && intent.hasExtra(LoginActivity.KEY_USER)){
            user = intent.getParcelableExtra<User>(LoginActivity.KEY_USER)
        }
        return user!!
    }
}