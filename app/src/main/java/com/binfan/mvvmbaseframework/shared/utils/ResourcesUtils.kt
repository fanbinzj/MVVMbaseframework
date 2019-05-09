package com.binfan.mvvmbaseframework.shared.utils

import android.content.Context
import android.graphics.drawable.Drawable
import android.support.v4.content.ContextCompat

/**
 * Provides [android.content.res.Resources].
 *
 * @author Bin Fan (binfannz@gmail.com)
 */

class ResourcesUtils(val context: Context){

    companion object {

        private lateinit var instance: ResourcesUtils

        fun init(context: Context): ResourcesUtils {
            instance = ResourcesUtils(context)
            return instance
        }

        fun getInstance(): ResourcesUtils {
            return instance
        }
    }

    fun getString(resId: Int): String {
        return context.getString(resId)
    }

    fun getStringArray(resId: Int): Array<String> {
        return context.resources.getStringArray(resId)
    }

    fun getDrawable(resId: Int): Drawable? {
        return ContextCompat.getDrawable(context, resId)
    }

    fun getColor(resId: Int): Int {
        return ContextCompat.getColor(context, resId)
    }
}
