package com.elbek.delline.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

@Parcelize
data class CategoriesModel(
    var iconimage: Int,
    var categorieName: String,
    var productNumber: Int,
    var products: @RawValue ArrayList<ProductData>
) : Parcelable
