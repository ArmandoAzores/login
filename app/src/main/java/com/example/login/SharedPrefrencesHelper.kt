package com.example.login

import android.content.Context
import android.content.SharedPreferences

class SharedPrefrencesHelper(context: Context) {
    private val sharedPreferences: SharedPreferences = context.getSharedPreferences(
        "login_session",
        Context.MODE_PRIVATE
    )
    var firstname:String? = "firstname"
        get() = sharedPreferences.getString(field, "")!!
        set(firstname) {
            val edit = sharedPreferences.edit()
            edit.putString(this.firstname, firstname)
            edit.apply()
        }
    var lastname:String? = "lastname"
        get() = sharedPreferences.getString(field, "")!!
        set(lastname) {
            val edit = sharedPreferences.edit()
            edit.putString(this.lastname, lastname)
            edit.apply()
        }
    var username:String? = "username"
        get() = sharedPreferences.getString(field, "")!!
        set(username) {
            val edit = sharedPreferences.edit()
            edit.putString(this.username, username)
            edit.apply()
        }
    var email:String? = "email"
        get() = sharedPreferences.getString(field, "")!!
        set(email) {
            val edit = sharedPreferences.edit()
            edit.putString(this.email, email)
            edit.apply()
        }

}