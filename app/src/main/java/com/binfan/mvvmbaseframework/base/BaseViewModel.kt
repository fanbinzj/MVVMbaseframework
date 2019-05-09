package com.binfan.mvvmbaseframework.base

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.binfan.mvvmbaseframework.architect.LiveEvent

open class BaseViewModel : ViewModel() {

    val errorMessageEvent = MutableLiveData<LiveEvent<String>>()

    val loadingSpinnerEvent = MutableLiveData<LiveEvent<Boolean>>()
}
