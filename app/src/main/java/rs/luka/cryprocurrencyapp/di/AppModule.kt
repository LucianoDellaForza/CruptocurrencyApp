package rs.luka.cryprocurrencyapp.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import rs.luka.cryprocurrencyapp.common.Constants
import rs.luka.cryprocurrencyapp.data.remote.CoinPaprikaApi
import rs.luka.cryprocurrencyapp.data.repositories.CoinRepositoryImplementation
import rs.luka.cryprocurrencyapp.domain.repositories.CoinRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providePaprikaApi(): CoinPaprikaApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinPaprikaApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCoinRepository(api: CoinPaprikaApi): CoinRepository {
        return CoinRepositoryImplementation(api)
    }
}