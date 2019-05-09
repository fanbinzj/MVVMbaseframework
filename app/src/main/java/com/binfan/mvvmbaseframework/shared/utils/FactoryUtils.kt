package com.binfan.mvvmbaseframework.shared.utils

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProviders
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity

class FactoryUtils() {
	companion object {

		fun <T : ViewModel> createViewModel(
			vModelClass: Class<T>,
			isShared: Boolean = false,
			activity: FragmentActivity? = null,
			fragment: Fragment? = null
		): T {
			if (isShared) {
				return activity?.run {
					ViewModelProviders.of(this)
						.get(vModelClass)
				} ?: throw Exception("Invalid Activity")
			} else {
				fragment?.let {
					return ViewModelProviders.of(it).get(vModelClass)
				} ?: throw Exception("Invalid Fragment")
			}
		}
	}
}