    package com.gael.projects.libraryadn.login

    import android.content.Context
    import android.util.Log
    import com.gael.projects.design.models.LibraryAdn
    import com.gael.projects.design.models.exceptions.LibraryException

    /**
     * Created by gael on 30.10.17.
     */

    class LoginPresenter(mView: LoginContract.View) : LoginContract.Presenter {

        lateinit var view : LoginContract.View
        init {
            view = mView
            view.setPresenter(this)
        }
        override fun viewIsNotNull(): Boolean {
            return view != null
        }

        override fun login(name: String, lastName: String, email: String, number: String, picture: String, context : Context) {
            try{
                //LibraryAdn.initialize(context)
                LibraryAdn.getInstanceLibraryAdn().createUser(name,lastName,email,number,picture)
                //LibraryAdn.getInstanceLibraryAdn().showMissingInformations()
            }catch (e : LibraryException) {
                e.printStackTrace()
                Log.e("E",e.message)
            }
            }
        }
