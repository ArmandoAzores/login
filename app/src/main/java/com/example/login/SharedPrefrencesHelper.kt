package com.example.login

import android.content.Context
import android.content.SharedPreferences

class SharedPrefrencesHelper(context: Context) {
    private val sharedPreferences: SharedPreferences = context.getSharedPreferences(
        "login_session",
        Context.MODE_PRIVATE
    )
    var firstname = "firstname"
        get() = sharedPreferences.getString(field, "")!!
        set(firstname) {
            val edit = sharedPreferences.edit()
            edit.putString(this.firstname, firstname)
            edit.commit()
        }
    var lastname = "lastname"
        get() = sharedPreferences.getString(field, "")!!
        set(lastname) {
            val edit = sharedPreferences.edit()
            edit.putString(this.lastname, lastname)
            edit.commit()
        }
    var username = "username"
        get() = sharedPreferences.getString(field, "")!!
        set(username) {
            val edit = sharedPreferences.edit()
            edit.putString(this.username, username)
            edit.commit()
        }
    var email = "email"
        get() = sharedPreferences.getString(field, "")!!
        set(email) {
            val edit = sharedPreferences.edit()
            edit.putString(this.email, email)
            edit.commit()
        }

}