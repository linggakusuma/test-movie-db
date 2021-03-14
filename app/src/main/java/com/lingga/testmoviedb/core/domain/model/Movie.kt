package com.lingga.testmoviedb.core.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movie(
    var id: Int,
    var title: String?,
    var overview: String?,
    var isFavorite: Boolean = false,
    var posterPath: String?,
    var releaseDate: String?
) : Parcelable