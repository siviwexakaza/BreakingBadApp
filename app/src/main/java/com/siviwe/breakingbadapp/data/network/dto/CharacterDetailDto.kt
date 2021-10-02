package com.siviwe.breakingbadapp.data.network.dto

import com.siviwe.breakingbadapp.domain.model.CharacterDetail

data class CharacterDetailDto(
    val appearance: List<Int>,
    val better_call_saul_appearance: List<Any>,
    val birthday: String,
    val category: String,
    val char_id: Int,
    val img: String,
    val name: String,
    val nickname: String,
    val occupation: List<String>,
    val portrayed: String,
    val status: String
)

fun CharacterDto.toCharacterDetail() : CharacterDetail {
    return CharacterDetail(
        birthday, char_id, img, name, nickname, occupation, status
    )
}