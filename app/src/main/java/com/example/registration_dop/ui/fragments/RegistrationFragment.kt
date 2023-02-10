package com.example.registration_dop.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.registration_dop.R
import com.example.registration_dop.databinding.FragmentRegistrationBinding
import com.example.registration_dop.utils.PreferenceHelper

class RegistrationFragment : Fragment() {

    private lateinit var binding: FragmentRegistrationBinding
    private val preferenceHelper = PreferenceHelper()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRegistrationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        setupListener()
    }

    private fun initialize() {
        preferenceHelper.unit(requireContext())
    }

    private fun setupListener() = with(binding) {
        btnButton.setOnClickListener {
            preferenceHelper.saveName = etEmail.text.toString()
            preferenceHelper.savePassword = etInputPassword.text.toString()


            if (etEmail.text.toString() == "") {
                etEmail.error = "Введите текст"
            } else if(etInputPassword.text.toString() == ""){
                etInputPassword.error = "Введите текст"
            } else if (etInputPassword.length() < 8) {
                etInputPassword.error = "Меньше 8 символов"
            }else if(etEmail.length() < 5) {
                etEmail.error = "Меньше 5 символов"
            } else {
                findNavController().navigate(R.id.action_registrationFragment_to_dataFragment)
            }
        }
    }
}
