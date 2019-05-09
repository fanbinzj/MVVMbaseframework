package com.binfan.mvvmbaseframework.dialog.custom

import com.binfan.mvvmbaseframework.base.BaseViewModel

/**
 * Dialog button view model
 *
 * @author Bin Fan (bin.fan@plexure.com)
 */
class DialogButtonViewModel : BaseViewModel() {

    private lateinit var buttonData: ButtonData

    fun bind(buttonData: ButtonData) {
      this.buttonData = buttonData
    }

    fun getBtnTextRes() = buttonData.buttonTxt

    fun getBtnBgRes() = buttonData.buttonRes.getBgDrawable()

    fun getBtnFontColorRes() = buttonData.buttonRes.getFontDrawable()
}

