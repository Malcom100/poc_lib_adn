package com.gael.projects.libraryadn.utils

import android.content.Intent

/**
 * Created by gael on 31.10.17.
 */

class PictureUtils {

    companion object {

        val REQUEST_GALLERY = 987

        fun intentGallery() : Intent{
            var intent : Intent = Intent()
            intent.setAction(android.content.Intent.ACTION_GET_CONTENT)
            intent.setType("image/*")
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            return intent
        }
    }
}