package com.okcupid.assessment.database.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.okcupid.assessment.database.entities.PetMatch

@Dao
interface FavoriteDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item: PetMatch)

    @Query("SELECT * FROM favorite_tb WHERE is_like = 1")
    suspend fun getFavoriteItems(): List<PetMatch>
}