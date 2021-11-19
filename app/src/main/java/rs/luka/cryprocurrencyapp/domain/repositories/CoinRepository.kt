package rs.luka.cryprocurrencyapp.domain.repositories

import rs.luka.cryprocurrencyapp.data.remote.dto.CoinDetailDto
import rs.luka.cryprocurrencyapp.data.remote.dto.CoinDto

interface CoinRepository {

    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinById(coinId: String): CoinDetailDto
}