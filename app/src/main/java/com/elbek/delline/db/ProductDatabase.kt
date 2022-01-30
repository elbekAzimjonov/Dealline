package com.elbek.delline.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.elbek.delline.models.DeallineData

@Database(entities = [DeallineData::class], version = 1, exportSchema = false)
abstract class ProductDatabase() : RoomDatabase() {
    abstract fun productDao(): ProductDao

    companion object {
        private const val DATABASE_NAME = "dealline_db"
        fun getDatabaseInstance(context: Context): ProductDatabase {
            return Room.databaseBuilder(
                context.applicationContext, ProductDatabase::class.java, DATABASE_NAME)
                .fallbackToDestructiveMigration().build()
        }
    }
}