package com.verygreendinosaur.android.shoestore

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.activity.addCallback
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.verygreendinosaur.android.shoestore.databinding.FragmentShoesBinding
import kotlinx.android.synthetic.main.fragment_shoes.*


class ShoesFragment : Fragment() {

    val args: ShoesFragmentArgs by navArgs()

    private val model: ShoesViewModel by viewModels()
    lateinit var binding: FragmentShoesBinding

    override fun onAttach(context: Context) {
        super.onAttach(context)
        requireActivity().onBackPressedDispatcher.addCallback(this) {
            // Intercept back navigation and do nothing
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loadShoes()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoes, container, false)
        setupButtons()
        //model.shoesLiveData.value?.let { setupShoesList(it) }
        return binding.root
    }

    private fun loadShoes() {
        val shoe = args.newShoe
        if (shoe != null) {
            model.add(shoe)
        }

        val shoesObserver = Observer<List<Shoe>> { setupShoesList(it) }
        model.shoesLiveData.observe(this, shoesObserver)
    }

    private fun setupShoesList(shoes: List<Shoe>) {
        //scroll_content_layout.removeAllViews()

        shoes.forEach {
            val entry = TextView(context)
            entry.text = it.formattedForDisplay()
            scroll_content_layout.addView(entry)
        }
    }

    private fun setupButtons() {
        binding.fab.setOnClickListener { navigateToDetail(it) }
    }

    private fun navigateToDetail(v: View) {
        v.findNavController().navigate(R.id.action_shoesFragment_to_shoeDetailsFragment)
    }

}