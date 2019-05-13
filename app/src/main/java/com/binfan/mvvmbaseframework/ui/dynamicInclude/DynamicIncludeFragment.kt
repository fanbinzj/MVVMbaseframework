package com.binfan.mvvmbaseframework.ui.dynamicInclude

import com.binfan.mvvmbaseframework.R
import com.binfan.mvvmbaseframework.base.BaseFragment
import com.binfan.mvvmbaseframework.databinding.FragmentDynamicIncludeBinding

class DynamicIncludeFragment : BaseFragment<DynamicIncludeViewModel, FragmentDynamicIncludeBinding>() {

	override val layoutResId = R.layout.fragment_dynamic_include

	override val viewModelClass = DynamicIncludeViewModel::class.java

	override fun bindViewModel() {
		binding.vm = viewModel
	}

	companion object {

		fun newInstance(): DynamicIncludeFragment {
			return DynamicIncludeFragment()
		}
	}
}
