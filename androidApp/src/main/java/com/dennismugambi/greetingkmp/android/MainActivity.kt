package com.dennismugambi.greetingkmp.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.dennismugambi.greetingkmp.Greeting
import com.dennismugambi.greetingkmp.android.viewmodel.MainViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {

                val greeting = remember { Greeting().greet() }

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    Column(
                        modifier = Modifier.padding(all = 20.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        GreetingView()
                    }
                }
            }
        }
    }
}

@Composable
fun GreetingView(mainViewModel: MainViewModel = viewModel()) {

    val greetings by mainViewModel.greetingList.collectAsStateWithLifecycle()

    greetings.forEach { greeting ->
        Text(text = greeting)
    }
}

@Preview
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        GreetingView()
    }
}
