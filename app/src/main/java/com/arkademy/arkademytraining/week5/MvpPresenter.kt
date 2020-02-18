package com.arkademy.arkademytraining.week5

import android.content.SharedPreferences

/**
 * Created by adrianfikri on 2020-02-18.
 */
class MvpPresenter(private val view: MvpContract.View,
                   private val preference: SharedPreferences) : MvpContract.Presenter {

    private var name = ". . . . . ."

    companion object {
        const val KEY_NAME = "key_name"
    }

    override fun saveName(name: String) {
        preference.edit().putString(KEY_NAME, name).apply()
        this.name = preference.getString(KEY_NAME, "") ?: ". . . . . ."
        view.updateName(name)
    }
}