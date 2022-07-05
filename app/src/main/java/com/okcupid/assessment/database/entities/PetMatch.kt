package com.okcupid.assessment.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "favorite_tb",
    indices = [Index(value = ["user_id"], unique = true)]
)
data class PetMatch (
    @PrimaryKey(autoGenerate = true) val id: Long? = null,
    @ColumnInfo(name = "user_id") val userId: String,
    @ColumnInfo(name = "is_like") val isLike: Int
)