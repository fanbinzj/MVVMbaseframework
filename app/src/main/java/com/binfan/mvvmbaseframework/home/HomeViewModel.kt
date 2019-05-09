package com.binfan.mvvmbaseframework.home

import android.arch.lifecycle.MutableLiveData
import com.binfan.mvvmbaseframework.base.BaseViewModel
import com.binfan.mvvmbaseframework.shared.utils.default

class HomeViewModel : BaseViewModel() {

	val cardNumber = MutableLiveData<String>().default("41111 1 234  234 2 34 234 23")
}
