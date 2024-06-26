package com.el3asas.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.el3asas.ui.databinding.FragmentUniversityDetailsBinding
import com.el3asas.ui.models.UniversityItem
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UniversityDetailsFragment : Fragment() {

    private val viewModel: UniversityDetailsViewModel by viewModels()
    private val binding by lazy {
        FragmentUniversityDetailsBinding.inflate(LayoutInflater.from(requireContext()))
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val itemGson = arguments?.getString("item")
        val item = Gson().fromJson(itemGson, UniversityItem::class.java)
        if (item != null)
            viewModel.setItem(item)
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            viewModel.item.observe(viewLifecycleOwner) {
                name.text = it.name
                countryAndCode.text = it.country + "(" + it.alphaTwoCode + ")"
                it.stateProvince?.let {
                    state.text = it
                } ?: kotlin.run {
                    state.isVisible = false
                }

                it.webPages?.getOrNull(0)?.let {
                    pageLink.text = it
                } ?: kotlin.run {
                    pageLink.isVisible = false
                }
                refreshBtn.setOnClickListener {
                    setFragmentResult("result", bundleOf("result" to true))
                    findNavController().navigateUp()
                }
            }
        }
    }
}