package com.l0122096.mohammadrizki.demonslayerapp.model
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Character(
    val name: String,
    val description: String,
    val img: Int
) : Parcelable