package com.anmp.a160420121_uts_anmp.util

import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import com.anmp.a160420121_uts_anmp.R
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso

fun ImageView.loadImage(url: String?, progressBar: ProgressBar) {
    Picasso.get()
        .load(url)
        .resize(400, 400)
        .centerCrop()
        .error(R.drawable.ic_baseline_error_24)
        .into(this, object: Callback {
            override fun onSuccess() {
                progressBar.visibility = View.GONE
            }
            override fun onError(e: Exception?) {
            }
        })
}

fun ImageView.loadImageNoBar(url: String?) {
    Picasso.get()
        .load(url)
        .resize(400, 400)
        .centerCrop()
        .error(R.drawable.ic_baseline_error_24)
        .into(this, object: Callback {
            override fun onSuccess() {

            }
            override fun onError(e: Exception?) {
            }
        })
}