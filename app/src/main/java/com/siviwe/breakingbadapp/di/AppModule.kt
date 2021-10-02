package com.siviwe.breakingbadapp.di

import com.siviwe.breakingbadapp.data.network.BreakingBadAPI
import com.siviwe.breakingbadapp.data.repository.BreakingBadRepositoryImpl
import com.siviwe.breakingbadapp.domain.repository.BreakingBadRepository
import com.siviwe.breakingbadapp.shared.constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesBreakingBadAPI() : BreakingBadAPI {
        return Retrofit.Builder()
            .baseUrl(constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(BreakingBadAPI::class.java)
    }

    @Provides
    @Singleton
    fun providesBreakingBadRepository(api : BreakingBadAPI) : BreakingBadRepository {
        return BreakingBadRepositoryImpl(api)
    }
}