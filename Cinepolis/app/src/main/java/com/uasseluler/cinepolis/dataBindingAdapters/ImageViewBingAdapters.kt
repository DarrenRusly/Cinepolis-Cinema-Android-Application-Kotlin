package com.uasseluler.cinepolis.dataBindingAdapters

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.uasseluler.cinepolis.R

@BindingAdapter(value = ["imageUrl"])
fun loadImageFromInternet(
    view: ImageView,
    imageUrl: String,
) {
    Glide.with(view.context)
        .load(imageUrl)
        .placeholder(R.drawable.ic_baseline_image_24)
        .error(R.drawable.ic_baseline_image_24)
        .into(view)
}