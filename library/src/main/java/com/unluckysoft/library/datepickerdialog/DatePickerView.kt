package com.unluckysoft.library.datepickerdialog

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.DatePicker
import android.widget.LinearLayout
import com.unluckysoft.library.R

class DatePickerView : LinearLayout {

    var attrs: AttributeSet? = null

    var datePicker: DatePicker?

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
        val viewRoot = LayoutInflater.from(context).inflate(R.layout.date_picker_view, this, true)

        datePicker = viewRoot.findViewById(R.id.datePicker)

        attrs?.let {
            /*val typedArray = context.obtainStyledAttributes(it,
                    R.styleable.custom_component_attributes, 0, 0)
            val title = resources.getText(typedArray
                    .getResourceId(R.styleable
                            .custom_component_attributes_custom_component_title,
                            R.string.component_one))

            my_title.text = title
            my_edit.hint =
                    "${resources.getString(R.string.hint_text)} $title"

            typedArray.recycle()*/
        }
    }
}