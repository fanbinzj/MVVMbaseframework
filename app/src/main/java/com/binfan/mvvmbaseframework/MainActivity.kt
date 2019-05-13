package com.binfan.mvvmbaseframework

import android.os.Bundle
import com.binfan.mvvmbaseframework.architect.Router
import com.binfan.mvvmbaseframework.base.BaseActivity
import com.binfan.mvvmbaseframework.ui.home.HomeFragment
import kotlinx.android.synthetic.main.activity_main.toolbar

class MainActivity : BaseActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)
		setSupportActionBar(toolbar)
		supportActionBar?.setDisplayShowTitleEnabled(false)

		navigateToHome()
	}

	fun navigateToHome() {
		val homeFragment = HomeFragment.newInstance()
		Router.getInstance().changeFragment(homeFragment, homeFragment.backStackTag)
	}
}
