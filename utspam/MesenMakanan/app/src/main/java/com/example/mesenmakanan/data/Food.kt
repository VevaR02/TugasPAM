package com.example.mesenmakanan.data

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.parcelize.Parcelize

@Parcelize
data class Food(
    @DrawableRes val imageResId: Int,
    val name: String,
    val description: String,
    val price: String
) : Parcelable
