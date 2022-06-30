package com.okcupid.assessment.entities

/**
 * Model class defining one pet item
 */
data class PetItem(
    val userid: String,
    val username: String,
    val age: Int,
    val countryCode: String,
    val stateCode: String,
    val cityName: String,
    val photo: String,
    val match: Int,
    val liked: Boolean,
) {
    constructor(
        petInfo: Response.PetInfo
    ): this(
        petInfo.userId, petInfo.userName, petInfo.age,
        petInfo.location.countryCode, petInfo.location.stateCode, petInfo.location.cityName,
        petInfo.photo.medium, petInfo.match, false
    )
}