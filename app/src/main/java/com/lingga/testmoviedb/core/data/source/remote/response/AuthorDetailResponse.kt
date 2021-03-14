package com.lingga.testmoviedb.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class AuthorDetailResponse(
    @SerializedName("username") val username: String?,
    @SerializedName("avatar_path") val avatarPath: String?,
    @SerializedName("rating") val rating: String?
)