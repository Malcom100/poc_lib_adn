package com.gael.projects.design.models.login

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.gael.projects.design.R
import com.gael.projects.design.models.User

/**
 * Created by gael on 30.10.17.
 */

class LoginFragment : Fragment(), LoginContract.View {

    private var user : User? = null
    lateinit var presnterLogin : LoginContract.Presenter

    companion object {

        fun newInstance(user : User) : LoginFragment{
            var fragment = LoginFragment()
            var arguments : Bundle = Bundle()
            arguments.putParcelable(LoginActivity.KEY_USER,user)
            fragment.arguments = arguments
            return fragment
        }
    }

    override fun setPresenter(mPresenter: LoginContract.Presenter) {
        presnterLogin = mPresenter
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setUser(arguments)
    }

    private fun setUser(arguments : Bundle){
        if(arguments != null && arguments.containsKey(LoginActivity.KEY_USER)){
            user = arguments.getParcelable(LoginActivity.KEY_USER)
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_login,container,false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

}