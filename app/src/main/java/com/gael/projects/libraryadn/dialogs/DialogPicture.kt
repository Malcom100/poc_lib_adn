package com.gael.projects.libraryadn.dialogs

import android.app.Dialog
import android.content.Context
import android.view.View
import android.widget.LinearLayout
import com.gael.projects.libraryadn.R
import com.gael.projects.libraryadn.interfaces.IPicture
import kotlinx.android.synthetic.main.dialog_picture.*

/**
 * Created on 31.10.17.
 */

class DialogPicture (context: Context, ressourceId : Int, iPicture : IPicture): Dialog(context), View.OnClickListener{

    var cxt : Context
    private var viewId : Int
    private lateinit var callback : IPicture
    init {
        cxt = context
        viewId = ressourceId
        callback = iPicture

        this.setContentView(viewId)

        initializeView()

        this.show()
    }

    private fun initializeView(){
        var photo : LinearLayout = this.findViewById(R.id.picture_layout_photo)
        var gallery : LinearLayout = this.findViewById(R.id.picture_layout_gallery)

        photo.setOnClickListener(this)
        gallery.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v!!.id) {
            R.id.picture_layout_photo -> {
                callback.takePhoto()
            }
            R.id.picture_layout_gallery -> {
                callback.openGallery()
            }
        }
    }

}