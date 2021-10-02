package com.siviwe.breakingbadapp.data.repository

import com.siviwe.breakingbadapp.data.network.BreakingBadAPI
import com.siviwe.breakingbadapp.data.network.dto.CharacterDetailDto
import com.siviwe.breakingbadapp.data.network.dto.CharacterDto
import com.siviwe.breakingbadapp.domain.repository.BreakingBadRepository
import javax.inject.Inject

class BreakingBadRepositoryImpl @Inject constructor(
    private val api: BreakingBadAPI
) : BreakingBadRepository {
    override suspend fun getCharacters(): List<CharacterDto> {
        return api.getCharacters()
    }

    override suspend fun getCharacter(char_id: Int): CharacterDetailDto {
        return api.getCharacter(char_id = char_id)
    }
}