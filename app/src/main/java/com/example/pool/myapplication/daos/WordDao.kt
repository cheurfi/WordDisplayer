package com.example.pool.myapplication.daos

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.example.pool.myapplication.entities.Word
import io.reactivex.Single

@Dao
interface WordDao {

    @Query("SELECT * from word_database")
    fun getValues(): Single<List<Word>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertValues(word: Word)
}