package com.okcupid.assessment.fragments

import android.os.Bundle
import android.view.View
import com.okcupid.assessment.util.cloneList
import com.okcupid.assessment.viewModels.MatchPercentViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * Fragment for Match % page
 */
class MatchPercentFragment: BaseSearchFragment() {
    override val viewModel by viewModel<MatchPercentViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter.setItemCountLimit(6)
        adapter.setItemClickListener { item ->
            val list = adapter.currentList.cloneList()
            val updatedItem = list.findLast {
                it.userId == item.userId
            }?.apply {
                liked = !liked
            }
            list.remove(updatedItem)

            adapter.submitList(list)
            viewModel.updateFavoriteItem(updatedItem)
        }
    }

    override fun search(keyword: String) {
        TODO("Not yet implemented")
    }
}