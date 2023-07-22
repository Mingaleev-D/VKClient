package com.example.vkclient.domain.model

import com.example.vkclient.R

data class FeedPost(
    val communityName: String = "/dev/null",
    val publicDate: String = "14:00",
    val avatarResId: Int = R.drawable.post_comunity_thumbnail,
    val contentText: String = "Ваши предпочтения не учитываются при поиске",
    val contentImageResId: Int = R.drawable.post_content_image,
    val statistics: List<StatisticItem> = listOf(
        StatisticItem(
            type = StatisticType.VIEWS, 888,
        ),
        StatisticItem(
            type = StatisticType.SHARES,
            8,
        ),
        StatisticItem(
            type = StatisticType.COMMENTS,
            88,
        ),
        StatisticItem(
            type = StatisticType.LIKES, 888,
        )
    )
)
