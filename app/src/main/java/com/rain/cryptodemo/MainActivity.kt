package com.rain.cryptodemo

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import com.rain.cryptodemo.ui.theme.CryptoDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CryptoDemoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Open Crypto")
                }
            }
        }
    }

    @Composable
    fun Greeting(name: String, modifier: Modifier = Modifier) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
        ) {
            Text(
                color = Color.Blue,
                text = " $name",
                modifier = modifier.clickable {
                    jumpToCryptoActivity()
                },
                textAlign = TextAlign.Center,
                fontSize = 24.sp
            )
        }
    }

    private fun jumpToCryptoActivity() {
        startActivity(Intent(this@MainActivity, CryptoActivity::class.java))
    }

    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        CryptoDemoTheme {
            Greeting("Android")
        }
    }
}


