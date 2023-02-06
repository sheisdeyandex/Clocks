package com.clock.clocks.ui.fragments.dialogs

import android.content.res.Resources
import android.graphics.Color
import android.graphics.Rect
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.*
import androidx.fragment.app.DialogFragment
import com.clock.clocks.databinding.DialogClockColorBinding


class DialogClockColor:DialogFragment() {
    lateinit var binding: DialogClockColorBinding
    private val customColorDialog by lazy {
        DialogClockCustomColor()
    }
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
        binding = DialogClockColorBinding.inflate(inflater, container,false)
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
            getSelectedAction()
        }

    }
    private fun getSelectedAction() {
        when {
            binding.rbRed.isChecked -> ""
            binding.rbGreen.isChecked -> ""
            binding.rbYellow.isChecked ->""
            binding.rbBlue.isChecked ->""
            binding.rbFuchsia.isChecked ->""
            binding.rbWhite.isChecked ->""
            binding.rbLightBlue.isChecked ->""
            binding.rbCustomColor.isChecked -> customColorDialog.show(parentFragmentManager, "")
            binding.rbManualHexColor.isChecked ->""
            binding.rbRandom.isChecked ->""
        }
    }

}