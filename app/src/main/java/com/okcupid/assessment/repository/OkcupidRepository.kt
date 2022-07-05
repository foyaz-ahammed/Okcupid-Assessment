package com.okcupid.assessment.repository

import com.okcupid.assessment.database.daos.FavoriteDao
import com.okcupid.assessment.database.entities.PetMatch
import com.okcupid.assessment.entities.DataResult
import com.okcupid.assessment.entities.PetItem

/**
 * Repository class
 */
class OkcupidRepository(private val api: PetAPI, private val favoriteDao: FavoriteDao) {

    suspend fun getPetList(): DataResult<List<PetItem>> =
        try {
            val result = api.getAllPets()
            DataResult.Success(result.data.map (::PetItem))
        } catch (e: Exception) {
            DataResult.Failure(e)
        }

    suspend fun updateFavoriteItem(item: PetItem) {
        favoriteDao.insert(PetMatch(null, item.userId, if (item.liked) 1 else 0))
    }

    suspend fun getFavoriteItems(): List<PetMatch> = favoriteDao.getFavoriteItems()
}