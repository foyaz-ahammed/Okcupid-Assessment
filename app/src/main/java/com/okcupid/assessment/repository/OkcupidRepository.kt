package com.okcupid.assessment.repository

import com.okcupid.assessment.entities.DataResult
import com.okcupid.assessment.entities.PetItem

/**
 * Repository class
 */
class OkcupidRepository(private val api: PetAPI) {

    suspend fun getPetList(): DataResult<List<PetItem>> =
        try {
            val result = api.getAllPets()
            DataResult.Success(result.data.map (::PetItem))
        } catch (e: Exception) {
            DataResult.Failure(e)
        }
}