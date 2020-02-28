package com.sandoval.chipperreddittest.ui.screen.list

import android.view.View
import com.agoda.kakao.image.KImageView
import com.agoda.kakao.recycler.KRecyclerItem
import com.agoda.kakao.recycler.KRecyclerView
import com.agoda.kakao.screen.Screen
import com.agoda.kakao.text.KTextView
import com.sandoval.chipperreddittest.R
import org.hamcrest.Matcher

internal class ListTestScreen : Screen<ListTestScreen>() {
    val recycler = KRecyclerView({ withId(R.id.rvPostsList) }, { itemType(ListTestScreen::Item) })

    class Item(parent: Matcher<View>) : KRecyclerItem<Item>(parent) {
        val head = KTextView { withId(R.id.tvItemHead) }
        val subhead = KTextView { withId(R.id.tvItemSubhead) }
        val title = KTextView { withId(R.id.tvItemTitle) }

        val score = KTextView { withId(R.id.tvItemScore) }
        val numComments = KTextView { withId(R.id.tvItemNumComments) }

        val thumb = KImageView { withId(R.id.imgItemThumb) }
    }
}