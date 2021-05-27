package com.example.cookapi.ua.dish.activity

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.cookapi.model.repository.Repository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers


class MainViewModel: ViewModel() {

    fun getRecept(q:String){
        Repository.getRecept(q)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ recept ->
                Log.d("MainViewModel", "Success\n" + recept)
            }, { throwable ->
                Log.e("MainViewModel", "Error\n" + throwable.message.toString())
            })
    }

    fun getListRecepts(q:String){
        Repository.getListRecepts(q)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ recept ->
                Log.d("MainViewModel", "Success\n" + recept)
            }, { throwable ->
                Log.e("MainViewModel", "Error\n" + throwable.message.toString())
            })
    }

}