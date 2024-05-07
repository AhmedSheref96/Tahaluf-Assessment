package com.el3asas.ui.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UniversityItem(
    val country: String? = null,
    val webPages: List<String?>? = null,
    val name: String? = null,
    val domains: List<String?>? = null,
    val stateProvince: String? = null,
    val alphaTwoCode: String? = null
) : Parcelable
