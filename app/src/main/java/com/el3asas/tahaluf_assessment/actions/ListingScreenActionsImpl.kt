package com.el3asas.tahaluf_assessment.actions

import android.view.View
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import com.el3asas.listing_ui.actions.ListingFeatureActions
import com.el3asas.tahaluf_assessment.R
import javax.inject.Inject

class ListingScreenActionsImpl @Inject constructor(): ListingFeatureActions {
    override fun openDetails(v: View, data: String) {
        Navigation.findNavController(v).navigate(R.id.detailsFragment, bundleOf("item" to data))
    }
}