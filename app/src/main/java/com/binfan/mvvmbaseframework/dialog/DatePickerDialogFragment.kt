package com.orderPay.ui.dialog

import android.app.DatePickerDialog
import android.app.Dialog
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v4.app.FragmentManager
import android.support.v7.app.AlertDialog
import android.widget.NumberPicker
import com.binfan.mvvmbaseframework.R
import java.util.Calendar

/**
 * Dialog for showing a date picker dialog
 *
 * @author Bin Fan (bin.fan@plexure.com)
 */
class DatePickerDialogFragment : DialogFragment() {

    var listener: DatePickerDialog.OnDateSetListener? = null

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {

            val builder = AlertDialog.Builder(it)
            val inflater = requireActivity().layoutInflater
            val dialogView = inflater.inflate(R.layout.dialog_date_picker, null)

            val calender = Calendar.getInstance()
            val monthPicker = dialogView.findViewById(R.id.picker_month) as NumberPicker
            val yearPicker = dialogView.findViewById(R.id.picker_year) as NumberPicker

            monthPicker.minValue = 1
            monthPicker.maxValue = 12
            monthPicker.value = calender.get(Calendar.MONTH)

            val year = calender.get(Calendar.YEAR) - 2000
            yearPicker.minValue = year
            yearPicker.maxValue = year + 25
            yearPicker.value = year

            builder.setView(dialogView)
                .setPositiveButton(R.string.set) { _, _ ->
                    listener?.onDateSet(null, yearPicker.value, monthPicker.value, 0)
                }
                .setNegativeButton(R.string.cancel) { _, _ ->
                    dismiss()
                }
            builder.create()
        } ?: throw Throwable("Activity cannot be null")
    }

    companion object {

        private val TAG = "DatePickerDialogFragment"

        fun newInstance(): DatePickerDialogFragment {
            return DatePickerDialogFragment()
        }

        fun showDatePicker(fragmentManager: FragmentManager, listener: DatePickerDialog.OnDateSetListener? = null): DatePickerDialogFragment {
            val fragment = newInstance()
            fragment.show(fragmentManager, TAG)
            fragment.listener = listener
            return fragment
        }
    }
}
