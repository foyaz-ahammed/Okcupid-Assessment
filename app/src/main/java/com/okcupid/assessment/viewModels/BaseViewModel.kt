package com.okcupid.assessment.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.okcupid.assessment.entities.LoadResult
import com.okcupid.assessment.entities.PetItem

/**
 * ViewModel class for main page
 */
abstract class BaseViewModel: ViewModel() {

    val loading = MutableLiveData<LoadResult>()
    val petList = MutableLiveData<List<PetItem>>()

    abstract fun fetchData()

}