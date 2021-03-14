package com.lingga.testmoviedb.core.domain.model

import com.lingga.testmoviedb.core.data.source.remote.response.AuthorDetailResponse

data class Review(
    val author: String?,
    val content: String?,
    val id: String?,
    val authorDetail: AuthorDetailResponse
)