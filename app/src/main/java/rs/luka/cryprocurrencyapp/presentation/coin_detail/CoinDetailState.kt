package rs.luka.cryprocurrencyapp.presentation.coin_detail

import rs.luka.cryprocurrencyapp.domain.models.Coin
import rs.luka.cryprocurrencyapp.domain.models.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)
