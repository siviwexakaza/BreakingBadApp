package com.siviwe.breakingbadapp.domain.use_case

import com.siviwe.breakingbadapp.data.network.dto.toCharacter
import com.siviwe.breakingbadapp.domain.model.Character
import com.siviwe.breakingbadapp.domain.repository.BreakingBadRepository
import com.siviwe.breakingbadapp.shared.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCharactersUseCase @Inject constructor(
    private val repo: BreakingBadRepository
) {
    operator fun invoke() : Flow<Resource<List<Character>>> = flow {
        try {
            emit(Resource.Loading<List<Character>>())
            val characters = repo.getCharacters().map { it.toCharacter() }
            emit(Resource.Success<List<Character>>(characters))
        } catch(e: HttpException) {
            emit(Resource.Error<List<Character>>(e.localizedMessage ?: "An error occurred, please try again."))
        } catch(e: IOException) {
            emit(Resource.Error<List<Character>>("Couldn't reach server. Check your internet connection."))
        }
    }
}