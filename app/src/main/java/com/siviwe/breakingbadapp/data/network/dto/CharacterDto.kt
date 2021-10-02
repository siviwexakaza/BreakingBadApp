package com.siviwe.breakingbadapp.data.network.dto

import com.siviwe.breakingbadapp.domain.model.Character

data class CharacterDto(
    val appearance: List<Int>,
    val better_call_saul_appearance: List<Int>,
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

fun CharacterDto.toCharacter() : Character {
    return Character(birthday, char_id, img, name)
}

