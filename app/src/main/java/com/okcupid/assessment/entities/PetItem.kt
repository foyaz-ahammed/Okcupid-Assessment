package com.okcupid.assessment.entities

/**
 * Model class defining one pet item
 */
data class PetItem(
    var userId: String,
    var userName: String,
    var age: Int,
    var countryCode: String,
    var stateCode: String,
    var cityName: String,
    var photo: String,
    var match: Int,
    var liked: Boolean,
) {
    constructor(
        petInfo: Response.PetInfo
    ): this(
        petInfo.userId, petInfo.userName, petInfo.age,
        petInfo.location.countryCode, petInfo.location.stateCode, petInfo.location.cityName,
        petInfo.photo.medium, petInfo.match, false
    )

    constructor(other: PetItem): this(
        other.userId, other.userName, other.age, other.countryCode, other.stateCode, other.cityName, other.photo, other.match, other.liked
    )
}