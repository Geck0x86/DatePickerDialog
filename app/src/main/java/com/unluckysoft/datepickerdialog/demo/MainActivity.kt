package com.unluckysoft.datepickerdialog.demo

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.unluckysoft.library.datepickerdialog.DatePickerDialog
import com.unluckysoft.library.datepickerdialog.DatePickerView
import kotlinx.android.synthetic.main.date_picker_dialog.*
import kotlinx.android.synthetic.main.main_activity.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        btnLaunchDialogSimple.setOnClickListener {

            val dialog = DatePickerDialog.newInstance()

            dialog.datePickerView.setOnBtnAcceptClickListener(object : DatePickerView.OnBtnAcceptClickListener {
                override fun onClick(view: View) {

                }
            })

            dialog.datePickerView.setOnBtnCancelClickListener(object : DatePickerView.OnBtnCancelClickListener {
                override fun onClick(view: View) {
                    dialog.dismiss()
                }
            })

            dialog.show(supportFragmentManager, "DatePickerDialog")
        }

        btnLaunchDialogRange.setOnClickListener {

            val dialog = DatePickerDialog.newInstance(DatePickerDialog.TYPE_RANGE)

            dialog.show(supportFragmentManager, "DatePickerDialog")
        }
    }
}
