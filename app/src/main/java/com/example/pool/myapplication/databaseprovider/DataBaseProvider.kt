package com.example.pool.myapplication.databaseprovider

import android.content.Context
import com.example.pool.myapplication.databases.WordDataBase

class DataBaseProvider(context: Context) {

    private val database = WordDataBase.getInstance(context)

    fun getWordDao() = database!!.wordDao()
}