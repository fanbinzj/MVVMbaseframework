package com.binfan.mvvmbaseframework.home

import com.binfan.mvvmbaseframework.R
import com.binfan.mvvmbaseframework.base.BaseFragment
import com.binfan.mvvmbaseframework.databinding.FragmentHomeBinding
import com.binfan.mvvmbaseframework.listScreen.ListFragment

class HomeFragment : BaseFragment<HomeViewModel, FragmentHomeBinding>() {

  override val layoutResId = R.layout.fragment_home

  override val viewModelClass = HomeViewModel::class.java

  override fun bindViewModel() {
    binding.vm = viewModel
  }

  override fun bindViews() {
    binding.navigateToListScreenButton.setOnClickListener { changeFragment(ListFragment.newInstance()) }
  }

  companion object {

    fun newInstance(): HomeFragment {
      return HomeFragment()
    }
  }
}
