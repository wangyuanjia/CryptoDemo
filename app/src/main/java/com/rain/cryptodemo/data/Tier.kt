package com.rain.cryptodemo.data

data class Tier(
    val from_currency: String,
    val rates: List<Rate>,
    val time_stamp: Int,
    val to_currency: String
)