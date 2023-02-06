package com.clock.clocks.ui.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.clock.clocks.R
import com.clock.clocks.databinding.FragmentMainBinding
import com.clock.clocks.ui.presentation.BaseFragment
import com.clock.clocks.viewmodels.CustomClockSettingsViewModel

class MainFragment :BaseFragment<FragmentMainBinding> (FragmentMainBinding::inflate){



    private val viewModel: MainViewModel by lazy {
                ViewModelProvider(requireActivity())[MainViewModel::class.java]
            }



}
