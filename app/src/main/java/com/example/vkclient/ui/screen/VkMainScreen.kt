package com.example.vkclient.ui.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.vkclient.R
import com.example.vkclient.domain.model.FeedPost
import com.example.vkclient.ui.MainViewModel
import com.example.vkclient.ui.components.PostCard

/**
 * @author : Mingaleev D
 * @data : 10.07.2023
 */

@SuppressLint("UnusedMaterialScaffoldPaddingParameter", "UnrememberedMutableState")
@Composable
fun VkMainScreen(
    viewModel: MainViewModel
) {
   val feedPost = viewModel.feedPost.observeAsState(FeedPost())

   Scaffold(
       bottomBar = {
          BottomNavigation {
             var selectedItemPosition by remember { mutableStateOf(0) }

             val items = listOf(
                 NavigationItem.Home,
                 NavigationItem.Favorite,
                 NavigationItem.Profile
             )
             items.forEachIndexed { index, navigationItem ->

                BottomNavigationItem(
                    selected = selectedItemPosition == index,
                    onClick = {
                       selectedItemPosition = index
                    },
                    icon = {
                       Icon(imageVector = navigationItem.icon, contentDescription = null)
                    },
                    label = {
                       Text(text = stringResource(id = navigationItem.titleResId))
                    },
                    selectedContentColor = MaterialTheme.colors.onPrimary,
                    unselectedContentColor = MaterialTheme.colors.onSecondary
                )
             }
          }
       }
   ) {
      PostCard(
          modifier = Modifier.padding(8.dp),
          feedPost = feedPost.value,
          onCommentsClick = {
             viewModel.updateCount(it)
          },
          onLikesClick = {
             viewModel.updateCount(it)
          },
          onSharesClick = {
             viewModel.updateCount(it)
          },
          onViewsClick = {
             viewModel.updateCount(it)
          }
      )
   }
}

sealed class NavigationItem(
    val titleResId: Int,
    val icon: ImageVector
) {
   object Home : NavigationItem(
       titleResId = R.string.home,
       icon = Icons.Outlined.Home
   )

   object Favorite : NavigationItem(
       titleResId = R.string.favorite,
       icon = Icons.Outlined.Favorite
   )

   object Profile : NavigationItem(
       titleResId = R.string.profile,
       icon = Icons.Outlined.Person
   )

}