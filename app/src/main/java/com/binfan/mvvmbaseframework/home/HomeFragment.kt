package com.binfan.mvvmbaseframework.home

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.binfan.mvvmbaseframework.R
import com.binfan.mvvmbaseframework.base.BaseFragment
import com.binfan.mvvmbaseframework.databinding.FragmentHomeBinding
import com.binfan.mvvmbaseframework.databinding.ListGenericItemTextOnlyBinding
import com.binfan.mvvmbaseframework.shared.utils.ResourcesUtils
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager

class HomeFragment : BaseFragment<HomeViewModel, FragmentHomeBinding>() {

	companion object {

		fun newInstance(): HomeFragment {
			return HomeFragment()
		}
	}

	override val layoutResId = R.layout.fragment_home

	override val viewModelClass = HomeViewModel::class.java

	lateinit var nameTextArray: Array<String>

	override fun bindViewModel() {
		binding.vm = viewModel
	}

	override fun bindViews() {
		binding.homeMenuListRv.adapter = adapter

		val dividerItemDecoration = DividerItemDecoration(
			context,
			LinearLayoutManager.VERTICAL
		)
		binding.homeMenuListRv.addItemDecoration(dividerItemDecoration)
	}

	override fun bindData() {
		super.bindData()
		nameTextArray = ResourcesUtils.getInstance().getStringArray(R.array.home_screen_button_name_array)
	}

	private val adapter = object : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

		override fun onCreateViewHolder(
			parent: ViewGroup,
			viewType: Int
		): ViewHolder {
			val binding: ListGenericItemTextOnlyBinding = DataBindingUtil.inflate(
				LayoutInflater.from(parent.context), R.layout.list_generic_item_text_only, parent, false
			)
			return ViewHolder(binding)
		}

		override fun getItemCount(): Int {
			return nameTextArray.size
		}

		override fun onBindViewHolder(
			holder: RecyclerView.ViewHolder,
			position: Int
		) {
			(holder as ViewHolder).apply {
				bind(position, nameTextArray[position])
			}
		}
	}

	inner class ViewHolder(private val itemBinding: ListGenericItemTextOnlyBinding) : RecyclerView.ViewHolder(
		itemBinding.root
	) {
		fun bind(
			position: Int,
			titleName: String
		) {
			itemBinding.itemNameTv.text = titleName
			itemBinding.itemRootLlLayout.setOnClickListener {
				when (position) {
//					0 -> changeFragment()
				}
			}
		}
	}
}
