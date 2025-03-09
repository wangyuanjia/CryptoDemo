package com.rain.cryptodemo.data

data class WalletBalanceBean(
    val ok: Boolean,
    val wallet: List<Wallet>,
    val warning: String
)