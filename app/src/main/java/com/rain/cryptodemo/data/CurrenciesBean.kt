package com.rain.cryptodemo.data

data class CurrenciesBean(
    val currencies: List<Currency>,
    val ok: Boolean,
    val total: Int
)