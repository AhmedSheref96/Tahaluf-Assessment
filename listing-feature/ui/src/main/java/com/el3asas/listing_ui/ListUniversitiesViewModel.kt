package com.el3asas.listing_ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.el3asas.domain.di.OfflineRepo
import com.el3asas.domain.di.OnlineRepo
import com.el3asas.domain.models.UniversityItem
import com.el3asas.domain.usecases.GetUniversitiesListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListUniversitiesViewModel @Inject constructor(
    @OnlineRepo private val getOnlineUniversities: GetUniversitiesListUseCase,
    @OfflineRepo private val getOfflineUniversities: GetUniversitiesListUseCase
) : ViewModel() {

    private val _universitiesList = MutableStateFlow<List<UniversityItem>>(emptyList())
    val universitiesList = _universitiesList.asStateFlow()

    init {
        viewModelScope.launch {
            _universitiesList.value = getOnlineUniversities("United Arab Emirates")
        }
    }

}