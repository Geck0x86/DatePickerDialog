package com.unluckysoft.library.datepickerdialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.unluckysoft.library.R

class DatePickerDialog : DialogFragment() {

    companion object {
        fun newInstance(): DatePickerDialog {
            val fragment = DatePickerDialog()

            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val viewRoot = inflater.inflate(R.layout.date_picker_dialog, container)

        return viewRoot
    }
}