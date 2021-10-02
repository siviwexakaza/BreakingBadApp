package com.siviwe.breakingbadapp.domain.model

data class CharacterDetail(
    val birthday: String,
    val char_id: Int,
    val img: String,
    val name: String,
    val nickname: String,
    val occupation: List<String>,
    val status: String
)
