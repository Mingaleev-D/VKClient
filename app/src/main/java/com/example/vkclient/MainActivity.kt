package com.example.vkclient

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.vkclient.ui.screen.VkMainScreen
import com.example.vkclient.ui.theme.VKClientTheme

@RequiresApi(Build.VERSION_CODES.N)
class MainActivity : ComponentActivity() {

   override fun onCreate(savedInstanceState: Bundle?) {
      super.onCreate(savedInstanceState)
      setContent {
         VKClientTheme {
            VkMainScreen()
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