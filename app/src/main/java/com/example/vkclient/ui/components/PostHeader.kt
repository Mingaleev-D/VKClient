package com.example.vkclient.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.vkclient.R
import com.example.vkclient.domain.model.FeedPost

/**
 * @author : Mingaleev D
 * @data : 06.07.2023
 */

@Composable
fun PostHeader(
    feedPost: FeedPost
) {
   Row(
       modifier = Modifier
           .fillMaxWidth(),
       verticalAlignment = Alignment.CenterVertically
   ) {
      Image(
          modifier = Modifier
              .size(50.dp)
              .clip(CircleShape),
          painter = painterResource(id = feedPost.avatarResId),
          contentDescription = null
      )
      Spacer(modifier = Modifier.width(8.dp))
      Column(
          modifier = Modifier.weight(1f)
      ) {
         Text(
             text = feedPost.communityName,
             color = MaterialTheme.colors.onBackground
         )
         Spacer(modifier = Modifier.height(4.dp))
         Text(
             text = feedPost.publicDate,
             color = MaterialTheme.colors.onSecondary
         )
      }
      Icon(
          imageVector = Icons.Rounded.MoreVert,
          contentDescription = null,
          tint = MaterialTheme.colors.onSecondary
      )
   }
}