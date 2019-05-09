package com.binfan.mvvmbaseframework.base

import android.arch.lifecycle.MutableLiveData
import com.binfan.mvvmbaseframework.architect.LiveEvent

open class BaseApiViewModel : BaseViewModel() {

	val apiCallFinishEvent = MutableLiveData<LiveEvent<Boolean>>()

	fun showLoadingSpinnerByEvent() {
		loadingSpinnerEvent.postValue(LiveEvent(true))
	}

	fun hideLoadingSpinnerByEvent() {
		loadingSpinnerEvent.postValue(LiveEvent(false))
	}

	fun callUiWhenApiCallFinishedEvent() {
		apiCallFinishEvent.postValue(LiveEvent(true))
	}

	fun showErrorDialog(errorMessage: String) {
		errorMessageEvent.postValue(LiveEvent(errorMessage))
	}
}
