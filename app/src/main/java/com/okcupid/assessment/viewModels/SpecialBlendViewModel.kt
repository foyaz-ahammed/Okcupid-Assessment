package com.okcupid.assessment.viewModels

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.okcupid.assessment.entities.DataResult
import com.okcupid.assessment.entities.LoadResult
import com.okcupid.assessment.repository.OkcupidRepository
import kotlinx.coroutines.launch

class SpecialBlendViewModel(private val repository: OkcupidRepository): BaseViewModel() {

    companion object {
        private val TAG = SpecialBlendViewModel::class.java.simpleName
    }

    override fun fetchData() {
        loading.value = LoadResult.LOADING
        viewModelScope.launch {
            when(val result = repository.getPetList()) {
                is DataResult.Success -> {
                    loading.value = LoadResult.SUCCESS
                    petList.value = result.data
                }
                is DataResult.Failure -> {
                    loading.value = LoadResult.FAIL
                    Log.e(TAG, "error: " + result.exception)
                }
            }
        }
    }
}