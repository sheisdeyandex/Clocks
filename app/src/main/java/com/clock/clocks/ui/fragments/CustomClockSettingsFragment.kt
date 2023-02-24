package com.clock.clocks.ui.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import com.clock.clocks.R
import com.clock.clocks.databinding.FragmentCustomClockSettingsBinding
import com.clock.clocks.domain.IBackgroundColor
import com.clock.clocks.domain.IClockColor
import com.clock.clocks.domain.IClockOrientation
import com.clock.clocks.domain.IFont
import com.clock.clocks.ui.fragments.dialogs.DialogBackgroundColor
import com.clock.clocks.viewmodels.CustomClockSettingsViewModel
import com.clock.clocks.ui.fragments.dialogs.DialogClockColor
import com.clock.clocks.ui.fragments.dialogs.DialogClockOrientation
import com.clock.clocks.ui.fragments.dialogs.DialogFont
import com.clock.clocks.ui.presentation.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@AndroidEntryPoint
class CustomClockSettingsFragment : BaseFragment<FragmentCustomClockSettingsBinding>(FragmentCustomClockSettingsBinding::inflate),IClockColor,IBackgroundColor,IFont,IClockOrientation {
    private val viewModel: CustomClockSettingsViewModel by lazy {
        ViewModelProvider(requireActivity())[CustomClockSettingsViewModel::class.java]
    }
    private val dialogClockColor by lazy {
        DialogClockColor(this)
    }
    private val dialogBackgroundColor by lazy {
        DialogBackgroundColor(this)
    }
    private val dialogClockFont by lazy {
        DialogFont(this)
    }
    private val dialogClockOrientation by lazy {
        DialogClockOrientation(this)
    }
    private lateinit var clockColor:String
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClicks()
        lifecycleScope.launch {
            withContext(Dispatchers.IO){
                viewModel.insertAllDatabase(requireContext())
                viewModel.clockColor = viewModel.getClockColor().name
                viewModel.backgroundColor = viewModel.getBackgroundColor().name
                viewModel.clockFont = viewModel.getFont().name
                viewModel.clockOrientation = viewModel.getClockOrientation().orientation
                val seperator = viewModel.getSeperatorStyle()
                viewModel.seperatorStyle = seperator.seperatorStyle
                viewModel.showSeperatorWhenInLandscape = seperator.showSeperatorWhenInLandScape
                viewModel.showSeperatorWhenInPortrait = seperator.showSeperatorWhenInPortrait
                viewModel.weatherInformation = viewModel.getWeatherInformation().showWeatherStyleInformationModel
                viewModel.clockAppearance = viewModel.getClockAppearance().clockAppearance
                viewModel.nightMode = viewModel.getNightMode().nightMode
                viewModel.showSeconds = viewModel.getShowSeconds().showSeconds
                viewModel.showDate = viewModel.getShowDate().showDate
                viewModel.showDay = viewModel.getShowDay().showDay
            }
            withContext(Dispatchers.Main){
                initViews()
                initWhenInPortraitMode()
                initUse24HourFormat()
                initShowLeadingZeroForHours()
                initSeperatorStyle()
                initShowWeatherInformation()
                initClockAppearance()
                initNightMode()
                initShowSeconds()
                initShowDate()
                initShowDay()
            }
        }
    }
    private fun initClicks(){
        binding.llClockColor.setOnClickListener {
            dialogClockColor.show(parentFragmentManager,"")
        }
        binding.llBackground.setOnClickListener {
            dialogBackgroundColor.show(parentFragmentManager,"")
        }
        binding.llClockFont.setOnClickListener {
            dialogClockFont.show(parentFragmentManager,"")
        }
        binding.llClockOrientation.setOnClickListener {
            dialogClockOrientation.show(parentFragmentManager,"")
        }
    }
    private fun initViews(){
        binding.tvSelectedClockColor.text = viewModel.clockColor
        binding.tvSelectedBackground.text = viewModel.backgroundColor
        binding.tvSelectedClockFont.text = viewModel.clockFont
        binding.tvSelectedClockOrientation.text = viewModel.clockOrientation
    }

    private fun initWhenInPortraitMode(){
        binding.swWhenPortraitMode.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked){
                binding.tvSelectedWhenPortraitMode.text = requireContext().getString(R.string.vertical_clock)
            }
            else{
                binding.tvSelectedWhenPortraitMode.text = requireContext().getString(R.string.horizontal_clock)
            }
            lifecycleScope.launch {
                withContext(Dispatchers.IO){
                    viewModel.insertWhenInPortraitMode(isChecked)
                }
            }
        }
    }
    private fun initUse24HourFormat(){
        binding.swUse24HourFormat.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked){
                binding.tvSelectedUse24HourFormat.text = "1:00"
                binding.cbShowAmAndPm.isVisible = false
                binding.tvShowAmAndPm.isVisible = false
            }
            else{
                binding.tvSelectedUse24HourFormat.text = "13:00"
                binding.cbShowAmAndPm.isVisible = true
                binding.tvShowAmAndPm.isVisible = true
            }
            lifecycleScope.launch {
                val checked = binding.cbShowAmAndPm.isChecked
                withContext(Dispatchers.IO){
                    viewModel.insertUse24HourFormat(isChecked, checked)
                }
            }
        }
    }
    private fun initShowLeadingZeroForHours(){
        binding.swShowLeadingZeroForHours.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked){
                binding.tvSelectedShowLeadingZeroForHours.text = "08:30"
            }
            else{
                binding.tvSelectedShowLeadingZeroForHours.text = "8:30"
            }
            lifecycleScope.launch {
                withContext(Dispatchers.IO){
                    viewModel.insertShowLeadingZeroForHours(isChecked)
                }
            }
        }
    }
    private fun initSeperatorStyle(){
        binding.swSeperatorStyle.isChecked = viewModel.seperatorStyle
        binding.cbShowSeperatorLandScape.isChecked = viewModel.showSeperatorWhenInLandscape
        binding.cbShowSeperatorPortrait.isChecked = viewModel.showSeperatorWhenInPortrait
        binding.tvShowSeperatorPortrait.isVisible = binding.swSeperatorStyle.isChecked
        binding.tvShowSeperatorLandScape.isVisible=  binding.swSeperatorStyle.isChecked
        if (binding.swSeperatorStyle.isChecked){
            binding.tvSelectedSeperatorStyle.text = requireContext().getString(R.string.blinking)
        }
        else{
            binding.tvSelectedSeperatorStyle.text = requireContext().getString(R.string.not_blinking)
        }
        binding.cbShowSeperatorLandScape.setOnCheckedChangeListener { buttonView, isChecked ->
            lifecycleScope.launch {
                val seperatorPortrait = binding.cbShowSeperatorPortrait.isChecked
                withContext(Dispatchers.IO){
                    viewModel.insertSeperatorStyle(true,isChecked,seperatorPortrait)
                }
            }
        }
        binding.cbShowSeperatorLandScape.setOnCheckedChangeListener { buttonView, isChecked ->
            lifecycleScope.launch {
                val seperatorLandscape = binding.cbShowSeperatorLandScape.isChecked
                withContext(Dispatchers.IO){
                    viewModel.insertSeperatorStyle(true,seperatorLandscape,isChecked)
                }
            }
        }
        binding.swSeperatorStyle.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked){
                binding.tvSelectedSeperatorStyle.text = requireContext().getString(R.string.blinking)

            }
            else{
                binding.tvSelectedSeperatorStyle.text = requireContext().getString(R.string.not_blinking)
            }
            binding.tvShowSeperatorPortrait.isVisible = isChecked
            binding.tvShowSeperatorLandScape.isVisible=  isChecked
            binding.cbShowSeperatorPortrait.isVisible = isChecked
            binding.cbShowSeperatorLandScape.isVisible=  isChecked

            lifecycleScope.launch {
                val seperatorLandscape = binding.cbShowSeperatorLandScape.isChecked
                val seperatorPortrait = binding.cbShowSeperatorPortrait.isChecked
                withContext(Dispatchers.IO){
                    viewModel.insertSeperatorStyle(isChecked,seperatorLandscape,seperatorPortrait)
                }
            }
        }
    }
    private fun initShowWeatherInformation(){
        binding.swShowWeatherInformation.isChecked = viewModel.weatherInformation
        binding.swShowWeatherInformation.setOnCheckedChangeListener { buttonView, isChecked ->
            binding.tvWeatherSettings.isVisible = isChecked
            lifecycleScope.launch {
                withContext(Dispatchers.IO){
                    viewModel.insertShowWeatherInformation(isChecked)
                }
            }
        }
    }
    private fun initClockAppearance(){
        binding.swClockAppearance.isChecked = viewModel.clockAppearance
        if ( binding.swClockAppearance.isChecked){
            binding.tvSelectedClockAppereance.text = requireContext().getString(R.string.extended)
        }
        else{
            binding.tvSelectedClockAppereance.text = requireContext().getString(R.string.compact)
        }
        binding.swClockAppearance.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked){
                binding.tvSelectedClockAppereance.text = requireContext().getString(R.string.extended)
            }
            else{
                binding.tvSelectedClockAppereance.text = requireContext().getString(R.string.compact)
            }
            lifecycleScope.launch {
                withContext(Dispatchers.IO){
                    viewModel.insertClockAppearance(isChecked)
                }
            }
        }
    }
    private fun initNightMode(){
        binding.swNightMode.isChecked = viewModel.nightMode
        if ( binding.swNightMode.isChecked){
            binding.tvSelectedNightMode.text = requireContext().getString(R.string.activated)
        }
        else{
            binding.tvSelectedNightMode.text = requireContext().getString(R.string.deactivated)
        }
        binding.swNightMode.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked){
                binding.tvSelectedNightMode.text = requireContext().getString(R.string.activated)
            }
            else{
                binding.tvSelectedNightMode.text = requireContext().getString(R.string.deactivated)
            }
            lifecycleScope.launch {
                withContext(Dispatchers.IO){
                    viewModel.insertNightMode(isChecked)
                }
            }
        }
    }
    private fun initShowSeconds(){
        binding.cbShowSeconds.isChecked = viewModel.showSeconds
        binding.cbShowSeconds.setOnCheckedChangeListener { buttonView, isChecked ->
            lifecycleScope.launch {
                withContext(Dispatchers.IO){
                    viewModel.insertShowSeconds(isChecked)
                }
            }

        }
    }
    private fun initShowDate(){
        binding.cvShowDate.isChecked = viewModel.showDate
        binding.cvShowDate.setOnCheckedChangeListener { buttonView, isChecked ->
            lifecycleScope.launch {
                withContext(Dispatchers.IO){
                    viewModel.insertShowDate(isChecked)
                }
            }
        }
    }
    private fun initShowDay(){
        binding.cvShowDay.isChecked = viewModel.showDate
        binding.cvShowDay.setOnCheckedChangeListener { buttonView, isChecked ->
            lifecycleScope.launch {
                withContext(Dispatchers.IO){
                    viewModel.insertShowDay(isChecked)
                }
            }
        }
    }
    override fun getColorColor(color: String,name:String) {
        lifecycleScope.launch {
            withContext(Dispatchers.IO){
                viewModel.insertClockColor(color,name)
                clockColor = viewModel.getClockColor().name
            }
            withContext(Dispatchers.Main){
                binding.tvSelectedClockColor.text = clockColor
            }
        }
    }

    override fun getBackground(color: String, name: String) {
        lifecycleScope.launch {
            withContext(Dispatchers.IO){
                viewModel.insertBackgroundColor(color,name)
                viewModel.backgroundColor = viewModel.getBackgroundColor().name
            }
            withContext(Dispatchers.Main){
                binding.tvSelectedBackground.text = viewModel.backgroundColor
            }

    }
    }

    override fun getFont(font: Int, name: String, applyToClockOnly: Boolean) {
        lifecycleScope.launch {
            withContext(Dispatchers.IO) {
                viewModel.insertFont(font, name, applyToClockOnly)
                viewModel.clockFont = viewModel.getFont().name
            }
            withContext(Dispatchers.Main) {
                binding.tvSelectedClockFont.text = viewModel.clockFont
            }
        }}

    override fun getOrientation(orientation: String) {
        lifecycleScope.launch {
            withContext(Dispatchers.IO) {
                viewModel.insertClockOrientation(orientation)
                viewModel.clockOrientation = viewModel.getClockOrientation().orientation
            }
            withContext(Dispatchers.Main) {
                binding.tvSelectedClockOrientation.text = viewModel.clockOrientation
            }
        }
    }
}