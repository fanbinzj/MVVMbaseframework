package com.binfan.mvvmbaseframework.model

import android.graphics.drawable.Drawable
import com.binfan.mvvmbaseframework.R
import com.binfan.mvvmbaseframework.shared.utils.ResourcesUtils

/**
 * Enum class implementation
 *
 * @author Bin Fan (binfannz@gmail.com)
 */

enum class DateFormat(val raw: String) {
	OFFERS_SERVER_DATE_TIME("yyyy-MM-dd'T'HH:mm:ss'Z'"),
	SERVER_DATE_TIME_NO_Z("yyyy-MM-dd'T'HH:mm:ss"),
	SERVER_TIME("HH:mm:ss"),
	HOURS24_MINUTES("HH:mm"),
	OFFERS_DATE_TIME("yyyy-MM-dd (E) HH:mm"),
	MONTH_DAY("MM/dd"),
}

enum class ButtonResource(
	private val bgColorRes: Int,
	private val fontColorRes: Int
) {
	YELLOW_BUTTON(R.drawable.dialog_rounded_button_yellow, R.color.generic_text_grey_color),
	GREY_BUTTON(R.drawable.dialog_rounded_button_grey, R.color.generic_text_grey_color),
	DARK_GREY_BUTTON(R.drawable.dialog_rounded_button_dark_grey, R.color.dialog_yellow);

	fun getBgDrawable(): Drawable? {
		return ResourcesUtils.getInstance().getDrawable(bgColorRes)
	}

	fun getFontDrawable(): Int {
		return ResourcesUtils.getInstance().getColor(fontColorRes)
	}
}
