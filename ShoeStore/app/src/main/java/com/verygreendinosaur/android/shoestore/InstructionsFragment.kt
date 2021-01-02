package com.verygreendinosaur.android.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.verygreendinosaur.android.shoestore.databinding.FragmentInstructionsBinding

class InstructionsFragment : Fragment() {

    private lateinit var binding: FragmentInstructionsBinding

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(false)

        binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_instructions, container, false)

        setupText()
        setupButtons()

        return binding.root
    }

    private fun setupText() {
        binding.instructionsOne = getString(R.string.instructions_first)
        binding.instructionsOneNumber = getString(R.string.instructions_first_symbol)

        binding.instructionsTwo = getString(R.string.instructions_second)
        binding.instructionsTwoNumber = getString(R.string.instructions_second_symbol)

        binding.instructionsThree = getString(R.string.instructions_third)
        binding.instructionsThreeNumber = getString(R.string.instructions_third_symbol)
    }

    private fun setupButtons() {
        binding.startButton.setOnClickListener { navigateToInstructions(it) }
    }

    private fun navigateToInstructions(v: View) {
        v.findNavController().navigate(R.id.action_instructionsFragment_to_shoesFragment)
    }

}