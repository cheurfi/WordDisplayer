package com.example.pool.myapplication.ui

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.pool.myapplication.R
import com.example.pool.myapplication.databaseprovider.DataBaseProvider
import com.example.pool.myapplication.entities.Word
import com.example.pool.myapplication.providers.WordProvider
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val databaseprovider = DataBaseProvider(this)
        val wordProvider = WordProvider(databaseprovider.getWordDao())

        button.setOnClickListener({
            appendText()
            wordProvider.insertValues(Word(textView.text.toString()))
        })

        nextButton.setOnClickListener( {
            val intent = Intent(this, WordActivity::class.java)
            startActivity(intent)
        })
    }

    private fun appendText() {
        textView.text = textView.text.toString() + editText.text
    }
}