package rs.luka.cryprocurrencyapp.presentation.coin_list

import rs.luka.cryprocurrencyapp.domain.models.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)
