package com.binfan.mvvmbaseframework.ui.listScreen

import com.binfan.mvvmbaseframework.R
import com.binfan.mvvmbaseframework.base.BaseFragment
import com.binfan.mvvmbaseframework.databinding.FragmentListBinding

class ListFragment : BaseFragment<ListViewModel, FragmentListBinding>() {

	override val layoutResId = R.layout.fragment_list

	override val viewModelClass = ListViewModel::class.java

	override fun bindViewModel() {
		binding.vm = viewModel
	}

	companion object {

		fun newInstance(): ListFragment {
			return ListFragment()
		}
	}
}
