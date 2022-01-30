package com.elbek.delline.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize


data class ProductData(
    var productImage: Int,
    var productName: String,
    var productFunction: String,
    var productTex: String,
    var productRating: Int,
    var productOrginalPrice: String,
    var productPrice: String
):Parcelable