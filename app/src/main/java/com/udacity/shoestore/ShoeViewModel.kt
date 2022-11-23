package com.udacity.shoestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShoeViewModel :ViewModel(){

    var shoesList = MutableLiveData<ArrayList<Shoe>>()
    var _shoename = MutableLiveData<String>()
    var _company = MutableLiveData<String>()
    var _shoesize = MutableLiveData<String>()
    var _description = MutableLiveData<String>()
    private var shoes= ArrayList<Shoe>()

    fun createShoe(){
        val shoe= Shoe(_shoename.value.toString(),_shoesize.value.toString(),_company.value.toString(),_description.value.toString())
        shoes.add(shoe)
        shoesList.value=shoes
        _shoename.value=""
        _company.value=""
        _shoename.value=""
        _description.value=""
    }

}