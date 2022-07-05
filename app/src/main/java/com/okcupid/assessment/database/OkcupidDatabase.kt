package com.okcupid.assessment.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.okcupid.assessment.database.daos.FavoriteDao
import com.okcupid.assessment.database.entities.PetMatch

/**
 * Database class
 */
@Database(entities = [PetMatch::class], version = 1, exportSchema = false)
abstract class OkcupidDatabase: RoomDatabase() {
    abstract fun favoriteDao(): FavoriteDao
}