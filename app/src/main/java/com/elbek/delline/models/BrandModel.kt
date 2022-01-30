package com.elbek.delline.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class BrandModel(var brandName: String, var brandImage: Int) : Parcelable