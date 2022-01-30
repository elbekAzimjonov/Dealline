package com.elbek.delline.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Dealline")
class DeallineData(
    var productImage: Int,
    var productName: String,
    var productFunction: String,
    var productRating: Int,
    var productOrginalPrice: String,
    var productPrice: String,
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}