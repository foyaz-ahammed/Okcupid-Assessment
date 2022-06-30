package com.okcupid.assessment.repository

import com.okcupid.assessment.entities.Response
import retrofit2.http.GET

/**
 * Network API fetching data
 */
interface PetAPI {
    @GET("interview/matches.json")
    suspend fun getAllPets(): Response.MatchResult
}