package com.binfan.mvvmbaseframework.ui.listScreen

import android.arch.lifecycle.MutableLiveData
import com.binfan.mvvmbaseframework.base.BaseViewModel
import com.binfan.mvvmbaseframework.shared.utils.default

class ListViewModel : BaseViewModel() {

  val totalCount = MutableLiveData<Int>().default(89)
}
