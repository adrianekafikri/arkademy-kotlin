package com.arkademy.arkademytraining.week4

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

/**
 * Created by adrianfikri on 2020-02-10.
 */
@Entity(tableName = "word_table")
data class WordRoomEntity(var name: String = "",
                          @ColumnInfo(name = "created_at") var createdAt: Long = 0) {

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}