package com.siviwe.breakingbadapp.data.network

import com.siviwe.breakingbadapp.data.network.dto.CharacterDetailDto
import com.siviwe.breakingbadapp.data.network.dto.CharacterDto
import retrofit2.http.GET

interface BreakingBadAPI {
    @GET("/characters")
    suspend fun getCharacters(): List<CharacterDto>

    @GET("/characters/{char_id}")
    suspend fun getCharacter(char_id: Int): CharacterDetailDto
}