package com.binfan.mvvmbaseframework.base

import android.arch.lifecycle.ViewModel
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.binfan.mvvmbaseframework.MainActivityViewModel
import com.binfan.mvvmbaseframework.architect.Router
import com.binfan.mvvmbaseframework.shared.utils.FactoryUtils

/**
 * Base Fragment Class which must be inherited by every fragment
 *
 * @author Bin Fan (binfannz@gmail.com)
 */
abstract class BaseFragment<VM : BaseViewModel, BD : ViewDataBinding> : BaseFragmentWithTag() {

	//abstract members
	protected abstract val layoutResId: Int

	protected abstract val viewModelClass: Class<VM>

	protected abstract fun bindViewModel()


	//fields
	protected lateinit var viewModel: VM

	protected lateinit var binding: BD

	private var mainActivityViewModel: MainActivityViewModel? = null

	open var isShowToolbar = true

	override fun onCreateView(
		inflater: LayoutInflater,
		container: ViewGroup?,
		savedInstanceState: Bundle?
	): View {
		binding = DataBindingUtil.inflate(inflater, layoutResId, container, false)

		initViewModel()

		bindViewModel()

		bindViews()

		bindData()

		binding.setLifecycleOwner(this)

		return binding.root
	}

	open fun initViewModel() {
		viewModel = createViewModel(viewModelClass)
	}

	open fun bindViews() {
	}

	open fun bindData() {}

	protected fun <T : ViewModel> createViewModel(vModelClass: Class<T>, isShared: Boolean = false): T {
		return FactoryUtils.createViewModel(vModelClass, isShared, activity, this)
	}

	protected fun changeFragment(
		fragment: BaseFragmentWithTag,
		tag: String? = fragment.backStackTag,
		addToBackStack: Boolean = true,
		keepOneInstance: Boolean = true
	) {
		Router.getInstance().changeFragment(fragment, tag, addToBackStack, keepOnInstance = keepOneInstance)
	}

	protected fun popBackStack() {
		Router.getInstance().popBackStack()
	}
}

