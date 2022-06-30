package com.okcupid.assessment.entities

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

class Response {

    @JsonClass(generateAdapter = true)
    class MatchResult(
        @Json(name = "data") val data: List<PetInfo>,
        @Json(name = "paging") val paging: Paging,
        @Json(name = "total_matches") val totalMatches: Int
    )

    @JsonClass(generateAdapter = true)
    class PetInfo(
        @Json(name = "age") val age: Int,
        @Json(name = "is_online") val isOnline: Int,
        @Json(name = "location") val location: Location,
        @Json(name = "match") val match: Int,
        @Json(name = "photo") val photo: Photo,
        @Json(name = "userid") val userId: String,
        @Json(name = "username") val userName: String
    )

    @JsonClass(generateAdapter = true)
    class Location(
        @Json(name = "city_name") val cityName: String,
        @Json(name = "country_code") val countryCode: String,
        @Json(name = "country_name") val countryName: String,
        @Json(name = "state_code") val stateCode: String,
        @Json(name = "state_name") val stateName: String
    )

    @JsonClass(generateAdapter = true)
    class Photo(
        @Json(name = "large") val large: String,
        @Json(name = "medium") val medium: String,
        @Json(name = "original") val original: String,
        @Json(name = "small") val small: String
    )

    @JsonClass(generateAdapter = true)
    class Paging(
        @Json(name = "cursors") val cursors: Cursors
    )

    @JsonClass(generateAdapter = true)
    class Cursors(
        @Json(name = "after") val after: String,
        @Json(name = "before") val before: String,
        @Json(name = "current") val current: String
    )
}
