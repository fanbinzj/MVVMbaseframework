package com.binfan.mvvmbaseframework.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.binfan.mvvmbaseframework.architect.Router

abstract class BaseActivity : AppCompatActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		Router.init(supportFragmentManager)
	}
}
