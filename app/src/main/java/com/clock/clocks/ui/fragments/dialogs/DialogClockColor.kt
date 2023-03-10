package com.clock.clocks.ui.fragments.dialogs

import android.content.res.Resources
import android.graphics.Color
import android.graphics.Rect
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.provider.MediaStore.Audio.Radio
import android.view.*
import android.widget.CheckBox
import android.widget.RadioButton
import androidx.core.content.ContextCompat
import androidx.fragment.app.DialogFragment
import com.clock.clocks.R
import com.clock.clocks.databinding.DialogClockColorBinding
import com.clock.clocks.domain.IClockColor
import com.clock.clocks.domain.RandomHexColor


class DialogClockColor(val clockColorInterface:IClockColor):DialogFragment() {
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
        binding.rbRed.isChecked = true
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setWidthPercent(100)
        binding.btnOk.setOnClickListener {
            when {
                binding.rbCustomColor.isChecked ->customColorDialog.show(parentFragmentManager, "")
                binding.rbManualHexColor.isChecked ->""
                else-> clockColorInterface.getColorColor(getColor().first,getColor().second)
            }
            dismiss()
        }

    }
    private fun getColor():Pair<String,String>{
        return when{
            binding.rbRed.isChecked -> Pair(Integer.toHexString(ContextCompat.getColor(requireContext(), R.color.red)).substring(2).uppercase(),requireContext().getString(R.string.red))
            binding.rbGreen.isChecked ->Pair( Integer.toHexString(ContextCompat.getColor(requireContext(), R.color.green)).substring(2).uppercase(),requireContext().getString(R.string.green))
            binding.rbYellow.isChecked ->Pair( Integer.toHexString(ContextCompat.getColor(requireContext(), R.color.yellow)).substring(2).uppercase(),requireContext().getString(R.string.yellow))
            binding.rbBlue.isChecked ->Pair( Integer.toHexString(ContextCompat.getColor(requireContext(), R.color.blue)).substring(2).uppercase(),requireContext().getString(R.string.blue))
            binding.rbFuchsia.isChecked ->Pair( Integer.toHexString(ContextCompat.getColor(requireContext(), R.color.fuchsia)).substring(2).uppercase(),requireContext().getString(R.string.fuchsia))
            binding.rbWhite.isChecked ->Pair( Integer.toHexString(ContextCompat.getColor(requireContext(), R.color.white)).substring(2).uppercase(),requireContext().getString(R.string.white))
            binding.rbLightBlue.isChecked ->Pair( Integer.toHexString(ContextCompat.getColor(requireContext(), R.color.light_blue)).substring(2).uppercase(),requireContext().getString(R.string.light_blue))
            binding.rbRandom.isChecked ->Pair( RandomHexColor.getRandomHexColor(),requireContext().getString(R.string.random))
            else ->  Pair(Integer.toHexString(ContextCompat.getColor(requireContext(), R.color.red)).substring(2).uppercase(),requireContext().getString(R.string.red))
        }
    }

}