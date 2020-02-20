package com.arkademy.arkademytraining.week4

/**
 * Created by adrianfikri on 2020-02-18.
 */
interface WordListContract {

    interface View {
        fun updateItems(list: List<WordRoomEntity>)
    }

    interface Presenter {
        fun bindToView(view: View)
        fun unbind()
        fun populateList()
    }
}