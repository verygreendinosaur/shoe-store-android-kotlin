package com.verygreendinosaur.android.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.verygreendinosaur.android.shoestore.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(false)

        binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_login, container, false)

        setupButtons()
        return binding.root
    }

    private fun setupButtons() {
        with(binding) {
            signInButton.setOnClickListener { navigateToWelcome(it) }
            createAccountButton.setOnClickListener { navigateToWelcome(it) }
        }
    }

    private fun navigateToWelcome(v: View) {
        v.findNavController().navigate(R.id.action_loginFragment_to_welcomeFragment)
    }

}