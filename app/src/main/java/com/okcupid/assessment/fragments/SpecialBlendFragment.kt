package com.okcupid.assessment.fragments

import com.okcupid.assessment.viewModels.SpecialBlendViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * Fragment for the Special Blend page (shows all pets)
 */
class SpecialBlendFragment: BaseSearchFragment() {

    override val viewModel by viewModel<SpecialBlendViewModel>()

    override fun search(keyword: String) {
    }
}