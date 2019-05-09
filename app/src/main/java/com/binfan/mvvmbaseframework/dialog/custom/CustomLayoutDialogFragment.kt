package com.orderPay.ui.dialog

import android.app.Dialog
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v4.app.FragmentManager
import android.support.v7.app.AlertDialog
import com.binfan.mvvmbaseframework.R
import com.binfan.mvvmbaseframework.databinding.DialogGenericLayoutBinding
import com.binfan.mvvmbaseframework.dialog.custom.ButtonData
import com.binfan.mvvmbaseframework.dialog.custom.DialogButtonListAdapter
import com.binfan.mvvmbaseframework.dialog.custom.DialogButtonListAdapter.DialogCallback

/**
 * Use a DialogFragment as a container for dialog, as suggested on android official website.
 * The DialogFragment class provides all the controls you need to create your dialog
 * and manage its appearance, instead of calling methods on the Dialog object.
 *
 * @author Bin Fan (bin.fan@plexure.com)
 */
class CustomLayoutDialogFragment : DialogFragment(), DialogCallback {

    interface ButtonPositionClickListener {
        fun onButtonClicked(position: Int)
    }

    private var buttonPositionClickListener: ButtonPositionClickListener ? = null

    private lateinit var dialogBinding: DialogGenericLayoutBinding
    private val viewModel = DialogViewModel()
    private val buttonListAdapter = DialogButtonListAdapter(this)

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {

            val builder = AlertDialog.Builder(it)
            val inflater = requireActivity().layoutInflater

            dialogBinding = DataBindingUtil.inflate(
                inflater, R.layout.dialog_generic_layout, null, false
            )
            builder.setView(dialogBinding.root)

            dialogBinding.buttonListRv.adapter = buttonListAdapter

            dialogBinding.viewModel = viewModel
            builder.create()
        } ?: throw Throwable("Activity cannot be null")
    }

    fun bindData(
        title: String,
        message: String? = null,
        buttonDataList: MutableList<ButtonData>?,
        buttonPositionClickListener: ButtonPositionClickListener? = null
    ) {
        this.buttonPositionClickListener = buttonPositionClickListener
        viewModel.dialogTitle.value = title
        viewModel.dialogMessage.value = message
        buttonDataList?.let {
            if (buttonDataList.size > 0) {
                buttonListAdapter.updateItems(it)
            }
        }
    }

    override fun onButtonClicked(position: Int) {
        buttonPositionClickListener?.let { it.onButtonClicked(position) }
        dismiss()
    }

    companion object {

        private var instance: CustomLayoutDialogFragment? = null

        private val TAG = "CustomLayoutDialogFragment"

        private fun newInstance(): CustomLayoutDialogFragment {
            instance?.let {
                it.dismiss()
                instance = null
            }
            instance = CustomLayoutDialogFragment()
            return instance!!
        }

        fun showDialog(
            fragmentManager: FragmentManager,
            title: String,
            buttonDataList: MutableList<ButtonData>? = null
        ) {
            val fragment = newInstance()
            fragment.bindData(title, null, buttonDataList)
            fragment.show(fragmentManager, TAG)
        }

        fun showDefaultButtonListDialog(
            fragmentManager: FragmentManager,
            title: String,
            buttongNameList: List<String>? = null,
            buttonPositionClickListener: ButtonPositionClickListener? = null
        ) {
            val fragment = newInstance()
            val buttonDataList = mutableListOf<ButtonData>()
            buttongNameList?.let {
                for (nameStr in it) {
                    buttonDataList.add(ButtonData(nameStr))
                }
            }
            fragment.bindData(title, null, buttonDataList, buttonPositionClickListener)
            fragment.show(fragmentManager, TAG)
        }

        fun showMessageDialog(
            fragmentManager: FragmentManager,
            title: String,
            message: String? = null,
            buttonDataList: MutableList<ButtonData>? = null
        ) {
            val fragment = newInstance()
            fragment.bindData(title, message, buttonDataList)
            fragment.show(fragmentManager, TAG)
        }
    }
}

