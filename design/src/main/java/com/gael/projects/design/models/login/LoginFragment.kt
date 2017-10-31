package com.gael.projects.design.models.login

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.gael.projects.design.R
import com.gael.projects.design.models.entities.User
import kotlinx.android.synthetic.main.lib_fragment_login.*

/**
 * Created by gael on 30.10.17.
 */

class LoginFragment : Fragment(), LoginContract.View {

    private var user : User? = null
    lateinit var presenterLogin : LoginContract.Presenter

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
        presenterLogin = mPresenter
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
        val v : View = inflater!!.inflate(R.layout.lib_fragment_login,container,false)
        return v
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        displayMissinfInformations()

        login_btn_login.setOnClickListener(View.OnClickListener { v ->
            presenterLogin.saveUser(User(login_lastname.text.toString(), login_firstname.text.toString(), login_email.text.toString(), login_number.text.toString(), ""))
        })
    }

    private fun displayMissinfInformations() {
        if(user!!.name == null || user!!.name.isEmpty()) {
            login_inputlayout_lastname.visibility = View.VISIBLE
        }

        if(user!!.lastName == null || user!!.lastName.isEmpty()) {
            login_inputlayout_firstname.visibility = View.VISIBLE
        }

        if(user!!.email == null || user!!.email.isEmpty()) {
            login_textinutlayout_email.visibility = View.VISIBLE
        }

        if(user!!.number == null || user!!.number.isEmpty()) {
            login_textinputlayout_number.visibility = View.VISIBLE
        }
    }

}