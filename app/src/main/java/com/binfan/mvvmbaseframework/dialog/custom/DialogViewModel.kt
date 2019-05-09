package com.orderPay.ui.dialog

import android.arch.lifecycle.MutableLiveData
import com.binfan.mvvmbaseframework.base.BaseViewModel

/**
 * Dialog view model
 *
 * @author Bin Fan (bin.fan@plexure.com)
 */
class DialogViewModel : BaseViewModel() {

    val dialogTitle: MutableLiveData<String> = MutableLiveData()

    val dialogMessage: MutableLiveData<String> = MutableLiveData()

    fun bind(title: String, message: String? = null) {
        dialogTitle.value = title
        message?.let { dialogMessage.value = it }
    }
}
