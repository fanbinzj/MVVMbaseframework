package com.binfan.mvvmbaseframework.base

import android.arch.lifecycle.Observer
import android.databinding.ViewDataBinding
import com.binfan.mvvmbaseframework.R
import com.orderPay.ui.dialog.CustomLayoutDialogFragment
import com.orderPay.ui.dialog.LoadingDialogFragment

/**
 * Base Api Fragment to help any fragment which need to make api call
 * Including: loading spinner, error dialog
 *
 * @author Bin Fan (bin.fan@plexure.com)
 */
abstract class BaseApiFragment<VM: BaseApiViewModel, BD: ViewDataBinding>: BaseFragment<VM, BD>() {

	abstract fun onDataReady()

	override fun bindData() {
		super.bindData()

		loadEvent(viewModel)
	}

	protected fun loadEvent(model: BaseApiViewModel) {

		model.loadingSpinnerEvent.observe(this, Observer {
			it?.getContentIfNotHandled()?.let { isShowing ->
				if (isShowing)
					showLoadingSpinner()
				else
					hideLoadingSpinner()
			}
		})

		model.apiCallFinishEvent.observe(this, Observer {
			it?.getContentIfNotHandled()?.let {
				onDataReady()
				hideLoadingSpinner()
			}
		})

		model.errorMessageEvent.observe(this, Observer {
			it?.getContentIfNotHandled()?.let { errorMessage ->
				showErrorMessageDialog(errorMessage)
			}
		})
	}

	private fun showLoadingSpinner() {
		if (loadingSpinnerFragment == null) {
			fragmentManager?.let {
				loadingSpinnerFragment = LoadingDialogFragment.showLoadingSpinner(it)
			}
		}
	}

	private fun hideLoadingSpinner() {
		loadingSpinnerFragment?.let {
			it.dismiss()
		}
		loadingSpinnerFragment = null
	}


	private fun showErrorMessageDialog(errorMessage: String) {
		fragmentManager?.let {
			val title = getString(R.string.error_dialog_title)
			CustomLayoutDialogFragment.showMessageDialog(it, title = title, message = errorMessage)
		}
	}

	companion object {
		var loadingSpinnerFragment: LoadingDialogFragment? = null
	}
}