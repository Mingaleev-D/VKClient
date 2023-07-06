package com.example.vkclient.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.vkclient.R
import com.example.vkclient.ui.components.PostHeader

/**
 * @author : Mingaleev D
 * @data : 06.07.2023
 */


@Preview
@Composable
fun PostCard() {
   Card {
      Column(
          modifier = Modifier.padding(8.dp)
      ) {
         PostHeader()
         Spacer(modifier = Modifier.height(8.dp))
         Text(text = "Ваши предпочтения не учитываются при поиске")
         Spacer(modifier = Modifier.height(8.dp))
         Image(
             modifier = Modifier.fillMaxWidth(),
             painter = painterResource(id = R.drawable.post_content_image),
             contentDescription = null,
             contentScale = ContentScale.FillWidth
         )
         Spacer(modifier = Modifier.height(8.dp))
         Statistics()
      }
   }
}

@Composable
fun Statistics() {
   Row {
      Row(
          modifier = Modifier.weight(1f)
      ) {
         IconWithText(iconResId = R.drawable.ic_views_count, text = "888")
      }
      Row(
          modifier = Modifier.weight(1f),
          horizontalArrangement = Arrangement.SpaceAround
      ) {
         IconWithText(iconResId = R.drawable.ic_share, text = "8")
         IconWithText(iconResId = R.drawable.ic_comment, text = "8")
         IconWithText(iconResId = R.drawable.ic_like, text = "8")
      }
   }
}

@Composable
fun IconWithText(
    iconResId: Int,
    text: String
) {
   Row(
       verticalAlignment = Alignment.CenterVertically
   ) {
      Icon(
          painter = painterResource(id = iconResId), contentDescription = null,
          tint = MaterialTheme.colors.onBackground
      )
      Spacer(modifier = Modifier.width(4.dp))
      Text(text = text, color = MaterialTheme.colors.onBackground)
   }
}