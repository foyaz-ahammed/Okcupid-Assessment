package com.okcupid.assessment.fragments

import com.okcupid.assessment.viewModels.MatchPercentViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * Fragment for Match % page
 */
class MatchPercentFragment: BaseSearchFragment() {
    override val viewModel by viewModel<MatchPercentViewModel>()

    override fun search(keyword: String) {
        TODO("Not yet implemented")
    }
}