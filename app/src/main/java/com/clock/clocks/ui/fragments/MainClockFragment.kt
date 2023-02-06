package com.clock.clocks.ui.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import com.clock.clocks.databinding.FragmentMainBinding
import com.clock.clocks.ui.presentation.BaseFragment
import com.clock.clocks.viewmodels.MainClockViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@AndroidEntryPoint
class MainClockFragment :BaseFragment<FragmentMainBinding> (FragmentMainBinding::inflate){

    companion object {
        fun newInstance() = MainClockFragment()
    }

    private  val viewModel: MainClockViewModel
            by lazy {
                ViewModelProvider(requireActivity())[MainClockViewModel::class.java]
            }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycleScope.launch {
            withContext(Dispatchers.IO){
                insertDefault()
            }
            withContext(Dispatchers.IO){
                getSettings()
            }
        }


    }
    fun getSettings(){
        val id = viewModel.getId()
        viewModel.getColor(id)
        viewModel.getSetLanguageModel(id)
        viewModel.getClockAppearance(id)
        viewModel.getUse24HourFormat(id)
        viewModel.getAutomaticallyHideModel(id)
        viewModel.getClockOrientation(id)
        viewModel.getDateFormatModel(id)
        viewModel.getHideStatusBarModel(id)
        viewModel.getNightModeModel(id)
        viewModel.getSeparatorStyle(id)
        viewModel.getShowDateModel(id)
        viewModel.getShowDayNameModel(id)
        viewModel.getShowDayModel(id)
        viewModel.getShowLeadingZeroForHoursModel(id)
        viewModel.getShowWeatherStyleInformationModel(id)
        viewModel.getWhenPortraitModeModel(id)
        viewModel.getShowSecondsModel(id)
        viewModel.getBackground(id)
    }
    fun insertDefault(){
        viewModel.generateColor()
        viewModel.generateBackground()
        viewModel.generateClockOrientation()
        viewModel.generateClockAppearance()
        viewModel.generateAutomaticallyHideModel()
        viewModel.generateSeparatorStyle()
        viewModel.generateDateFormatModel()
        viewModel.generateHideStatusBarModel()
        viewModel.generateNightModeModel()
        viewModel.generateSetLanguageModel()
        viewModel.generateShowDateModel()
        viewModel.generateShowDayNameModel()
        viewModel.generateShowLeadingZeroForHoursModel()
        viewModel.generateShowDayModel()
        viewModel.generateWhenPortraitModeModel()
        viewModel.generateShowWeatherStyleInformationModel()
        viewModel.generateUse24HourFormat()
        viewModel.generateShowSecondsModel()
    }
}