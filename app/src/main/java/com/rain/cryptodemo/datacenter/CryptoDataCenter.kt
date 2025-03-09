package com.rain.cryptodemo.datacenter

import com.google.gson.Gson
import com.rain.cryptodemo.data.CurrenciesBean
import com.rain.cryptodemo.data.Currency
import com.rain.cryptodemo.data.LiveRatesBean
import com.rain.cryptodemo.data.Tier
import com.rain.cryptodemo.data.Wallet
import com.rain.cryptodemo.data.WalletBalanceBean

object CryptoDataCenter {
    val gson = Gson()

    suspend fun getCurrencyList(): List<Currency>? {
        val jsonString = """
       {
    "currencies": [
        {
            "coin_id": "BTC",
            "name": "Bitcoin",
            "symbol": "BTC",
            "token_decimal": 8,
            "contract_address": "",
            "withdrawal_eta": [
                "30 secs",
                "2 mins",
                "30 mins"
            ],
            "colorful_image_url": "https://s3-ap-southeast-1.amazonaws.com/monaco-cointrack-production/uploads/coin/colorful_logo/5c1246f55568a400e48ac233/bitcoin.png",
            "gray_image_url": "https://s3-ap-southeast-1.amazonaws.com/monaco-cointrack-production/uploads/coin/gray_logo/5c1246f55568a400e48ac233/bitcoin1.png",
            "has_deposit_address_tag": false,
            "min_balance": 0,
            "blockchain_symbol": "BTC",
            "trading_symbol": "BTC",
            "code": "BTC",
            "explorer": "https://blockchair.com/bitcoin/transaction/",
            "is_erc20": false,
            "gas_limit": 0,
            "token_decimal_value": "10000000",
            "display_decimal": 8,
            "supports_legacy_address": false,
            "deposit_address_tag_name": "",
            "deposit_address_tag_type": "",
            "num_confirmation_required": 1
        }, {
            "coin_id": "ETH",
            "name": "Ethereum",
            "symbol": "ETH",
            "token_decimal": 18,
            "contract_address": "",
            "withdrawal_eta": [
                "30 secs",
                "2 mins",
                "30 mins"
            ],
            "colorful_image_url": "https://s3-ap-southeast-1.amazonaws.com/monaco-cointrack-production/uploads/coin/colorful_logo/5c12487d5568a4017c20a993/ethereum.png",
            "gray_image_url": "https://s3-ap-southeast-1.amazonaws.com/monaco-cointrack-production/uploads/coin/gray_logo/5c12487d5568a4017c20a993/ethereum.png",
            "has_deposit_address_tag": false,
            "min_balance": 0,
            "blockchain_symbol": "ETH",
            "trading_symbol": "ETH",
            "code": "ETH",
            "explorer": "https://etherscan.io/tx/",
            "is_erc20": false,
            "gas_limit": 21000,
            "token_decimal_value": "100000000000000000",
            "display_decimal": 8,
            "supports_legacy_address": false,
            "deposit_address_tag_name": "",
            "deposit_address_tag_type": "",
            "num_confirmation_required": 1
        }, {
            "coin_id": "CRO",
            "name": "Crypto.com Coin",
            "symbol": "CRO",
            "token_decimal": 8,
            "contract_address": "0xa0b73e1ff0b80914ab6fe0444e65848c4c34450b",
            "withdrawal_eta": [
                "30 secs",
                "2 mins",
                "30 mins"
            ],
            "colorful_image_url": "https://s3-ap-southeast-1.amazonaws.com/monaco-cointrack-production/uploads/coin/colorful_logo/5c1248c15568a4017c20aa87/cro.png",
            "gray_image_url": "https://s3-ap-southeast-1.amazonaws.com/monaco-cointrack-production/uploads/coin/gray_logo/5c1248c15568a4017c20aa87/cro.png",
            "has_deposit_address_tag": false,
            "min_balance": 0,
            "blockchain_symbol": "CRO",
            "trading_symbol": "CRO",
            "code": "CRO",
            "explorer": "https://etherscan.io/tx/",
            "is_erc20": true,
            "gas_limit": 200000,
            "token_decimal_value": "10000000",
            "display_decimal": 8,
            "supports_legacy_address": false,
            "deposit_address_tag_name": "",
            "deposit_address_tag_type": "",
            "num_confirmation_required": 1
        }, {
            "coin_id": "USDT",
            "name": "Tether",
            "symbol": "USDT",
            "token_decimal": 6,
            "contract_address": "0xdac17f958d2ee523a2206206994597c13d831ec7",
            "withdrawal_eta": [
                "30 secs",
                "2 mins",
                "30 mins"
            ],
            "colorful_image_url": "https://s3-ap-southeast-1.amazonaws.com/monaco-cointrack-production/uploads/coin/colorful_logo/5c12487f5568a4017c20a999/tether.png",
            "gray_image_url": "https://s3-ap-southeast-1.amazonaws.com/monaco-cointrack-production/uploads/coin/gray_logo/5c12487f5568a4017c20a999/tether.png",
            "has_deposit_address_tag": false,
            "min_balance": 0,
            "blockchain_symbol": "USDT",
            "trading_symbol": "USDT",
            "code": "USDT",
            "explorer": "https://etherscan.io/tx/",
            "is_erc20": true,
            "gas_limit": 200000,
            "token_decimal_value": "100000",
            "display_decimal": 8,
            "supports_legacy_address": false,
            "deposit_address_tag_name": "",
            "deposit_address_tag_type": "",
            "num_confirmation_required": 1
        }, {
            "coin_id": "DAI",
            "name": "dai03",
            "symbol": "DAI",
            "token_decimal": 18,
            "contract_address": "0x6b175474e89094c44da98b954eedeac495271d0f",
            "withdrawal_eta": [
                "30 secs",
                "2 mins",
                "30 mins"
            ],
            "colorful_image_url": "https://s3-ap-southeast-1.amazonaws.com/monaco-cointrack-production/uploads/coin/colorful_logo/5e01c4cd49cde700adb27b0d/4943__1_.png",
            "gray_image_url": "https://s3-ap-southeast-1.amazonaws.com/monaco-cointrack-production/uploads/coin/gray_logo/5e01c4cd49cde700adb27b0d/DAIxxxhdpi.png",
            "has_deposit_address_tag": false,
            "min_balance": 0,
            "blockchain_symbol": "DAI",
            "trading_symbol": "DAI",
            "code": "DAI",
            "explorer": "https://etherscan.io/tx/",
            "is_erc20": true,
            "gas_limit": 200000,
            "token_decimal_value": "100000000000000000",
            "display_decimal": 8,
            "supports_legacy_address": false,
            "deposit_address_tag_name": "",
            "deposit_address_tag_type": "",
            "num_confirmation_required": 1
        }
    ],
    "total": 5,
    "ok": true
}
    """.trimIndent()
        val currenciesBean = gson.fromJson(jsonString, CurrenciesBean::class.java)
        return currenciesBean.currencies
    }


    suspend fun getTierList(): List<Tier>? {
        val jsonString = """
            {
                "ok": true,
                "warning": "",
                "tiers": [
                    {
                        "from_currency": "USDT",
                        "to_currency": "USD",
                        "rates": [
                            {
                                "amount": "1000",
                                "rate": "1.000727"
                            }
                        ],
                        "time_stamp": 1602080062
                    },
                    {
                        "from_currency": "XRP",
                        "to_currency": "USD",
                        "rates": [
                            {
                                "amount": "1000",
                                "rate": "0.248040"
                            }
                        ],
                        "time_stamp": 1602080062
                    },
                    {
                        "from_currency": "KAVA",
                        "to_currency": "USD",
                        "rates": [
                            {
                                "amount": "1000",
                                "rate": "1.798794"
                            }
                        ],
                        "time_stamp": 1602080062
                    },
                    {
                        "from_currency": "MCO",
                        "to_currency": "USD",
                        "rates": [
                            {
                                "amount": "1000",
                                "rate": "4.042767"
                            }
                        ],
                        "time_stamp": 1602080062
                    },
                    {
                        "from_currency": "CRV",
                        "to_currency": "USD",
                        "rates": [
                            {
                                "amount": "1000",
                                "rate": "0.469000"
                            }
                        ],
                        "time_stamp": 1602080062
                    },
                    {
                        "from_currency": "FET",
                        "to_currency": "USD",
                        "rates": [
                            {
                                "amount": "1000",
                                "rate": "0.045014"
                            }
                        ],
                        "time_stamp": 1602080062
                    },
                    {
                        "from_currency": "STAKE",
                        "to_currency": "USD",
                        "rates": [
                            {
                                "amount": "1000",
                                "rate": "11.117285"
                            }
                        ],
                        "time_stamp": 1602080062
                    },
                    {
                        "from_currency": "OGN",
                        "to_currency": "USD",
                        "rates": [
                            {
                                "amount": "1000",
                                "rate": "0.167389"
                            }
                        ],
                        "time_stamp": 1602080062
                    },
                    {
                        "from_currency": "NEST",
                        "to_currency": "USD",
                        "rates": [
                            {
                                "amount": "1000",
                                "rate": "0.053808"
                            }
                        ],
                        "time_stamp": 1602080062
                    },
                    {
                        "from_currency": "CRO",
                        "to_currency": "USD",
                        "rates": [
                            {
                                "amount": "1000",
                                "rate": "0.147268"
                            }
                        ],
                        "time_stamp": 1602080062
                    },
                    {
                        "from_currency": "WBTC",
                        "to_currency": "USD",
                        "rates": [
                            {
                                "amount": "1000",
                                "rate": "10617.593951"
                            }
                        ],
                        "time_stamp": 1602080062
                    },
                    {
                        "from_currency": "WTC",
                        "to_currency": "USD",
                        "rates": [
                            {
                                "amount": "1000",
                                "rate": "0.314277"
                            }
                        ],
                        "time_stamp": 1602080062
                    },
                    {
                        "from_currency": "BZRX",
                        "to_currency": "USD",
                        "rates": [
                            {
                                "amount": "1000",
                                "rate": "0.109681"
                            }
                        ],
                        "time_stamp": 1602080062
                    },
                    {
                        "from_currency": "USDC",
                        "to_currency": "USD",
                        "rates": [
                            {
                                "amount": "1000",
                                "rate": "1.000000"
                            }
                        ],
                        "time_stamp": 1602080062
                    },
                    {
                        "from_currency": "AKRO",
                        "to_currency": "USD",
                        "rates": [
                            {
                                "amount": "1000",
                                "rate": "0.008688"
                            }
                        ],
                        "time_stamp": 1602080062
                    },
                    {
                        "from_currency": "MFT",
                        "to_currency": "USD",
                        "rates": [
                            {
                                "amount": "1000",
                                "rate": "0.001425"
                            }
                        ],
                        "time_stamp": 1602080062
                    },
                    {
                        "from_currency": "ETH",
                        "to_currency": "USD",
                        "rates": [
                            {
                                "amount": "1000",
                                "rate": "340.210000"
                            }
                        ],
                        "time_stamp": 1602080062
                    },
                    {
                        "from_currency": "SWRV",
                        "to_currency": "USD",
                        "rates": [
                            {
                                "amount": "1000",
                                "rate": "0.638286"
                            }
                        ],
                        "time_stamp": 1602080062
                    },
                    {
                        "from_currency": "CREAM",
                        "to_currency": "USD",
                        "rates": [
                            {
                                "amount": "1000",
                                "rate": "32.759383"
                            }
                        ],
                        "time_stamp": 1602080062
                    },
                    {
                        "from_currency": "FARM",
                        "to_currency": "USD",
                        "rates": [
                            {
                                "amount": "1000",
                                "rate": "86.571785"
                            }
                        ],
                        "time_stamp": 1602080062
                    },
                    {
                        "from_currency": "DAI",
                        "to_currency": "USD",
                        "rates": [
                            {
                                "amount": "1000",
                                "rate": "1.010000"
                            }
                        ],
                        "time_stamp": 1602080062
                    },
                    {
                        "from_currency": "YFI",
                        "to_currency": "USD",
                        "rates": [
                            {
                                "amount": "1000",
                                "rate": "14827.250000"
                            }
                        ],
                        "time_stamp": 1602080062
                    },
                    {
                        "from_currency": "VET",
                        "to_currency": "USD",
                        "rates": [
                            {
                                "amount": "1000",
                                "rate": "0.010466"
                            }
                        ],
                        "time_stamp": 1602080062
                    },
                    {
                        "from_currency": "UMA",
                        "to_currency": "USD",
                        "rates": [
                            {
                                "amount": "1000",
                                "rate": "5.963166"
                            }
                        ],
                        "time_stamp": 1602080062
                    },
                    {
                        "from_currency": "LTC",
                        "to_currency": "USD",
                        "rates": [
                            {
                                "amount": "1000",
                                "rate": "45.960000"
                            }
                        ],
                        "time_stamp": 1602080062
                    },
                    {
                        "from_currency": "SNX",
                        "to_currency": "USD",
                        "rates": [
                            {
                                "amount": "1000",
                                "rate": "3.744409"
                            }
                        ],
                        "time_stamp": 1602080062
                    },
                    {
                        "from_currency": "LEND",
                        "to_currency": "USD",
                        "rates": [
                            {
                                "amount": "1000",
                                "rate": "0.427610"
                            }
                        ],
                        "time_stamp": 1602080062
                    },
                    {
                        "from_currency": "HOT",
                        "to_currency": "USD",
                        "rates": [
                            {
                                "amount": "1000",
                                "rate": "0.005489"
                            }
                        ],
                        "time_stamp": 1602080062
                    },
                    {
                        "from_currency": "LINK",
                        "to_currency": "USD",
                        "rates": [
                            {
                                "amount": "1000",
                                "rate": "8.791177"
                            }
                        ],
                        "time_stamp": 1602080062
                    },
                    {
                        "from_currency": "MKR",
                        "to_currency": "USD",
                        "rates": [
                            {
                                "amount": "1000",
                                "rate": "512.101149"
                            }
                        ],
                        "time_stamp": 1602080062
                    },
                    {
                        "from_currency": "OMG",
                        "to_currency": "USD",
                        "rates": [
                            {
                                "amount": "1000",
                                "rate": "3.312100"
                            }
                        ],
                        "time_stamp": 1602080062
                    },
                    {
                        "from_currency": "BAT",
                        "to_currency": "USD",
                        "rates": [
                            {
                                "amount": "1000",
                                "rate": "0.211982"
                            }
                        ],
                        "time_stamp": 1602080062
                    },
                    {
                        "from_currency": "UNI",
                        "to_currency": "USD",
                        "rates": [
                            {
                                "amount": "1000",
                                "rate": "2.681700"
                            }
                        ],
                        "time_stamp": 1602080062
                    },
                    {
                        "from_currency": "ZRX",
                        "to_currency": "USD",
                        "rates": [
                            {
                                "amount": "1000",
                                "rate": "0.348786"
                            }
                        ],
                        "time_stamp": 1602080062
                    },
                    {
                        "from_currency": "LRC",
                        "to_currency": "USD",
                        "rates": [
                            {
                                "amount": "1000",
                                "rate": "0.161633"
                            }
                        ],
                        "time_stamp": 1602080062
                    },
                    {
                        "from_currency": "PAX",
                        "to_currency": "USD",
                        "rates": [
                            {
                                "amount": "1000",
                                "rate": "0.999800"
                            }
                        ],
                        "time_stamp": 1602080062
                    },
                    {
                        "from_currency": "ICX",
                        "to_currency": "USD",
                        "rates": [
                            {
                                "amount": "1000",
                                "rate": "0.357300"
                            }
                        ],
                        "time_stamp": 1602080062
                    },
                    {
                        "from_currency": "NXM",
                        "to_currency": "USD",
                        "rates": [
                            {
                                "amount": "1000",
                                "rate": "28.393744"
                            }
                        ],
                        "time_stamp": 1602080062
                    },
                    {
                        "from_currency": "REN",
                        "to_currency": "USD",
                        "rates": [
                            {
                                "amount": "1000",
                                "rate": "0.221510"
                            }
                        ],
                        "time_stamp": 1602080062
                    },
                    {
                        "from_currency": "KNC",
                        "to_currency": "USD",
                        "rates": [
                            {
                                "amount": "1000",
                                "rate": "0.900151"
                            }
                        ],
                        "time_stamp": 1602080062
                    },
                    {
                        "from_currency": "SUSHI",
                        "to_currency": "USD",
                        "rates": [
                            {
                                "amount": "1000",
                                "rate": "0.603000"
                            }
                        ],
                        "time_stamp": 1602080062
                    },
                    {
                        "from_currency": "REP",
                        "to_currency": "USD",
                        "rates": [
                            {
                                "amount": "1000",
                                "rate": "13.392690"
                            }
                        ],
                        "time_stamp": 1602080062
                    },
                    {
                        "from_currency": "ENJ",
                        "to_currency": "USD",
                        "rates": [
                            {
                                "amount": "1000",
                                "rate": "0.144393"
                            }
                        ],
                        "time_stamp": 1602080062
                    },
                    {
                        "from_currency": "MANA",
                        "to_currency": "USD",
                        "rates": [
                            {
                                "amount": "1000",
                                "rate": "0.070058"
                            }
                        ],
                        "time_stamp": 1602080062
                    },
                    {
                        "from_currency": "BAND",
                        "to_currency": "USD",
                        "rates": [
                            {
                                "amount": "1000",
                                "rate": "5.310000"
                            }
                        ],
                        "time_stamp": 1602080062
                    },
                    {
                        "from_currency": "YFII",
                        "to_currency": "USD",
                        "rates": [
                            {
                                "amount": "1000",
                                "rate": "1309.700000"
                            }
                        ],
                        "time_stamp": 1602080062
                    },
                    {
                        "from_currency": "ANT",
                        "to_currency": "USD",
                        "rates": [
                            {
                                "amount": "1000",
                                "rate": "3.360436"
                            }
                        ],
                        "time_stamp": 1602080062
                    },
                    {
                        "from_currency": "BAL",
                        "to_currency": "USD",
                        "rates": [
                            {
                                "amount": "1000",
                                "rate": "13.589796"
                            }
                        ],
                        "time_stamp": 1602080062
                    },
                    {
                        "from_currency": "GNT",
                        "to_currency": "USD",
                        "rates": [
                            {
                                "amount": "1000",
                                "rate": "0.087835"
                            }
                        ],
                        "time_stamp": 1602080062
                    },
                    {
                        "from_currency": "NMR",
                        "to_currency": "USD",
                        "rates": [
                            {
                                "amount": "1000",
                                "rate": "26.992547"
                            }
                        ],
                        "time_stamp": 1602080062
                    },
                    {
                        "from_currency": "AMPL",
                        "to_currency": "USD",
                        "rates": [
                            {
                                "amount": "1000",
                                "rate": "0.731733"
                            }
                        ],
                        "time_stamp": 1602080062
                    },
                    {
                        "from_currency": "PAXG",
                        "to_currency": "USD",
                        "rates": [
                            {
                                "amount": "1000",
                                "rate": "1890.629886"
                            }
                        ],
                        "time_stamp": 1602080062
                    },
                    {
                        "from_currency": "BTC",
                        "to_currency": "USD",
                        "rates": [
                            {
                                "amount": "1000",
                                "rate": "10603.900000"
                            }
                        ],
                        "time_stamp": 1602080062
                    },
                    {
                        "from_currency": "XLM",
                        "to_currency": "USD",
                        "rates": [
                            {
                                "amount": "1000",
                                "rate": "0.072200"
                            }
                        ],
                        "time_stamp": 1602080062
                    },
                    {
                        "from_currency": "CELR",
                        "to_currency": "USD",
                        "rates": [
                            {
                                "amount": "1000",
                                "rate": "0.003938"
                            }
                        ],
                        "time_stamp": 1602080062
                    },
                    {
                        "from_currency": "BNT",
                        "to_currency": "USD",
                        "rates": [
                            {
                                "amount": "1000",
                                "rate": "1.061685"
                            }
                        ],
                        "time_stamp": 1602080062
                    },
                    {
                        "from_currency": "MLN",
                        "to_currency": "USD",
                        "rates": [
                            {
                                "amount": "1000",
                                "rate": "22.062318"
                            }
                        ],
                        "time_stamp": 1602080062
                    },
                    {
                        "from_currency": "ELF",
                        "to_currency": "USD",
                        "rates": [
                            {
                                "amount": "1000",
                                "rate": "0.087741"
                            }
                        ],
                        "time_stamp": 1602080062
                    },
                    {
                        "from_currency": "GNO",
                        "to_currency": "USD",
                        "rates": [
                            {
                                "amount": "1000",
                                "rate": "40.587993"
                            }
                        ],
                        "time_stamp": 1602080062
                    },
                    {
                        "from_currency": "MTA",
                        "to_currency": "USD",
                        "rates": [
                            {
                                "amount": "1000",
                                "rate": "2.569178"
                            }
                        ],
                        "time_stamp": 1602080062
                    },
                    {
                        "from_currency": "MATIC",
                        "to_currency": "USD",
                        "rates": [
                            {
                                "amount": "1000",
                                "rate": "0.017318"
                            }
                        ],
                        "time_stamp": 1602080062
                    },
                    {
                        "from_currency": "SRM",
                        "to_currency": "USD",
                        "rates": [
                            {
                                "amount": "1000",
                                "rate": "1.217500"
                            }
                        ],
                        "time_stamp": 1602080062
                    },
                    {
                        "from_currency": "TUSD",
                        "to_currency": "USD",
                        "rates": [
                            {
                                "amount": "1000",
                                "rate": "1.000209"
                            }
                        ],
                        "time_stamp": 1602080062
                    },
                    {
                        "from_currency": "COMP",
                        "to_currency": "USD",
                        "rates": [
                            {
                                "amount": "1000",
                                "rate": "0.000035"
                            }
                        ],
                        "time_stamp": 1602080062
                    },
                    {
                        "from_currency": "CDAI",
                        "to_currency": "USD",
                        "rates": [
                            {
                                "amount": "1000",
                                "rate": "0.021023"
                            }
                        ],
                        "time_stamp": 1602080062
                    },
                    {
                        "from_currency": "CSAI",
                        "to_currency": "USD",
                        "rates": [
                            {
                                "amount": "1000",
                                "rate": "0.027577"
                            }
                        ],
                        "time_stamp": 1602080062
                    },
                    {
                        "from_currency": "CUSDC",
                        "to_currency": "USD",
                        "rates": [
                            {
                                "amount": "1000",
                                "rate": "0.021202"
                            }
                        ],
                        "time_stamp": 1602080062
                    },
                    {
                        "from_currency": "CETH",
                        "to_currency": "USD",
                        "rates": [
                            {
                                "amount": "1000",
                                "rate": "6.832199"
                            }
                        ],
                        "time_stamp": 1602080062
                    },
                    {
                        "from_currency": "sBTC",
                        "to_currency": "USD",
                        "rates": [
                            {
                                "amount": "1000",
                                "rate": "0.002634"
                            }
                        ],
                        "time_stamp": 1602080062
                    },
                    {
                        "from_currency": "CUSDT",
                        "to_currency": "USD",
                        "rates": [
                            {
                                "amount": "1000",
                                "rate": "0.020290"
                            }
                        ],
                        "time_stamp": 1602080062
                    },
                    {
                        "from_currency": "CBAT",
                        "to_currency": "USD",
                        "rates": [
                            {
                                "amount": "1000",
                                "rate": "0.004339"
                            }
                        ],
                        "time_stamp": 1602080062
                    },
                    {
                        "from_currency": "CZRX",
                        "to_currency": "USD",
                        "rates": [
                            {
                                "amount": "1000",
                                "rate": "0.007066"
                            }
                        ],
                        "time_stamp": 1602080062
                    },
                    {
                        "from_currency": "CWBTC",
                        "to_currency": "USD",
                        "rates": [
                            {
                                "amount": "1000",
                                "rate": "214.370020"
                            }
                        ],
                        "time_stamp": 1602080062
                    },
                    {
                        "from_currency": "CREP",
                        "to_currency": "USD",
                        "rates": [
                            {
                                "amount": "1000",
                                "rate": "0.268397"
                            }
                        ],
                        "time_stamp": 1602080062
                    },
                    {
                        "from_currency": "ERD",
                        "to_currency": "USD",
                        "rates": [
                            {
                                "amount": "2000000.0000000000",
                                "rate": "0.0131608050"
                            },
                            {
                                "amount": "20000000.0000000000",
                                "rate": "0.0138095280"
                            },
                            {
                                "amount": "40000000.0000000000",
                                "rate": "0.0143656340"
                            },
                            {
                                "amount": "500000.0000000000",
                                "rate": "0.0131608050"
                            },
                            {
                                "amount": "5000000.0000000000",
                                "rate": "0.0132534220"
                            },
                            {
                                "amount": "100000.0000000000",
                                "rate": "0.0131608050"
                            },
                            {
                                "amount": "10000000.0000000000",
                                "rate": "0.0134388580"
                            },
                            {
                                "amount": "20000.0000000000",
                                "rate": "0.0131608050"
                            }
                        ],
                        "time_stamp": 1602080062
                    },
                    {
                        "from_currency": "AUD",
                        "to_currency": "USD",
                        "rates": [
                            {
                                "amount": "50000.0000000000",
                                "rate": "0.7248500000"
                            },
                            {
                                "amount": "80000.0000000000",
                                "rate": "0.7248500000"
                            },
                            {
                                "amount": "1.0000000000",
                                "rate": "0.7248500000"
                            },
                            {
                                "amount": "100.0000000000",
                                "rate": "0.7248500000"
                            },
                            {
                                "amount": "10000.0000000000",
                                "rate": "0.7248500000"
                            },
                            {
                                "amount": "2000.0000000000",
                                "rate": "0.7248500000"
                            },
                            {
                                "amount": "20000.0000000000",
                                "rate": "0.7248500000"
                            },
                            {
                                "amount": "5000.0000000000",
                                "rate": "0.7248500000"
                            }
                        ],
                        "time_stamp": 1602080062
                    },
                    {
                        "from_currency": "CAD",
                        "to_currency": "USD",
                        "rates": [
                            {
                                "amount": "1.0000000000",
                                "rate": "0.7550303900"
                            },
                            {
                                "amount": "100.0000000000",
                                "rate": "0.7550303900"
                            },
                            {
                                "amount": "10000.0000000000",
                                "rate": "0.7550303900"
                            },
                            {
                                "amount": "2000.0000000000",
                                "rate": "0.7550303900"
                            },
                            {
                                "amount": "20000.0000000000",
                                "rate": "0.7550303900"
                            },
                            {
                                "amount": "5000.0000000000",
                                "rate": "0.7550303900"
                            },
                            {
                                "amount": "50000.0000000000",
                                "rate": "0.7550303900"
                            },
                            {
                                "amount": "80000.0000000000",
                                "rate": "0.7550303900"
                            }
                        ],
                        "time_stamp": 1602080062
                    },
                    {
                        "from_currency": "GBP",
                        "to_currency": "USD",
                        "rates": [
                            {
                                "amount": "20000.0000000000",
                                "rate": "1.2628500000"
                            },
                            {
                                "amount": "5000.0000000000",
                                "rate": "1.2628500000"
                            },
                            {
                                "amount": "50000.0000000000",
                                "rate": "1.2628500000"
                            },
                            {
                                "amount": "80000.0000000000",
                                "rate": "1.2628500000"
                            },
                            {
                                "amount": "1.0000000000",
                                "rate": "1.2628500000"
                            },
                            {
                                "amount": "100.0000000000",
                                "rate": "1.2628500000"
                            },
                            {
                                "amount": "10000.0000000000",
                                "rate": "1.2628500000"
                            },
                            {
                                "amount": "2000.0000000000",
                                "rate": "1.2628500000"
                            }
                        ],
                        "time_stamp": 1602080062
                    }
                ]
            }
                """.trimIndent()
        val liveRatesBean = gson.fromJson(jsonString, LiveRatesBean::class.java)
        return liveRatesBean.tiers
    }

    suspend fun getWalletBalance(): List<Wallet>? {
        val jsonString = """
            {
              "ok": true,
              "warning": "",
              "wallet": [
                {
                  "currency": "USDT",
                  "amount": 1245
                },
                {
                  "currency": "BTC",
                  "amount": 1.4
                },
                {
                  "currency": "ETH",
                  "amount": 20.3
                },
                {
                  "currency": "CRO",
                  "amount": 259.1
                },
                {
                  "currency": "DAI",
                  "amount": 854
                }
              ]
            }
                     """.trimIndent()
        val walletBalanceBean = gson.fromJson(jsonString, WalletBalanceBean::class.java)
        return walletBalanceBean.wallet
    }

}