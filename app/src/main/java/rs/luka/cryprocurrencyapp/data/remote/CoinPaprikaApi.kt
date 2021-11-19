package rs.luka.cryprocurrencyapp.data.remote

import retrofit2.http.GET
import retrofit2.http.Path
import rs.luka.cryprocurrencyapp.data.remote.dto.CoinDetailDto
import rs.luka.cryprocurrencyapp.data.remote.dto.CoinDto

interface CoinPaprikaApi {

    @GET("/v1/coins")
    suspend fun getCoins(): List<CoinDto>

    @GET("/v1/coins/{coinId}")
    suspend fun getCoinById(@Path("coinId") coinId: String): CoinDetailDto
}