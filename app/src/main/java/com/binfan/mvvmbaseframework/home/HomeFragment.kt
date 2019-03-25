package com.binfan.mvvmbaseframework.home

import com.binfan.mvvmbaseframework.R
import com.binfan.mvvmbaseframework.base.BaseFragment
import com.binfan.mvvmbaseframework.databinding.FragmentHomeBinding

class HomeFragment : BaseFragment<HomeViewModel, FragmentHomeBinding>() {

  override val layoutResId = R.layout.fragment_home

  override val viewModelClass = HomeViewModel::class.java

  companion object {

    fun newInstance(): HomeFragment {
      return HomeFragment()
    }
  }
}
