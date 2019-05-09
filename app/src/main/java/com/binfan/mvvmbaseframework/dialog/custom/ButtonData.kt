package com.binfan.mvvmbaseframework.dialog.custom

import android.view.View.OnClickListener
import com.binfan.mvvmbaseframework.model.ButtonResource

/**
 * Use ButtonData to bind each button on dialog button list,
 * also the clicklistener, background color, font courlor, button text need to be configured
 * within this class
 *
 * @author Bin Fan (bin.fan@plexure.com)
 */
data class ButtonData(
    val buttonTxt: String,
    val buttonRes: ButtonResource = ButtonResource.YELLOW_BUTTON,
    val clickListener: OnClickListener? = null
)
