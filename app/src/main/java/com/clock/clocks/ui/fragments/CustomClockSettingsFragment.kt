package com.clock.clocks.ui.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.lifecycleScope
import com.clock.clocks.R
import com.clock.clocks.databinding.FragmentCustomClockSettingsBinding
import com.clock.clocks.viewmodels.CustomClockSettingsViewModel
import com.clock.clocks.ui.fragments.dialogs.DialogClockColor
import com.clock.clocks.ui.presentation.BaseFragment
import com.clock.clocks.ui.presentation.view.SwitchTextViewController
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@AndroidEntryPoint
class CustomClockSettingsFragment : BaseFragment<FragmentCustomClockSettingsBinding>(FragmentCustomClockSettingsBinding::inflate) {
    private val viewModel: CustomClockSettingsViewModel by lazy {
        ViewModelProvider(requireActivity())[CustomClockSettingsViewModel::class.java]
    }
    private val dialogClockColor by lazy {
        DialogClockColor()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initThemes()
        initClicks()
        lifecycleScope.launch {
            withContext(Dispatchers.IO){
                viewModel.insertAllDatabase()
                Log.d("suka",viewModel.getAllFromDatabase().clockColor.toString())
                Log.d("suka",viewModel.getAllFromDatabase().id.toString())

            }
        }
    }
    private fun initClicks(){
        binding.llClockColor.setOnClickListener {
            dialogClockColor.show(parentFragmentManager,"")
        }
    }
    private fun initThemes(){
        SwitchTextViewController.baseControl(
            binding.swWhenPortraitMode,
            binding.tvSelectedWhenPortraitMode,
            getString(R.string.vertical_clock),
            getString(R.string.horizontal_clock
            )
        )
        SwitchTextViewController.baseControl(
            binding.swClockAppearance,
            binding.tvSelectedClockAppereance,
            getString(R.string.extended),
            getString(R.string.compact)
        )
        SwitchTextViewController.baseControl(
            binding.swNightMode,
            binding.tvSelectedNightMode,
            getString(R.string.activated),
            getString(R.string.deactivated)
        )
        SwitchTextViewController.oneSubsItemControl(
            binding.swUse24HourFormat,
            binding.tvSelectedUse24HourFormat,
            "13:00",
            "1:00",
            binding.cbShowAmAndPm,
            binding.tvShowAmAndPm
        )
        SwitchTextViewController.oneSubsItemControlWithoutCheckBoxAndSubText(
            binding.swShowWeatherInformation,
            binding.tvShowWeatherInformation,
            binding.tvWeatherSettings
        )
        SwitchTextViewController.twoSubItemsControl(
            binding.swSeperatorStyle,
            binding.tvSelectedSeperatorStyle,
            getString(R.string.blinking),
            getString(R.string.not_blinking),
            binding.cbShowSeperatorLandScape,
            binding.tvShowSeperatorLandScape,
            binding.cbShowSeperatorPortrait,
            binding.tvShowSeperatorPortrait
        )
    }
}