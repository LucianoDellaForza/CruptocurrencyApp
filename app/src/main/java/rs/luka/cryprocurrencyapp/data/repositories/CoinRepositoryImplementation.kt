package rs.luka.cryprocurrencyapp.data.repositories

import rs.luka.cryprocurrencyapp.data.remote.CoinPaprikaApi
import rs.luka.cryprocurrencyapp.data.remote.dto.CoinDetailDto
import rs.luka.cryprocurrencyapp.data.remote.dto.CoinDto
import rs.luka.cryprocurrencyapp.domain.repositories.CoinRepository
import javax.inject.Inject

class CoinRepositoryImplementation @Inject constructor(
    private val api: CoinPaprikaApi
) : CoinRepository {
    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId)
    }
}