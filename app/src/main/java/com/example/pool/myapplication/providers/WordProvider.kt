package com.example.pool.myapplication.providers

import com.example.pool.myapplication.daos.WordDao
import com.example.pool.myapplication.entities.Word
import io.reactivex.Completable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class WordProvider(val dao: WordDao) {

    fun getValues(): Single<List<Word>> {
       return dao.getValues()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
    }

    fun insertValues(entity: Word): Disposable {
        return Completable.fromAction { dao.insertValues(entity) }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe()
    }
}