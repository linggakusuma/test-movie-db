package com.lingga.testmoviedb.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class ReviewResponse(
    @SerializedName("author") val author: String?,
    @SerializedName("content") val content: String?,
    @SerializedName("id") val id: String?,
    @SerializedName("author_details") val authorDetail: AuthorDetailResponse
)