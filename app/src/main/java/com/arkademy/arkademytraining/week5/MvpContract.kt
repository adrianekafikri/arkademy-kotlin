package com.arkademy.arkademytraining.week5

/**
 * Created by adrianfikri on 2020-02-18.
 */
interface MvpContract {

    interface View {
        fun updateName(name: String)
    }

    interface Presenter {
        fun saveName(name: String)
    }
}