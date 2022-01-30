package com.elbek.delline.ViewModel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.elbek.delline.Repository.DatabaseRepository
import com.elbek.delline.models.DeallineData

class MainViewModel : ViewModel() {
    fun initDatabase(context: Context) {
        DatabaseRepository.initDatabase(context)
    }

    fun getDbViewModel(): LiveData<List<DeallineData>> {
        return DatabaseRepository.getAllData()
    }

    fun insertProduct(deallineData: DeallineData) {
        DatabaseRepository.insertProduct(deallineData)
    }
}