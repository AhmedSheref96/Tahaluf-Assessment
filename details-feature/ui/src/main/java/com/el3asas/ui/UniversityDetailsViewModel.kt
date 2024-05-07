package com.el3asas.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.el3asas.ui.models.UniversityItem
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class UniversityDetailsViewModel @Inject constructor() : ViewModel() {
    val item = MutableLiveData<UniversityItem>()
    fun setItem(item: UniversityItem) {
        this.item.value = item
    }
}