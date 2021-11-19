package rs.luka.cryprocurrencyapp.domain.use_cases.get_coin

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import rs.luka.cryprocurrencyapp.common.Resource
import rs.luka.cryprocurrencyapp.data.remote.dto.toCoinDetail
import rs.luka.cryprocurrencyapp.domain.models.CoinDetail
import rs.luka.cryprocurrencyapp.domain.repositories.CoinRepository
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {

    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading<CoinDetail>())
            val coin = repository.getCoinById(coinId).toCoinDetail()
            emit(Resource.Success<CoinDetail>(coin))
        } catch (e: HttpException) {
            emit(Resource.Error<CoinDetail>(e.localizedMessage ?: "An unexpected error occurred"))
            emit(Resource.Loading<CoinDetail>())
        } catch (e: IOException) {
            emit(Resource.Error<CoinDetail>("Couldn't reach server. Check your internet connection"))
        }
    }
}