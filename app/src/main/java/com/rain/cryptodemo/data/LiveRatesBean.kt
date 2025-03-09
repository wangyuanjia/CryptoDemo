package com.rain.cryptodemo.data

data class LiveRatesBean(
    val ok: Boolean,
    val tiers: List<Tier>,
    val warning: String
)