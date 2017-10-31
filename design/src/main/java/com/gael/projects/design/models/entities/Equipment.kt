package com.gael.projects.design.models.entities

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by gael on 31.10.17.
 */

class Equipment() : Parcelable{

    var name : String = ""
    var comment : String = ""
    var picture : String = ""
    var validate : Boolean = false

    constructor(parcel: Parcel) : this() {
        name = parcel.readString()
        comment = parcel.readString()
        picture = parcel.readString()
        validate = parcel.readByte() != 0.toByte()
    }

    override fun toString() : String {
        return name.plus(" ").plus(comment).plus(" - ").plus(validate)
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(comment)
        parcel.writeString(picture)
        parcel.writeByte(if (validate) 1 else 0)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Equipment> {
        override fun createFromParcel(parcel: Parcel): Equipment {
            return Equipment(parcel)
        }

        override fun newArray(size: Int): Array<Equipment?> {
            return arrayOfNulls(size)
        }
    }
}