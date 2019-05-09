package com.orderPay.ui.dialog

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v4.app.FragmentManager
import android.support.v7.app.AlertDialog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.binfan.mvvmbaseframework.R

/**
 * Dialog for showing a loading spinner
 *
 * @author Bin Fan (bin.fan@plexure.com)
 */
class LoadingDialogFragment : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {

            val builder = AlertDialog.Builder(it)
            val inflater = requireActivity().layoutInflater

            builder.setView(inflater.inflate(R.layout.dialog_loading_spinner_layout, null))
            builder.create()
        } ?: throw Throwable("Activity cannot be null")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dialog.window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.setCanceledOnTouchOutside(false)
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    companion object {

        private val TAG = "LoadingDialogFragment"

        fun newInstance(): LoadingDialogFragment {
            return LoadingDialogFragment()
        }

        fun showLoadingSpinner(fragmentManager: FragmentManager): LoadingDialogFragment {
            val fragment = newInstance()
            fragment.show(fragmentManager, TAG)
            return fragment
        }
    }
}

