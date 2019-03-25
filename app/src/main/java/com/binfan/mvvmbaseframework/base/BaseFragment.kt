package com.binfan.mvvmbaseframework.base

import android.arch.lifecycle.ViewModel
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.arch.lifecycle.ViewModelProviders
import com.binfan.mvvmbaseframework.R

/**
 * Base Fragment Class which must be inherited by every fragment
 *
 * @author Bin Fan (binfannz@gmail.com)
 */
abstract class BaseFragment<VM : BaseViewModel, BD : ViewDataBinding> : Fragment() {

	protected abstract val layoutResId: Int

  protected abstract val viewModelClass: Class<VM>

  protected lateinit var viewModel: VM

  protected lateinit var binding: BD


  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    binding = DataBindingUtil.inflate(inflater, layoutResId, container, false)
    initViewModel()
    return binding.root
  }

  fun initViewModel() {
    viewModel = createViewModel(viewModelClass)
  }

  protected fun <T : ViewModel> createViewModel(vModelClass: Class<T>, isShared: Boolean = false): T {
    return ViewModelProviders.of(this).get(vModelClass)
  }

  fun changeFragment(
    fragment: Fragment,
    addToBackStack: Boolean = true,
    tag: String? = null,
    containerViewId: Int = R.id.fragment_container
  ) {
    val fm = fragmentManager
    val fragmentTransaction = fm?.beginTransaction()
    if (addToBackStack) {
      fragmentTransaction?.addToBackStack(tag)
    }
    fragmentTransaction?.replace(containerViewId, fragment, tag)
      ?.commit()
  }
}
