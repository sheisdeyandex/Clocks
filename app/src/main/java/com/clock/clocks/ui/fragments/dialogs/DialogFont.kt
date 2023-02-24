package com.clock.clocks.ui.fragments.dialogs

import android.content.res.Resources
import android.graphics.Color
import android.graphics.Rect
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.*
import androidx.fragment.app.DialogFragment
import com.clock.clocks.R
import com.clock.clocks.databinding.DialogFontBinding
import com.clock.clocks.domain.IFont


class DialogFont(val fontInterface:IFont):DialogFragment() {
    lateinit var binding: DialogFontBinding
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
        binding = DialogFontBinding.inflate(inflater, container,false)
        dialog?.window?.requestFeature(Window.FEATURE_NO_TITLE)
        val wmlp = dialog?.window?.attributes
        wmlp?.gravity = Gravity.CENTER
        wmlp?.y = 100
        dialog?.setCanceledOnTouchOutside(true)
        binding.rbDefault.isChecked = true
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setWidthPercent(100)
        binding.btnOk.setOnClickListener {
            fontInterface.getFont(getFont().first,getFont().second,getApplyToClockOnly())
            dismiss()
        }

    }
    private fun getApplyToClockOnly():Boolean{
        return binding.cbApplyToClockOnly.isChecked
    }
    private fun getFont():Pair<Int,String>{
        return when{
            binding.rbDefault.isChecked ->Pair(R.font.sans_serif,requireContext().getString(R.string.default_name))
            binding.rbWeb.isChecked ->Pair(R.font.font,requireContext().getString(R.string.web))
            binding.rbThick.isChecked ->Pair(R.font.thick,requireContext().getString(R.string.thick))
            binding.rbOld.isChecked ->Pair(R.font.old,requireContext().getString(R.string.old))
            binding.rbUbuntu.isChecked ->Pair(R.font.ubuntu,requireContext().getString(R.string.ubuntu))
            binding.rbAndroid.isChecked ->Pair(R.font.android,requireContext().getString(R.string.android))
            binding.rbSnipper.isChecked ->Pair(R.font.spinner,requireContext().getString(R.string.Snipper))
            binding.rbCourier.isChecked ->Pair(R.font.courier,requireContext().getString(R.string.courier))
            binding.rbSevenSegments.isChecked ->Pair(R.font.seven_segments,requireContext().getString(R.string.seven_segments))
            binding.rbRoboto.isChecked ->Pair(R.font.roboto,requireContext().getString(R.string.roboto))
            binding.rbRoboto2.isChecked ->Pair(R.font.roboto,requireContext().getString(R.string.roboto2))
            else -> Pair(R.font.sans_serif,requireContext().getString(R.string.default_name))
        }
    }
//    private fun getColor():Pair<String,String>{
//        return when{
//            binding.rbBlack.isChecked -> Pair(Integer.toHexString(ContextCompat.getColor(requireContext(), R.color.black)).substring(2).uppercase(),requireContext().getString(R.string.red))
//            binding.rbCustomColor.isChecked ->Pair( Integer.toHexString(ContextCompat.getColor(requireContext(), R.color.green)).substring(2).uppercase(),requireContext().getString(R.string.green))
//            binding.rbManualHexColor.isChecked ->Pair( Integer.toHexString(ContextCompat.getColor(requireContext(), R.color.yellow)).substring(2).uppercase(),requireContext().getString(R.string.yellow))
//            binding.rbGallery.isChecked ->Pair( Integer.toHexString(ContextCompat.getColor(requireContext(), R.color.blue)).substring(2).uppercase(),requireContext().getString(R.string.blue))
//            else ->  Pair(Integer.toHexString(ContextCompat.getColor(requireContext(), R.color.red)).substring(2).uppercase(),requireContext().getString(R.string.red))
//        }
//    }

}