package com.arkademy.arkademytraining.week4

import android.app.Activity
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.arkademy.arkademytraining.R
import com.arkademy.arkademytraining.databinding.ActivityAddWordBinding
import kotlinx.coroutines.*

/**
 * Created by adrianfikri on 2020-02-08.
 * Room implementation
 */
class AddWordActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddWordBinding
    private lateinit var coroutineScope: CoroutineScope

    companion object {
        const val ADD_WORD_REQUEST_CODE = 9013
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_add_word)
        coroutineScope = CoroutineScope(Job() +  Dispatchers.IO)

        val wordDao = WordRoomDatabase.getWordDatabase(this).wordDao()

        binding.btnSave.setOnClickListener {
            if (binding.etInputWord.text.isNotEmpty()) {
                coroutineScope.launch {
                    wordDao.insert(WordRoomEntity(binding.etInputWord.text.toString(), System.currentTimeMillis()))
                }
                setResult(Activity.RESULT_OK)
                finish()
            }
        }
    }

    override fun onDestroy() {
        coroutineScope.cancel()
        super.onDestroy()
    }
}