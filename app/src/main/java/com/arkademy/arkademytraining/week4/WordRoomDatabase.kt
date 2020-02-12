package com.arkademy.arkademytraining.week4

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

/**
 * Created by adrianfikri on 2020-02-10.
 */
@Database(entities = [WordRoomEntity::class], version = 1, exportSchema = false)
abstract class WordRoomDatabase : RoomDatabase() {

    abstract fun wordDao(): WordDao

    companion object {

        @Volatile
        private var INSTANCE: WordRoomDatabase? = null

        fun getWordDatabase(context: Context): WordRoomDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(context.applicationContext,
                    WordRoomDatabase::class.java, "word_room.db")
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}