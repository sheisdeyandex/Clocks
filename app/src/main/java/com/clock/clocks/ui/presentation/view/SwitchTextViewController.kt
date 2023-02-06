package com.clock.clocks.ui.presentation.view

import android.widget.TextView
import androidx.core.view.isVisible
import com.google.android.material.checkbox.MaterialCheckBox
import com.google.android.material.switchmaterial.SwitchMaterial

object SwitchTextViewController {
    fun baseControl(switch: SwitchMaterial, textView: TextView, textChecked: String, textNotChecked: String) {
        textView.text = if (switch.isChecked) textChecked else textNotChecked
        switch.setOnCheckedChangeListener { buttonView, isChecked ->
            textView.text = if (isChecked) textChecked else textNotChecked
        }
    }
    fun oneSubsItemControl(switch: SwitchMaterial, textView: TextView, textChecked: String, textNotChecked: String, subCheckBox:MaterialCheckBox, subTextView:TextView) {
        textView.text = if (switch.isChecked) textChecked else textNotChecked
        subCheckBox.isVisible =! switch.isChecked
        subTextView.isVisible = !switch.isChecked
        switch.setOnCheckedChangeListener { buttonView, isChecked ->
            textView.text = if (isChecked) textChecked else textNotChecked
            subCheckBox.isVisible =! switch.isChecked
            subTextView.isVisible = !switch.isChecked
        }
    }
    fun oneSubsItemControlWithoutCheckBoxAndSubText(switch: SwitchMaterial, textView: TextView,  subTextView:TextView) {
        subTextView.isVisible = switch.isChecked
        switch.setOnCheckedChangeListener { buttonView, isChecked ->
            subTextView.isVisible = switch.isChecked
        }
    }
    fun twoSubItemsControl(switch: SwitchMaterial, textView: TextView, textChecked: String, textNotChecked: String, subCheckBox:MaterialCheckBox,subTextView:TextView, subCheckBox2:MaterialCheckBox,subTextView2:TextView) {
        textView.text = if (switch.isChecked) textChecked else textNotChecked
        subCheckBox.isVisible = switch.isChecked
        subCheckBox2.isVisible = switch.isChecked
        subTextView.isVisible = switch.isChecked
        subTextView2.isVisible = switch.isChecked
        switch.setOnCheckedChangeListener { buttonView, isChecked ->
            textView.text = if (isChecked) textChecked else textNotChecked
            subCheckBox.isVisible = switch.isChecked
            subCheckBox2.isVisible = switch.isChecked
            subTextView.isVisible = switch.isChecked
            subTextView2.isVisible = switch.isChecked
        }
    }
}