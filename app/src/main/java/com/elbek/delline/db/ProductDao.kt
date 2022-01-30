package com.elbek.delline.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.elbek.delline.models.DeallineData

@Dao
interface ProductDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertProduct(deallineData: DeallineData)

    @Query("SELECT * FROM dealline  ORDER BY id DESC")
    fun getAllProduct(): LiveData<List<DeallineData>>

    @Delete
    fun deleteProduct(deallineData: DeallineData)
}