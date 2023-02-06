package com.clock.clocks.ui.fragments.dialogs

import android.annotation.SuppressLint
import android.content.res.Resources
import android.graphics.Color
import android.graphics.Rect
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import com.clock.clocks.databinding.DialogClockColorBinding
import com.clock.clocks.databinding.DialogClockCustomColorBinding
import com.skydoves.colorpickerview.AlphaTileView
import com.skydoves.colorpickerview.ColorEnvelope
import com.skydoves.colorpickerview.listeners.ColorEnvelopeListener
import com.skydoves.colorpickerview.listeners.ColorPickerViewListener


class DialogClockCustomColor:DialogFragment() {
    lateinit var binding: DialogClockCustomColorBinding
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
        binding = DialogClockCustomColorBinding.inflate(inflater, container,false)
        dialog?.window?.requestFeature(Window.FEATURE_NO_TITLE)
        val wmlp = dialog?.window?.attributes
        wmlp?.gravity = Gravity.CENTER
        wmlp?.y = 100
        dialog?.setCanceledOnTouchOutside(true)
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        return binding.root
    }
    private fun setLayoutColor(envelope: ColorEnvelope) {
        binding.cvNewColor.setBackgroundColor(envelope.color)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setWidthPercent(100)
        initClicks()
    }
    fun initClicks(){
        binding.colorPickerView.setColorListener(
            ColorEnvelopeListener { envelope, _ -> setLayoutColor(envelope) }
        )
        binding.btnCancel.setOnClickListener {
            dismiss()
        }
    }

}