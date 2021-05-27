package com.example.cookapi.ua.dish

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cookapi.model.api.responses.Recept
import com.example.cookapi.model.repository.Repository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class DishViewModel : ViewModel() {
    private val _dish = MutableLiveData<List<Recept>>()

    val products: LiveData<List<Recept>> = _dish

    fun  getListRecepts(q:String){
        Repository.getListRecepts(q)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ recept ->
                _dish.value=recept.listRecept
            }, { throwable ->
                Log.e("MainViewModel", "Error\n" + throwable.message.toString())
            })
    }


}