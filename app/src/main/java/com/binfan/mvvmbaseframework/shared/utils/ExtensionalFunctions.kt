package com.binfan.mvvmbaseframework.shared.utils

import android.arch.lifecycle.MutableLiveData

//Todo: Need to make MutableLiveData Nonnull
fun <T : Any?> MutableLiveData<T>.default(initialValue: T) = apply { setValue(initialValue) }
