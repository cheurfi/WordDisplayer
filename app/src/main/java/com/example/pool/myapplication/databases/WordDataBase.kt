package com.example.pool.myapplication.databases

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.example.pool.myapplication.daos.WordDao
import com.example.pool.myapplication.entities.Word

@Database(entities = [(Word::class)], version = 1, exportSchema = false)
abstract class WordDataBase : RoomDatabase() {

    abstract fun wordDao(): WordDao

    companion object {
        private var INSTANCE: WordDataBase? = null

        fun getInstance(context: Context): WordDataBase? {
            if (INSTANCE == null) {
                synchronized(WordDataBase::class) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            WordDataBase::class.java, "word_database")
                            .build()
                }
            }
            return INSTANCE
        }
    }
}