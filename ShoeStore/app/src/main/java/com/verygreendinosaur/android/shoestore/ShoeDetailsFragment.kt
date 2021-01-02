package com.verygreendinosaur.android.shoestore

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.verygreendinosaur.android.shoestore.databinding.FragmentShoeDetailsBinding

class ShoeDetailsFragment : Fragment() {

    private lateinit var binding: FragmentShoeDetailsBinding

    override fun onAttach(context: Context) {
        super.onAttach(context)
        requireActivity().onBackPressedDispatcher.addCallback(this) {
            findNavController().navigate(R.id.action_shoeDetailsFragment_to_shoesFragment)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_shoe_details, container, false)
        setupButtons()
        return binding.root
    }

    private fun setupButtons() {
        binding.cancelButton.setOnClickListener { navigateToShoesOnCancel(it) }
        binding.saveButton.setOnClickListener { navigateToShoesOnSave(it) }
    }

    private fun buildShoe(): Shoe? {
        val name = binding.nameTextView.text.toString()
        if (name.isNullOrEmpty()) {
            return null
        }

        val company = binding.companyTextView.text.toString()
        if (company.isNullOrEmpty()) {
            return null
        }

        val description = binding.descriptionTextView.text.toString()
        if (description.isNullOrEmpty()) {
            return null
        }

        val size = binding.sizeTextView.text.toString().toDoubleOrNull() ?: return null

        return Shoe(name, company, size, description)
    }

    private fun navigateToShoesOnCancel(v: View) {
        v.findNavController().navigate(R.id.action_shoeDetailsFragment_to_shoesFragment)
    }

    private fun navigateToShoesOnSave(v: View) {
        val shoe = buildShoe() ?: return
        val directions = ShoeDetailsFragmentDirections.actionShoeDetailsFragmentToShoesFragment(shoe)
        v.findNavController().navigate(directions)
    }

}
