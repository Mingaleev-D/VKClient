package com.example.vkclient.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.vkclient.ui.screen.VkMainScreen
import com.example.vkclient.ui.theme.VKClientTheme

class MainActivity : ComponentActivity() {

   private val viewModel by viewModels<MainViewModel>()
   override fun onCreate(savedInstanceState: Bundle?) {
      super.onCreate(savedInstanceState)
      setContent {
         VKClientTheme {
            VkMainScreen(viewModel)
         }
      }
   }
}

@Composable
fun Greeting(name: String) {
   Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
   VKClientTheme {
      Greeting("Android")
   }
}