package com.binfan.mvvmbaseframework

import android.os.Bundle
import android.support.v4.app.Fragment
import com.binfan.mvvmbaseframework.base.BaseActivity
import com.binfan.mvvmbaseframework.home.HomeFragment
import kotlinx.android.synthetic.main.activity_main.*

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
		changeFragment(homeFragment)
	}

	fun changeFragment(
		fragment: Fragment,
		addToBackStack: Boolean = true,
		tag: String? = null,
		containerViewId: Int = R.id.fragment_container
	) {
		val fm = supportFragmentManager
		val fragmentTransaction = fm?.beginTransaction()
		if (addToBackStack) {
			fragmentTransaction?.addToBackStack(tag)
		}
		fragmentTransaction?.replace(containerViewId, fragment, tag)?.commit()
	}
}
