package com.mxpj.pizzashop.data

import android.graphics.Bitmap

interface ImageLoader {

    suspend fun loadImage(url: String): Bitmap?
}