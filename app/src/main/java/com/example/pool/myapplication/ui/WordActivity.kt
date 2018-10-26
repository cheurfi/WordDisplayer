package com.example.pool.myapplication.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.example.pool.myapplication.R
import com.example.pool.myapplication.adapters.WordAdapter
import com.example.pool.myapplication.databaseprovider.DataBaseProvider
import com.example.pool.myapplication.entities.Word
import com.example.pool.myapplication.providers.WordProvider
import kotlinx.android.synthetic.main.activity_word.*

class WordActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_word)

        val databaseprovider = DataBaseProvider(this)
        val wordProvider = WordProvider(databaseprovider.getWordDao())

        wordProvider.getValues()
                .subscribe ({ displayWords(it)},
                    Throwable::printStackTrace)
    }

    private fun displayWords(result: List<Word>) {
        recyclerView.adapter = WordAdapter(result)
        recyclerView.layoutManager = LinearLayoutManager(this)
    }
}