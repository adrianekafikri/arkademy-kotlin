package com.arkademy.arkademytraining.week4

import androidx.room.*

/**
 * Created by adrianfikri on 2020-02-10.
 */
@Dao
interface WordDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(word: WordRoomEntity)

    @Query("SELECT * FROM word_table ORDER BY id ASC")
    fun getAllWord(): List<WordRoomEntity>

    @Query("SELECT * FROM word_table WHERE id = :wordId")
    fun getWord(wordId: Int): WordRoomEntity

    @Update
    fun updateWord(word: WordRoomEntity)

    @Query("DELETE FROM word_table")
    fun deleteAll()

    @Delete
    fun deleteWord(word: WordRoomEntity)
}