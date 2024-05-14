package com.el3asas.listing_ui.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.el3asas.domain.models.UniversityItem
import com.el3asas.listing_ui.actions.ListingFeatureActions
import com.el3asas.listing_ui.databinding.FragmentListUniversitiesBinding
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class ListUniversitiesFragment : Fragment(), UniversitiesAdapter.ItemClickListener {

    private val viewModel: ListUniversitiesViewModel by viewModels()

    @Inject
    lateinit var actions: ListingFeatureActions

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
        setFragmentResultListener("result") { key, bundle ->
            val isRefresh = bundle.getBoolean(key)
            if (isRefresh) viewModel.loadUniversities()
        }

        viewModel.isLoading.observe(viewLifecycleOwner) { isLoading ->
            binding.refreshLayout.isRefreshing = isLoading
            binding.recyclerView.isVisible = isLoading.not()
        }

        binding.refreshLayout.setOnRefreshListener {
            viewModel.loadUniversities()
        }

    }

    override fun onItemClicked(view: View,item: UniversityItem) {
        val data = Gson().toJson(item)
        actions.openDetails(view, data)
    }

}