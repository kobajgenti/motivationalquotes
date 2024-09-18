package com.example.quoeteapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import com.example.quoeteapp.ui.theme.QuoeteappTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            QuoeteappTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    QuoteScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun QuoteScreen(modifier: Modifier = Modifier) {
    // List of motivational quotes
    val quotes = listOf(
        "A wise man has never killed himself before death – Shota Rustaveli",
        "Nothing is impossible. The word itself says 'I'm possible!' — Audrey Hepburn",
        "Keep your face always toward the sunshine, and shadows will fall behind you. — Walt Whitman",
        "Attitude is a little thing that makes a big difference. — Winston Churchill",
        "To bring about change, you must not be afraid to take the first step. We will fail when we fail to try. — Rosa Parks",
        "All our dreams can come true, if we have the courage to pursue them. — Walt Disney"
    )

    // State to hold the current quote
    var currentQuote by remember { mutableStateOf(getRandomQuote(quotes)) }

    // UI Layout
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(Color(0xFFE3F2FD)), // Light blue background
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = currentQuote,
            fontSize = 20.sp,
            color = Color(0xFF0D47A1), // Dark blue text
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(16.dp)
        )
        Spacer(modifier = Modifier.height(24.dp))
        Button(
            onClick = {
                currentQuote = getRandomQuote(quotes)
            },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1976D2)) // Button color
        ) {
            Text(
                text = "New Quote",
                color = Color.White,
                fontSize = 16.sp
            )
        }
    }
}

// Helper function to get a random quote
fun getRandomQuote(quotes: List<String>): String {
    return quotes[Random.nextInt(quotes.size)]
}

@Preview(showBackground = true)
@Composable
fun QuoteScreenPreview() {
    QuoeteappTheme {
        QuoteScreen()
    }
}