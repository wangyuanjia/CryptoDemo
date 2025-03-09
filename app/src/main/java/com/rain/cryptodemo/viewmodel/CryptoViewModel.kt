package com.rain.cryptodemo.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CryptoViewModel : ViewModel() {
    private val _text = MutableStateFlow("Hello, ViewModel!")
    val text: StateFlow<String> = _text

    fun updateText(newText: String) {
        viewModelScope.launch {
            _text.value = newText
        }
    }
}