package com.example.vkclient.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.vkclient.R
import com.example.vkclient.domain.model.FeedPost
import com.example.vkclient.domain.model.StatisticItem
import com.example.vkclient.domain.model.StatisticType

/**
 * @author : Mingaleev D
 * @data : 06.07.2023
 */


@Composable
fun PostCard(
    modifier: Modifier = Modifier,
    feedPost: FeedPost,
    onLikesClick: (StatisticItem) -> Unit,
    onSharesClick: (StatisticItem) -> Unit,
    onViewsClick: (StatisticItem) -> Unit,
    onCommentsClick: (StatisticItem) -> Unit,
) {
   Card(
       modifier = modifier
   ) {
      Column(
          modifier = Modifier.padding(8.dp)
      ) {
         PostHeader(feedPost = feedPost)
         Spacer(modifier = Modifier.height(8.dp))
         Text(text = feedPost.contentText)
         Spacer(modifier = Modifier.height(8.dp))
         Image(
             modifier = Modifier
                 .fillMaxWidth()
                 .height(200.dp),
             painter = painterResource(id = feedPost.contentImageResId),
             contentDescription = null,
             contentScale = ContentScale.FillWidth
         )
         Spacer(modifier = Modifier.height(8.dp))
         Statistics(
             statistics = feedPost.statistics,
             onLikesClick = onLikesClick,
             onSharesClick = onSharesClick,
             onViewsClick = onViewsClick,
             onCommentsClick = onCommentsClick,
         )
      }
   }
}

@Composable
fun Statistics(
    statistics: List<StatisticItem>,
    onLikesClick: (StatisticItem) -> Unit,
    onSharesClick: (StatisticItem) -> Unit,
    onViewsClick: (StatisticItem) -> Unit,
    onCommentsClick: (StatisticItem) -> Unit
) {
   Row {
      Row(
          modifier = Modifier.weight(1f)
      ) {
         val viewsItem = statistics.getItemByType(StatisticType.VIEWS)
         IconWithText(
             iconResId = R.drawable.ic_views_count,
             text = viewsItem.count.toString(),
             onItemClickListener = {
                onViewsClick(viewsItem)
             }
         )
      }
      Row(
          modifier = Modifier.weight(1f),
          horizontalArrangement = Arrangement.SpaceAround
      ) {
         val sharesItem = statistics.getItemByType(StatisticType.SHARES)
         IconWithText(
             iconResId = R.drawable.ic_share,
             text = sharesItem.count.toString(),
             onItemClickListener = {
                onSharesClick(sharesItem)
             }
         )
         val commentsItem = statistics.getItemByType(StatisticType.COMMENTS)
         IconWithText(
             iconResId = R.drawable.ic_comment,
             text = commentsItem.count.toString(),
             onItemClickListener = {
                onCommentsClick(commentsItem)
             }
         )
         val likesItem = statistics.getItemByType(StatisticType.LIKES)
         IconWithText(
             iconResId = R.drawable.ic_like,
             text = likesItem.count.toString(),
             onItemClickListener = {
                onLikesClick(likesItem)
             }
         )
      }
   }
}

@Composable
fun IconWithText(
    iconResId: Int,
    text: String,
    onItemClickListener: () -> Unit
) {
   Row(
       modifier = Modifier.clickable {
          onItemClickListener()
       },
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

private fun List<StatisticItem>.getItemByType(type: StatisticType): StatisticItem {
   return this.find { it.type == type } ?: throw IllegalStateException()
}