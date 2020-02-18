package com.arkademy.arkademytraining.week4

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * Created by adrianfikri on 2020-02-18.
 */
class WordListPresenter(private val view: WordListContract.View,
                        private val coroutineScope: CoroutineScope,
                        private val database: WordRoomDatabase) : WordListContract.Presenter {

    override fun populateList() {
        coroutineScope.launch {
            val wordDao = database.wordDao()
            val list = wordDao.getAllWord()
            withContext(Dispatchers.Main) {
                view.updateItems(list)
            }
        }
    }
}