package com.sandoval.chipperreddittest.ui.screen.detail

import com.agoda.kakao.image.KImageView
import com.agoda.kakao.screen.Screen
import com.agoda.kakao.text.KTextView
import com.sandoval.chipperreddittest.R

class DetailsTestScreen : Screen<DetailsTestScreen>() {
    val head = KTextView { withId(R.id.tvDetailHead) }
    val subhead = KTextView { withId(R.id.tvDetailSubhead) }
    val title = KTextView { withId(R.id.tvDetailTitle) }

    val score = KTextView { withId(R.id.tvDetailScore) }
    val numComments = KTextView { withId(R.id.tvDetailNumComments) }

    val picture = KImageView { withId(R.id.imgDetailPicture) }
}