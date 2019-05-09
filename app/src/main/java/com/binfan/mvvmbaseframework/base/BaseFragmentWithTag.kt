package com.binfan.mvvmbaseframework.base

import android.support.v4.app.Fragment

/**
 * Base Fragment Class with Tag
 *
 * @author Bin Fan (bin.fan@plexure.com)
 */
open class BaseFragmentWithTag: Fragment() {

    var backStackTag = this.javaClass.simpleName
}