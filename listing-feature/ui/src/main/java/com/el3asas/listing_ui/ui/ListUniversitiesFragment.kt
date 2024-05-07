package com.el3asas.listing_ui.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.el3asas.domain.models.UniversityItem
import com.el3asas.listing_ui.R
import com.el3asas.listing_ui.databinding.FragmentListUniversitiesBinding
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ListUniversitiesFragment : Fragment(), UniversitiesAdapter.ItemClickListener {

    private val viewModel: ListUniversitiesViewModel by viewModels()

    private val binding by lazy {
        FragmentListUniversitiesBinding.inflate(LayoutInflater.from(requireContext()))
    }

    private val universitiesAdapter by lazy {
        UniversitiesAdapter(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerView.adapter = universitiesAdapter

        lifecycleScope.launch {
            viewModel.universitiesList.collectLatest {
                universitiesAdapter.dataList = it
            }
        }
    }

    override fun onItemClicked(item: UniversityItem) {
//        requireActivity().startActivity(Intent(requireContext(), MainActivity::class.java).apply {
//            this.putExtra("item", bundleOf("item" to Gson().toJson(item)))
//        })

        val data = Gson().toJson(item)
        findNavController().navigate(R.id.detailsFragment, bundleOf("item" to data))
    }

}