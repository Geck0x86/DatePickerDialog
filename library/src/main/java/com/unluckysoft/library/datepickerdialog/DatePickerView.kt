package com.unluckysoft.library.datepickerdialog

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.DatePicker
import android.widget.LinearLayout
import android.widget.Switch
import com.google.android.material.button.MaterialButton
import com.unluckysoft.library.R
import java.text.SimpleDateFormat
import java.util.*

class DatePickerView : LinearLayout {

    var attrs: AttributeSet? = null

    var viewRoot: View

    var datePicker: DatePicker?

    var btnToggle: MaterialButton?

    var swActive: Switch?

    var range: Boolean = false
        set(value) {
            setRangeMode(value)
        }

    var isFrom: Boolean = true
        set(value) {
            setIsFrom(value)
        }

    constructor(context: Context) : super(context) {
        this.attrs = null
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        this.attrs = attrs
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        this.attrs = attrs
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int) : super(context, attrs, defStyleAttr, defStyleRes) {
        this.attrs = attrs
    }

    init {
        viewRoot = LayoutInflater.from(context).inflate(R.layout.date_picker_view, this, true)

        datePicker = viewRoot.findViewById(R.id.datePicker)
        btnToggle = viewRoot.findViewById(R.id.btnToggle)
        swActive = viewRoot.findViewById(R.id.swActive)

        attrs?.let {

            val typedArray = context.obtainStyledAttributes(it,
                    R.styleable.DatePickerView, 0, 0)

            isFrom = typedArray.getBoolean(R.styleable.DatePickerView_dp_isfrom, false)

            /*if (!isFrom) {
                setIsFrom(isFrom)
            }*/

            range = typedArray.getBoolean(R.styleable.DatePickerView_dp_range, false)

            /*if (!range) {
                setRangeMode(range)
            }*/

            typedArray.recycle()
        }


    }

    private fun setRangeMode(range: Boolean) {

        btnToggle?.visibility = if (range) {

            val calendar = Calendar.getInstance()

            val date = setStringDate(isFrom, calendar)

            btnToggle?.text = date

            View.VISIBLE
        } else {
            View.GONE
        }

        swActive?.visibility = if (range) {
            View.VISIBLE
        } else {
            View.GONE
        }
    }

    private fun setIsFrom(value: Boolean) {

        val calendar = Calendar.getInstance()

        val date = setStringDate(value, calendar)

        btnToggle?.text = date
    }

    private fun setStringDate(value: Boolean, calendar: Calendar): String? {
        var hours = 0
        var minutes = 0
        var seconds = 0

        if (!value) {
            hours = 23
            minutes = 59
            seconds = 59
        }

        calendar.set(datePicker?.year!!, datePicker?.month!!, datePicker?.dayOfMonth!!, hours, minutes, seconds)

        return SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(calendar.time)
    }
}