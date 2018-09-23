package com.unluckysoft.library.datepickerdialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.google.android.material.button.MaterialButton
import com.unluckysoft.library.R
import java.text.SimpleDateFormat
import java.util.*


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

        val viewRoot = inflater.inflate(R.layout.date_picker_dialog, container, true)

        val btnFrom = viewRoot.findViewById<MaterialButton>(R.id.btnFrom)
        val datePickerFrom = viewRoot.findViewById<DatePickerView>(R.id.datePickerView).datePicker

        val cal = Calendar.getInstance()

        if (dialogType == DialogType.TYPE_SIMPLE) {

            btnFrom?.let {
                it.visibility = View.GONE
            }
        } else {

            btnFrom?.let {
                val date = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(cal.time)

                it.text = "From: $date"
            }
        }

        datePickerFrom?.init(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH))
        { datePicker, year, month, dayOfMonth ->

            btnFrom?.let {
                cal.set(year, month, dayOfMonth)
                val date = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(cal.time)

                it.text = "From: $date"
            }
        }

        return viewRoot
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}