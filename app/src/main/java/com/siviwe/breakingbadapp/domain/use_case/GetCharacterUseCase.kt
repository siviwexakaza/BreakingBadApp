package com.siviwe.breakingbadapp.domain.use_case

import com.siviwe.breakingbadapp.data.network.dto.toCharacterDetail
import com.siviwe.breakingbadapp.domain.model.CharacterDetail
import com.siviwe.breakingbadapp.domain.repository.BreakingBadRepository
import com.siviwe.breakingbadapp.shared.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCharacterUseCase @Inject constructor(
    private val repo: BreakingBadRepository
) {
    operator fun invoke(char_id: Int) : Flow<Resource<CharacterDetail>> = flow {
        try {
            emit(Resource.Loading<CharacterDetail>())
            val character = repo.getCharacter(char_id = char_id).toCharacterDetail()
            emit(Resource.Success<CharacterDetail>(character))
        } catch(e: HttpException) {
            emit(Resource.Error<CharacterDetail>(e.localizedMessage ?: "An error occurred, please try again."))
        } catch(e: IOException) {
            emit(Resource.Error<CharacterDetail>("Couldn't reach server. Check your internet connection."))
        }
    }
}