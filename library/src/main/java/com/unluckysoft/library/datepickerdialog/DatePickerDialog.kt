package com.unluckysoft.library.datepickerdialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.unluckysoft.library.R

class DatePickerDialog : DialogFragment() {

    companion object {

        enum class DialogType(val type: Int) {
            TYPE_SIMPLE(1),
            TYPE_RANGE(0)
        }

        fun newInstance(): DatePickerDialog {
            val fragment = DatePickerDialog()

            fragment.dialogType = DialogType.TYPE_SIMPLE

            return fragment
        }

        fun newInstance(dialogType: DialogType): DatePickerDialog {
            val fragment = DatePickerDialog()

            fragment.dialogType = dialogType

            return fragment
        }
    }

    lateinit var dialogType: DialogType

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val viewRoot = inflater.inflate(R.layout.date_picker_dialog, container)

        return viewRoot
    }
}