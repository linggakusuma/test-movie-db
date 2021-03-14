package com.lingga.testmoviedb.core.data.source.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movie")
data class MovieEntity(

    @PrimaryKey
    var id: Int,
    var title: String?,
    var overview: String?,
    var isFavorite: Boolean = false,
    @ColumnInfo(name = "poster_path") var posterPath: String?,
    @ColumnInfo(name = "release_date") var releaseDate: String?
)