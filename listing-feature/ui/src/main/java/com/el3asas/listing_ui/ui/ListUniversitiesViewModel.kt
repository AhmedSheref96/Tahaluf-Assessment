package com.el3asas.listing_ui.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.el3asas.domain.models.UniversityItem
import com.el3asas.domain.usecases.GetUniversitiesListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListUniversitiesViewModel @Inject constructor(
    private val getUniversities: GetUniversitiesListUseCase
) : ViewModel() {

    private val _universitiesList = MutableStateFlow<List<UniversityItem>>(emptyList())
    val universitiesList = _universitiesList.asStateFlow()
    val isLoading = MutableLiveData(false)

    init {
        loadUniversities()
    }

    fun loadUniversities() {
        viewModelScope.launch {
            isLoading.value = true
            _universitiesList.value = getUniversities("United Arab Emirates")
            isLoading.value = false
        }
    }

}