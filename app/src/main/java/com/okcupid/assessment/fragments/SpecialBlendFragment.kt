package com.okcupid.assessment.fragments

import android.os.Bundle
import android.view.View
import com.okcupid.assessment.util.cloneList
import com.okcupid.assessment.viewModels.SpecialBlendViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * Fragment for the Special Blend page (shows all pets)
 */
class SpecialBlendFragment: BaseSearchFragment() {

    override val viewModel by viewModel<SpecialBlendViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter.setItemClickListener { item ->
            val list = adapter.currentList.cloneList()
            val updatedItem = list.findLast {
                it.userId == item.userId
            }?.apply {
                liked = !liked
            }

            adapter.submitList(list)
            viewModel.updateFavoriteItem(updatedItem)
        }
    }

    override fun search(keyword: String) {
    }
}