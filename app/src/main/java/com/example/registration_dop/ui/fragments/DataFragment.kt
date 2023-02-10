package com.example.registration_dop.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.registration_dop.databinding.FragmentDataBinding
import com.example.registration_dop.utils.PreferenceHelper

class DataFragment : Fragment() {

    private lateinit var binding: FragmentDataBinding
    private var preferenceHelper = PreferenceHelper()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDataBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
    }

    private fun initialize() {
        preferenceHelper.unit(requireContext())
        binding.dataName.text = preferenceHelper.saveName
        binding.dataPassword.text = preferenceHelper.savePassword
    }
}