package com.lingga.testmoviedb.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.lingga.testmoviedb.R

@BindingAdapter("imageMovie")
fun bindImageMovie(imgView: ImageView, imgUrl: String?) {
    imgUrl?.let {
        Glide.with(imgView.context)
            .load("https://image.tmdb.org/t/p/w500/$imgUrl")
            .into(imgView)
    }
}

@BindingAdapter("avatar")
fun bindAvatar(imgView: ImageView, imgUrl: String?) {
    if (imgUrl.isNullOrEmpty()) {
        Glide.with(imgView.context)
            .load(R.drawable.ic_baseline_account_circle)
            .into(imgView)
    } else {
        if (imgUrl.contains("https")) {
            Glide.with(imgView.context)
                .load(imgUrl.removeRange(0, 1))
                .into(imgView)
        } else {
            Glide.with(imgView.context)
                .load("https://image.tmdb.org/t/p/w500/$imgUrl")
                .into(imgView)
        }
    }
}