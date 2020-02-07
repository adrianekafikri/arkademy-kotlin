package com.arkademy.arkademytraining.week3

import android.content.Context
import android.content.SharedPreferences
import androidx.preference.PreferenceManager

/**
 * Created by adrianfikri on 2020-02-06.
 */
object PreferenceUtils {

    private lateinit var pref: SharedPreferences

    const val KEY_EMAIL = "key_email"
    const val KEY_IS_LOGIN = "key_is_login"

    fun init(context: Context) {
        pref = PreferenceManager.getDefaultSharedPreferences(context)
    }

    fun getEmail(): String? = pref.getString(KEY_EMAIL, "")

    fun putEmail(value: String) {
        pref.edit().putString(KEY_EMAIL, value).apply()
    }

    fun getIsLogin(): Boolean = pref.getBoolean(KEY_IS_LOGIN, false)

    fun saveIsLogin(isLogin: Boolean) {
        pref.edit().putBoolean(KEY_IS_LOGIN, isLogin).apply()
    }
}