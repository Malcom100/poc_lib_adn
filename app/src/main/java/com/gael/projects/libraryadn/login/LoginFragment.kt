package com.gael.projects.libraryadn.login

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.gael.projects.libraryadn.R
import kotlinx.android.synthetic.main.fragment_login.*

/**
 * Created by gael on 30.10.17.
 */
 class LoginFragment : Fragment(), LoginContract.View {

    lateinit var mPresenter : LoginContract.Presenter

    companion object {
        fun newInstance() : LoginFragment { return LoginFragment()
        }
    }

    override fun setPresenter(presenter: LoginContract.Presenter) {
        mPresenter = presenter
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun displayToastLoginError() {
        Toast.makeText(activity,resources.getString(R.string.login_error),Toast.LENGTH_SHORT).show()
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_login,container,false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        login_btn_login.setOnClickListener(View.OnClickListener { v ->
            mPresenter.login(login_lastname.text.toString(),login_lastname.text.toString(),login_email.text.toString(),login_number.text.toString(),"",activity.applicationContext)
        })
    }

}