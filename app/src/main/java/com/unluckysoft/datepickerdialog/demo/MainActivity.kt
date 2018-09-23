package com.unluckysoft.datepickerdialog.demo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.unluckysoft.library.datepickerdialog.DatePickerDialog
import kotlinx.android.synthetic.main.main_activity.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        btnLaunchDialogSimple.setOnClickListener {

            val dialog = DatePickerDialog.newInstance()

            dialog.show(supportFragmentManager, "DatePickerDialog")
        }

        btnLaunchDialogRange.setOnClickListener {

            val dialog = DatePickerDialog.newInstance(DatePickerDialog.Companion.DialogType.TYPE_RANGE)

            dialog.show(supportFragmentManager, "DatePickerDialog")
        }
    }
}
