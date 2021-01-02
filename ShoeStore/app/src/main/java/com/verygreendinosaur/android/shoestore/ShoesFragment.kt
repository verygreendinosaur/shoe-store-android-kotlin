package com.verygreendinosaur.android.shoestore

import android.content.Context
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.TextView
import androidx.activity.addCallback
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.verygreendinosaur.android.shoestore.databinding.FragmentShoesBinding
import kotlinx.android.synthetic.main.fragment_shoes.*

class ShoesFragment : Fragment() {

    private val viewModel: ShoesViewModel by activityViewModels()

    lateinit var binding: FragmentShoesBinding

    val args: ShoesFragmentArgs by navArgs()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        requireActivity().onBackPressedDispatcher.addCallback(this) {
            // Intercept back navigation and do nothing
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        loadShoes()
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoes, container, false)
        setupButtons()
        return binding.root
    }

    private fun loadShoes() {
        val model = viewModel
        val shoe = args.newShoe
        val shoesObserver = Observer<List<Shoe>> { setupShoesList(it) }

        if (shoe != null) {
            model.add(shoe)
        }

        model.shoesLiveData.observe(this, shoesObserver)
    }

    private fun setupShoesList(shoes: List<Shoe>) {
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

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_main, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when (item.itemId) {
            R.id.action_logout -> logout()
            else -> super.onOptionsItemSelected(item)
        }

        return super.onOptionsItemSelected(item)
    }

    private fun logout(): Boolean {
        restartActivity()
        return true
    }

    private fun restartActivity() {
        val intent = activity?.intent
        activity?.finish()
        startActivity(intent)
    }
}