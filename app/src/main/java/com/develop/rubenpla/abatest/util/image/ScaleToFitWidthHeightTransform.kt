package com.develop.rubenpla.abatest.util.image

import android.graphics.Bitmap
import com.squareup.picasso.Transformation


class ScaleToFitWidthHeightTransform : Transformation {

    private var mSize: Int
    private var isHeightScale: Boolean = false

    constructor(size: Int, isHeightScale : Boolean) {
        this.mSize = size
        this.isHeightScale = isHeightScale
    }


    override fun key(): String {
        return "scaleRespectRatio$mSize$isHeightScale";
    }

    override fun transform(source: Bitmap?): Bitmap {
        val scale: Float
        val newSize: Int
        val scaleBitmap: Bitmap
        if (isHeightScale) {
            scale = mSize.toFloat() / source!!.height
            newSize = Math.round(source.width * scale)
            scaleBitmap = Bitmap.createScaledBitmap(source, newSize, mSize as Int, true)
        } else {
            scale = mSize.toFloat() / source!!.width
            newSize = Math.round(source.height * scale)
            scaleBitmap = Bitmap.createScaledBitmap(source, mSize, newSize, true)
        }

        if (scaleBitmap != source) {
            source.recycle()
        }

        return scaleBitmap    }
}