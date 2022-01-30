package com.uho.kotlincountries.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.uho.kotlincountries.model.Country
import com.uho.kotlincountries.service.db.CountryDatabase
import kotlinx.coroutines.launch

class CountryViewModel(application: Application): BaseViewModel(application) {

    val countryLiveData = MutableLiveData<Country>()

    fun getDataFromRoom(id: Int){

        launch {
            val dao = CountryDatabase(getApplication()).countryDao()
            val country = dao.getCountry(id)
            countryLiveData.value = country
        }

    }
}