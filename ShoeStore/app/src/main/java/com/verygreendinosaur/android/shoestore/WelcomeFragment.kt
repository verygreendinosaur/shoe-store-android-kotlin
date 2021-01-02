package com.verygreendinosaur.android.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.verygreendinosaur.android.shoestore.databinding.FragmentWelcomeBinding

class WelcomeFragment : Fragment() {

    private lateinit var binding: FragmentWelcomeBinding

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding =
                DataBindingUtil.inflate(layoutInflater, R.layout.fragment_welcome, container, false)

        setupButtons()
        return binding.root
    }

    private fun setupButtons() {
        binding.howToShopButton.setOnClickListener { navigateToInstructions(it) }
    }

    private fun navigateToInstructions(v: View) {
        v.findNavController().navigate(R.id.action_welcomeFragment_to_instructionsFragment)
    }

}