package com.example.vkclient.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.vkclient.domain.model.FeedPost
import com.example.vkclient.domain.model.StatisticItem

/**
 * @author : Mingaleev D
 * @data : 21.07.2023
 */

class MainViewModel : ViewModel() {

   private val _feedPost = MutableLiveData(FeedPost())
   val feedPost: LiveData<FeedPost> = _feedPost

   fun updateCount(item: StatisticItem) {
      val oldStatistics = feedPost.value?.statistics ?: throw IllegalStateException()
      val newStatistics = oldStatistics.toMutableList().apply {
         replaceAll { oldItem ->
            if (oldItem.type == item.type) {
               oldItem.copy(count = oldItem.count + 1)
            } else {
               oldItem
            }
         }
      }
      _feedPost.value = feedPost.value?.copy(statistics = newStatistics)
   }
}