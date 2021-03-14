package com.lingga.testmoviedb.ui.home

import com.lingga.testmoviedb.R
import com.lingga.testmoviedb.core.domain.model.Movie
import com.lingga.testmoviedb.ui.base.BaseAdapter

class MovieAdapter(onClick: (Movie) -> Unit) : BaseAdapter<Movie>(onClick) {
    override val getLayoutIdRes: Int
        get() = R.layout.item_list_movie
}