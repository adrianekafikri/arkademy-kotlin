package com.arkademy.arkademytraining.week4

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.arkademy.arkademytraining.R
import com.arkademy.arkademytraining.databinding.ActivityWordListBinding
import com.arkademy.arkademytraining.week4.AddWordActivity.Companion.ADD_WORD_REQUEST_CODE
import kotlinx.coroutines.*

/**
 * Created by adrianfikri on 2020-02-08.
 * Room implementation
 */
class WordListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWordListBinding
    private lateinit var coroutineScope: CoroutineScope

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_word_list)

        coroutineScope = CoroutineScope(Job() + Dispatchers.IO)

        binding.rvWords.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        binding.rvWords.adapter = WordListAdapter()

        binding.btnAddWord.setOnClickListener {
            val intent = Intent(this, AddWordActivity::class.java)
            startActivityForResult(intent, ADD_WORD_REQUEST_CODE)
        }

        populateList()
    }

    private fun populateList() {
        coroutineScope.launch {
            val wordDao = WordRoomDatabase.getWordDatabase(this@WordListActivity).wordDao()
            val list = wordDao.getAllWord()
            withContext(Dispatchers.Main) {
                (binding.rvWords.adapter as WordListAdapter).addItems(list)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && requestCode == ADD_WORD_REQUEST_CODE) {
            populateList()
        }
    }

    override fun onDestroy() {
        coroutineScope.cancel()
        super.onDestroy()
    }
}