package com.mxpj.pizzashop.data

import android.app.Application
import android.content.Context
import android.content.ContextWrapper
import android.graphics.Bitmap
import java.io.File
import java.io.FileOutputStream
import javax.inject.Inject

class ImageWriter @Inject constructor(
    private val application: Application
) {

    fun writeImage(fileName: String,bitmap: Bitmap?): String? {
        if(bitmap == null) return null
        val contextWrapper = ContextWrapper(application)
        val directory = contextWrapper.getDir(DIR_LOCATION, Context.MODE_PRIVATE)
        val file = File(directory,"${fileName}.png")
        val fos = FileOutputStream(file)
        try {
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fos)
        } catch (ex: Exception) {
           return null
        } finally {
            try {
                fos.close()
            }
            catch (ex: Exception) {
                return null
            }
        }
        return file.path
    }

    fun clearImages() {
        val contextWrapper = ContextWrapper(application)
        val directory = contextWrapper.getDir(DIR_LOCATION, Context.MODE_PRIVATE)
        if(directory.listFiles() == null) return
        for(file in directory.listFiles()!!){
            file.delete()
        }
    }

    companion object {
        private const val DIR_LOCATION = "localImages"
    }
}