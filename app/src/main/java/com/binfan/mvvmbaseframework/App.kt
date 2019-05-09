package com.binfan.mvvmbaseframework

import android.app.Application
import com.binfan.mvvmbaseframework.shared.utils.ResourcesUtils

/**
 * App implementation
 *
 * @author Bin Fan (binfannz@gmail.com)
 */
class App: Application() {

    override fun onCreate() {
        super.onCreate()

        ResourcesUtils.init(this)
    }
}