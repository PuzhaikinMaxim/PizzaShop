package com.mxpj.pizzashop.data

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import com.mxpj.pizzashop.data.ImageLoader
import com.squareup.picasso.Picasso
import com.squareup.picasso.Target
import java.lang.Exception
import javax.inject.Inject
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class PicassoImageLoader @Inject constructor(): ImageLoader {

    override suspend fun loadImage(url: String): Bitmap? = suspendCoroutine {
        Picasso.get().load(url).into(object : Target {
            override fun onBitmapLoaded(bitmap: Bitmap?, from: Picasso.LoadedFrom?) {
                it.resume(bitmap)
            }

            override fun onBitmapFailed(e: Exception?, errorDrawable: Drawable?) {
                it.resume(null)
            }

            override fun onPrepareLoad(placeHolderDrawable: Drawable?) {

            }

        })
    }
}