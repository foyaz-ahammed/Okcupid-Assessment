package com.okcupid.assessment.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.okcupid.assessment.entities.LoadResult
import com.okcupid.assessment.entities.PetItem
import com.okcupid.assessment.repository.OkcupidRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * ViewModel class for main page
 */
abstract class BaseViewModel(protected val repository: OkcupidRepository): ViewModel() {

    val loading = MutableLiveData<LoadResult>()
    val petList = MutableLiveData<List<PetItem>>()
    var cachePetList = ArrayList<PetItem>()

    abstract fun fetchData(loadFromCache: Boolean = false)

    fun updateFavoriteItem(item: PetItem?) {
        item?.let {
            viewModelScope.launch(Dispatchers.IO) {
                repository.updateFavoriteItem(it)
            }
        }
    }

}