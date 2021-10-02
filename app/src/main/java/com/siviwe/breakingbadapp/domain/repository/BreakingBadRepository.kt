package com.siviwe.breakingbadapp.domain.repository

import com.siviwe.breakingbadapp.data.network.dto.CharacterDetailDto
import com.siviwe.breakingbadapp.data.network.dto.CharacterDto

interface BreakingBadRepository {

    suspend fun getCharacters() : List<CharacterDto>
    suspend fun getCharacter(char_id : Int) : CharacterDetailDto
}