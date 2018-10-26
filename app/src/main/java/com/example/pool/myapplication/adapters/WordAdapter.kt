package com.example.pool.myapplication.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.pool.myapplication.R
import com.example.pool.myapplication.entities.Word
import com.example.pool.myapplication.viewholders.WordViewHolder

class WordAdapter(val list: List<Word>): RecyclerView.Adapter<WordViewHolder>() {

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        val word = list[position]
        holder.bind(word.word)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.word_item, parent, false)
        return WordViewHolder(view)
    }
}

