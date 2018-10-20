package com.unluckysoft.library.datepickerdialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.unluckysoft.library.R
import java.util.*


class DatePickerDialog : DialogFragment() {

    companion object {

        const val TYPE_SIMPLE = 0
        const val TYPE_RANGE = 1

        fun newInstance(): DatePickerDialog {
            val fragment = DatePickerDialog()

            fragment.dialogType = TYPE_SIMPLE

            return fragment
        }

        fun newInstance(dialogType: Int): DatePickerDialog {
            val fragment = DatePickerDialog()

            fragment.dialogType = dialogType

            return fragment
        }
    }

    var dialogType: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val viewRoot = inflater.inflate(R.layout.date_picker_dialog, container, true)

        // val btnFrom = viewRoot.findViewById<MaterialButton>(R.id.btnFrom)
        val datePickerFrom = viewRoot.findViewById<DatePickerView>(R.id.datePickerView)

        val cal = Calendar.getInstance()

        if (dialogType == TYPE_SIMPLE) {

            datePickerFrom.range = false
            datePickerFrom.isFrom = false
            /*   btnFrom?.let {
                   it.visibility = View.GONE
               }*/
        } else {

            datePickerFrom.range = true
            datePickerFrom.isFrom = true

            /*btnFrom?.let {
                val date = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(cal.time)

                it.text = "From: $date"
            }*/
        }

        datePickerFrom.datePicker?.init(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH))
        { datePicker, year, month, dayOfMonth ->

            /*btnFrom?.let {
                cal.set(year, month, dayOfMonth)
                val date = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(cal.time)

                it.text = "From: $date"
            }*/
        }

        return viewRoot
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}