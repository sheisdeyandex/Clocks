package com.clock.clocks.ui.fragments

import android.graphics.Color
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.View
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import com.clock.clocks.databinding.FragmentMainBinding
import com.clock.clocks.databinding.FragmentMainClockBinding
import com.clock.clocks.ui.presentation.BaseFragment
import com.clock.clocks.usecases.DateConvertor
import com.clock.clocks.viewmodels.MainClockViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@AndroidEntryPoint
class MainClockFragment :BaseFragment<FragmentMainClockBinding> (FragmentMainClockBinding::inflate){
    private  val viewModel: MainClockViewModel
            by lazy {
                ViewModelProvider(requireActivity())[MainClockViewModel::class.java]
            }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycleScope.launch {
            withContext(Dispatchers.IO){
                viewModel.insertAllDatabase(requireContext())
                viewModel.color = viewModel.getClockColor().clockColor
                viewModel.background = viewModel.getBackground().background
                val font = viewModel.getClockFont()
                viewModel.font = font.font
                viewModel.applyFontToClockOnly = font.applyToClockOnly
                val use24HourFormat = viewModel.getUse24HourFormat()
                viewModel.use24HourFormat  = use24HourFormat.use24HourFormat
                viewModel.showAmAndPm = use24HourFormat.showAmAndPm
                viewModel.showSeconds = viewModel.getShowSeconds().showSeconds
                viewModel.showSeperator = viewModel.getSeperator().seperatorStyle
            }
            withContext(Dispatchers.Main){
            //    getSettings()
                initDate()
                initBackground()
                initClock()
            }
        }


    }
    private fun initBackground() {
        binding.clMain.setBackgroundColor( Color.parseColor(viewModel.background))
    }
    private fun initDate(){
        binding.tvDate.setTextColor(Color.parseColor(viewModel.color))
        binding.tvDate.text = DateConvertor.getDate("MMM dd , yyyy, EEEE")
        if (!viewModel.applyFontToClockOnly){
            binding.tvDate.typeface = ResourcesCompat.getFont(requireContext(),viewModel.font)
        }
    }
    private fun initClock() {
        binding.tvClockHour.typeface = ResourcesCompat.getFont(requireContext(),viewModel.font)
        binding.tvClockHour.setTextColor(Color.parseColor(viewModel.color))
        binding.tvSeconds.typeface = ResourcesCompat.getFont(requireContext(),viewModel.font)
        binding.tvSeconds.setTextColor(Color.parseColor(viewModel.color))
        if (viewModel.use24HourFormat){
            if (viewModel.showSeperator){
                binding.tvClockHour.format24Hour = "kk\n:mm"
            }
            else{
                binding.tvClockHour.format24Hour = "kk\nmm"
            }
            binding.tvClockHour.format12Hour = null
            binding.tvSeconds.isVisible = viewModel.showSeconds
            if(viewModel.showSeconds){
                binding.tvSeconds.format24Hour = " ss"
                binding.tvSeconds.format12Hour = null
            }
        }
        else{
            if (viewModel.showSeperator){
                binding.tvClockHour.format12Hour = "h\n:mm"
            }
            else{
                binding.tvClockHour.format12Hour = "h\nmm"
            }
            binding.tvClockHour.format24Hour = null
            binding.tvSeconds.isVisible = viewModel.showSeconds
            if(viewModel.showSeconds){
                if (viewModel.showAmAndPm){
                    binding.tvSeconds.format12Hour = " ss\na"
                    binding.tvSeconds.format24Hour = null
                }
                else{
                    binding.tvSeconds.format12Hour = " ss"
                    binding.tvSeconds.format24Hour = null
                }

            }
        }
        }
    }
//    fun getSettings(){
//        val id = viewModel.getId()
//        viewModel.getColor(id)
//        viewModel.getSetLanguageModel(id)
//        viewModel.getClockAppearance(id)
//        viewModel.getUse24HourFormat(id)
//        viewModel.getAutomaticallyHideModel(id)
//        viewModel.getClockOrientation(id)
//       // viewModel.getDateFormatModel(id)
//        viewModel.getHideStatusBarModel(id)
//        viewModel.getNightModeModel(id)
//        viewModel.getSeparatorStyle(id)
//        viewModel.getShowDateModel(id)
//        viewModel.getShowDayNameModel(id)
//       // viewModel.getShowDayModel(id)
//        viewModel.getShowLeadingZeroForHoursModel(id)
//        viewModel.getShowWeatherStyleInformationModel(id)
//        viewModel.getWhenPortraitModeModel(id)
//        viewModel.getShowSecondsModel(id)
//        viewModel.getBackground(id)
//    }
//    fun insertDefault(){
//        viewModel.generateColor(requireContext())
//        viewModel.generateBackground(requireContext())
//        viewModel.generateClockOrientation()
//        viewModel.generateClockAppearance()
//        viewModel.generateAutomaticallyHideModel()
//        viewModel.generateSeparatorStyle()
//     //   viewModel.generateDateFormatModel()
//        viewModel.generateHideStatusBarModel()
//        viewModel.generateNightModeModel()
//        viewModel.generateSetLanguageModel()
//        viewModel.generateShowDateModel()
//        viewModel.generateShowDayNameModel()
//        viewModel.generateShowLeadingZeroForHoursModel()
//      //  viewModel.generateShowDayModel()
//        viewModel.generateWhenPortraitModeModel()
//        viewModel.generateShowWeatherStyleInformationModel()
//        viewModel.generateUse24HourFormat()
//        viewModel.generateShowSecondsModel()
//    }
