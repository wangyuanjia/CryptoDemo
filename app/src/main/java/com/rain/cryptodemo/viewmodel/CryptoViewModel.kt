package com.rain.cryptodemo.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rain.cryptodemo.data.CryptoBean
import com.rain.cryptodemo.data.Currency
import com.rain.cryptodemo.data.Tier
import com.rain.cryptodemo.data.Wallet
import com.rain.cryptodemo.datacenter.CryptoDataCenter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.math.BigDecimal
import java.math.RoundingMode

sealed class UiState {
    object Loading : UiState()
    data class Success(val data: List<CryptoBean>) : UiState()
    data class Error(val message: String) : UiState()
}

class CryptoViewModel : ViewModel() {

    private val _uiState = MutableStateFlow<UiState>(UiState.Loading)
    val uiState: StateFlow<UiState> = _uiState

    private var currencyList: List<Currency>? = null
    private var tierList: List<Tier>? = null
    private var walletBalance: List<Wallet>? = null

    fun accessData() {
        viewModelScope.launch {
            _uiState.value = UiState.Loading
//            _text.value = newText

            val currencyListResult = async { CryptoDataCenter.getCurrencyList() }
            val tierResult = async { CryptoDataCenter.getTierList() }
            val walletBalanceResult = async { CryptoDataCenter.getWalletBalance() }
            currencyList = currencyListResult.await()
            tierList = tierResult.await()
            walletBalance = walletBalanceResult.await()
            if (currencyList != null && tierList != null && walletBalance != null) {
                accessCompleteData()
            } else {
                _uiState.value = UiState.Error("no data")
            }
        }
    }


    private suspend fun accessCompleteData() {
        val result = withContext(Dispatchers.Default) {
            mutableListOf<CryptoBean>().apply {
                currencyList?.forEach { element ->
                    val cryptoBean = CryptoBean()
                    val tier = tierList?.find { it.from_currency == element.symbol }
                    val walletBalance = walletBalance?.find { it.currency == element.symbol }
                    if (walletBalance != null) {
                        val money = multiplyAndRound(
                            walletBalance.amount, tier?.rates?.get(0)?.rate?.toDouble() ?: 0.0,
                            element.display_decimal
                                ?: 8,
                        )
                        cryptoBean.money = money
                        cryptoBean.amount = (walletBalance.amount).toString()
                    }
                    cryptoBean.cryptoName = element.name
                    cryptoBean.symbol = element.symbol
                    cryptoBean.imageUrl = element.colorful_image_url
                    this.add(cryptoBean)
                }
            }
        }

        _uiState.tryEmit(value = UiState.Success(data = result))
    }

    private fun multiplyAndRound(
        a: Double,
        b: Double,
        scale: Int,
        roundingMode: RoundingMode = RoundingMode.HALF_DOWN
    ): String {
        // 将输入转换为 BigDecimal
        val bigA = BigDecimal(a.toString())
        val bigB = BigDecimal(b.toString())

        // 计算乘积
        val result = bigA.multiply(bigB)

        // 设置小数位数和舍入模式
        return result.setScale(scale, roundingMode).toString()
    }

}