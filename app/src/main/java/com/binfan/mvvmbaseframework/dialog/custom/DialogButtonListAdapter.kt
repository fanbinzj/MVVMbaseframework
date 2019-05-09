package com.binfan.mvvmbaseframework.dialog.custom

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.binfan.mvvmbaseframework.R
import com.binfan.mvvmbaseframework.databinding.ButtonItemOnlyBinding

/**
 * An adapter for a dialog button list view
 *
 * @author Bin Fan (bin.fan@plexure.com)
 */
class DialogButtonListAdapter(val dialogCallBack: DialogCallback) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    interface DialogCallback {
        fun onButtonClicked(position: Int)
    }

    private lateinit var buttonDataList: MutableList<ButtonData>

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerView.ViewHolder {

        val binding: com.binfan.mvvmbaseframework.databinding.ButtonItemOnlyBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context), R.layout.button_item_only, parent, false
        )

        return ViewHolder(binding, dialogCallBack)
    }

    override fun getItemCount(): Int {
        return if (::buttonDataList.isInitialized) buttonDataList.size else 0
    }

    override fun onBindViewHolder(
        holder: RecyclerView.ViewHolder,
        position: Int
    ) {
        (holder as ViewHolder).apply {
            bind(buttonDataList[position])
        }
    }

    fun updateItems(buttonDataList: MutableList<ButtonData>) {
        this.buttonDataList = buttonDataList
        notifyDataSetChanged()
    }

    class ViewHolder(val binding: ButtonItemOnlyBinding, val dialogCallBack: DialogCallback) : RecyclerView.ViewHolder(
        binding.root
    ) {

        private val viewModel = DialogButtonViewModel()

        fun bind(buttonData: ButtonData) {
            viewModel.bind(buttonData)
            binding.viewModel = viewModel

            binding.buttonListButton.setOnClickListener {
                view ->
                    dialogCallBack.onButtonClicked(adapterPosition)
                    buttonData.clickListener?.let {
                        it.onClick(view)
                    }
            }

        }
    }
}
