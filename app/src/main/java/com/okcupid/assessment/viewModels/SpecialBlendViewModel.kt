package com.okcupid.assessment.viewModels

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.okcupid.assessment.database.entities.PetMatch
import com.okcupid.assessment.entities.DataResult
import com.okcupid.assessment.entities.LoadResult
import com.okcupid.assessment.entities.PetItem
import com.okcupid.assessment.repository.OkcupidRepository
import com.okcupid.assessment.util.cloneList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * View model used on Special Blend page
 */
class SpecialBlendViewModel(repository: OkcupidRepository): BaseViewModel(repository) {

    companion object {
        private val TAG = SpecialBlendViewModel::class.java.simpleName
    }

    override fun fetchData(loadFromCache: Boolean) {
        if (!loadFromCache) loading.value = LoadResult.LOADING

        viewModelScope.launch(Dispatchers.IO) {
            val favoriteItems = repository.getFavoriteItems()

            withContext(Dispatchers.Main) {
                if (loadFromCache) {
                    petList.value = updateLikedStatus(cachePetList, favoriteItems)
                } else {
                    when (val result = repository.getPetList()) {
                        is DataResult.Success -> {
                            loading.value = LoadResult.SUCCESS
                            cachePetList = result.data.cloneList()
                            petList.value = updateLikedStatus(result.data, favoriteItems)
                        }
                        is DataResult.Failure -> {
                            loading.value = LoadResult.FAIL
                            Log.e(TAG, "error: " + result.exception)
                        }
                    }
                }
            }
        }
    }

    private fun updateLikedStatus(list: List<PetItem>, favItems: List<PetMatch>): List<PetItem> {
        val clonedList = list.cloneList()
        clonedList.forEach { item ->
            item.liked = favItems.find { it.userId == item.userId } != null
        }

        return clonedList.sortedByDescending { it.match }
    }

}