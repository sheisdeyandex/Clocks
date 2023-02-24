package com.clock.clocks.ui.fragments.dialogs

import android.content.res.Resources
import android.graphics.Color
import android.graphics.Rect
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.*
import androidx.fragment.app.DialogFragment
import com.clock.clocks.R
import com.clock.clocks.databinding.DialogClockOrientationBinding
import com.clock.clocks.databinding.DialogFontBinding
import com.clock.clocks.domain.IClockOrientation
import com.clock.clocks.domain.IFont
import com.clock.clocks.usecases.Constants


class DialogClockOrientation(val iClockOrientationInterface:IClockOrientation):DialogFragment() {
    lateinit var binding: DialogClockOrientationBinding
    private fun DialogFragment.setWidthPercent(percentage: Int) {
        val percent = percentage.toFloat() / 100
        val displayMetrics = Resources.getSystem().displayMetrics
        val rect = displayMetrics.run { Rect(0, 0, widthPixels, heightPixels) }
        val percentWidth = rect.width() * percent
        dialog?.window?.setLayout(percentWidth.toInt(), ViewGroup.LayoutParams.WRAP_CONTENT)
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = DialogClockOrientationBinding.inflate(inflater, container,false)
        dialog?.window?.requestFeature(Window.FEATURE_NO_TITLE)
        val wmlp = dialog?.window?.attributes
        wmlp?.gravity = Gravity.CENTER
        wmlp?.y = 100
        dialog?.setCanceledOnTouchOutside(true)
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setWidthPercent(100)
        binding.btnOk.setOnClickListener {
            iClockOrientationInterface.getOrientation(getOrientation())
            dismiss()
        }

    }

    private fun getOrientation():String{
        return when{
           binding.rbLandScape.isChecked ->Constants.landscape
           binding.rbPortrait.isChecked ->Constants.portrait
           binding.rbAutomatic.isChecked ->Constants.automatic
            else->Constants.automatic
        }
    }


}