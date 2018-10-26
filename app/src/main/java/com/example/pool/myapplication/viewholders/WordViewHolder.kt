package com.example.pool.myapplication.viewholders

import android.support.v7.widget.RecyclerView
import android.view.View
import kotlinx.android.synthetic.main.word_item.view.*

class WordViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    val text = view.word

    fun bind(word: String) {
        this.text.text = word
    }
}