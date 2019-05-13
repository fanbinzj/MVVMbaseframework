package com.binfan.mvvmbaseframework.architect

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import com.binfan.mvvmbaseframework.R

/**
 * Router class
 *
 * @author Bin Fan (binfannz@gmail.com)
 */
class Router(val supportFragmentManager: FragmentManager) {

    fun changeFragment(
            fragment: Fragment,
            tag: String? = fragment.tag,
            addToBackStack: Boolean = true,
            containerViewId: Int = R.id.fragment_container,
            keepOnInstance: Boolean = true
    ) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()

        if (keepOnInstance) {
            val fragmentInStack = supportFragmentManager.findFragmentByTag(tag)
            fragmentInStack?.let {
                supportFragmentManager.popBackStackImmediate(tag, FragmentManager.POP_BACK_STACK_INCLUSIVE)
            }
        }

        if (addToBackStack) {
            fragmentTransaction.addToBackStack(tag)
        }
        fragmentTransaction.replace(containerViewId, fragment, tag).commit()
    }

    fun popBackStack() {
        supportFragmentManager.popBackStack()
    }

    companion object {
    	private lateinit var instance: Router

        fun init(supportFragmentManager: FragmentManager): Router {
            instance = Router(supportFragmentManager)
            return instance
        }

        fun getInstance(): Router {
            return instance!!
        }
    }
}

