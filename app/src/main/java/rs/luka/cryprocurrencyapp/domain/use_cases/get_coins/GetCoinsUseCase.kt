package rs.luka.cryprocurrencyapp.domain.use_cases.get_coins

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import rs.luka.cryprocurrencyapp.common.Resource
import rs.luka.cryprocurrencyapp.data.remote.dto.toCoin
import rs.luka.cryprocurrencyapp.domain.models.Coin
import rs.luka.cryprocurrencyapp.domain.repositories.CoinRepository
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
) {

    //override invoke, so class can be called as function
    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading<List<Coin>>())
            val coins = repository.getCoins().map { it.toCoin() }
            emit(Resource.Success<List<Coin>>(coins))
        } catch (e: HttpException) {
            emit(Resource.Error<List<Coin>>(e.localizedMessage ?: "An unexpected error occurred"))
            emit(Resource.Loading<List<Coin>>())
        } catch (e: IOException) {
            emit(Resource.Error<List<Coin>>("Couldn't reach server. Check your internet connection"))
        }
    }
}