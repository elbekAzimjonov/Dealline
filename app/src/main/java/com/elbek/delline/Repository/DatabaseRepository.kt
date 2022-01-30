package com.elbek.delline.Repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.elbek.delline.db.ProductDatabase
import com.elbek.delline.models.DeallineData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DatabaseRepository {
    companion object {
        private var productDb: ProductDatabase? = null
        fun initDatabase(context: Context) {
            productDb = ProductDatabase.getDatabaseInstance(context)
        }

        fun insertProduct(deallineData: DeallineData) {
            CoroutineScope(Dispatchers.IO).launch {
                productDb?.productDao()?.insertProduct(deallineData)
            }
        }

        fun getAllData(): LiveData<List<DeallineData>> {
            return productDb?.productDao()?.getAllProduct()!!
        }
    }
}