package com.gael.projects.design.models

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by gael on 30.10.17.
 */


class User() : Parcelable{


    var name : String = ""
    var lastName : String = ""
    var email : String = ""
    var number : String = ""
    var picture : String = ""

    constructor(parcel: Parcel) : this() {
        name = parcel.readString()
        lastName = parcel.readString()
        email = parcel.readString()
        number = parcel.readString()
        picture = parcel.readString()
    }


    constructor(name :String, lastName : String, email : String, number : String, picture : String) : this() {
        this.name = name
        this.lastName = lastName
        this.email = email
        this.number = number
        this.picture = picture
    }

    constructor(userBuilder : UserBuilder) : this() {
        this.name = userBuilder.name
    }

    class UserBuilder {

        var name : String = ""
        var lastName : String = ""
        var email : String = ""
        var number : String = ""
        var picture : String = ""

        fun addName(newName : String) : UserBuilder{
            name = newName
            return this
        }

        fun addLastName(newLastName : String) : UserBuilder{
            lastName = newLastName
            return this
        }

        fun addEmail(newEmail : String) : UserBuilder{
            email = newEmail
            return this
        }

        fun addNUmber(newNumber : String) : UserBuilder{
            number = newNumber
            return this
        }

        fun addPicture(newpicture : String) : UserBuilder{
            picture = newpicture
            return this
        }

        fun build() : User {
            return User(this)
        }
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(lastName)
        parcel.writeString(email)
        parcel.writeString(number)
        parcel.writeString(picture)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<User> {
        override fun createFromParcel(parcel: Parcel): User {
            return User(parcel)
        }

        override fun newArray(size: Int): Array<User?> {
            return arrayOfNulls(size)
        }
    }

}