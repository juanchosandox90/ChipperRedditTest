package com.sandoval.chipperreddittest.presentation.ui.main.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.browser.customtabs.CustomTabsIntent
import androidx.core.net.toUri
import androidx.databinding.DataBindingUtil
import com.sandoval.chipperreddittest.R
import com.sandoval.chipperreddittest.databinding.FragmentPostDetailsBinding
import com.sandoval.chipperreddittest.model.Post
import com.sandoval.chipperreddittest.presentation.common.BaseFragment
import com.sandoval.chipperreddittest.presentation.ui.main.list.fragment.PostsListFragment
import com.sandoval.chipperreddittest.presentation.util.extension.onClick
import kotlinx.android.synthetic.main.fragment_post_details.*

class PostDetailsFragment : BaseFragment() {

    private val item: Post? by lazy {
        arguments?.getParcelable<Post>(PostsListFragment.ARG_SELECTED_ITEM)
    }

    private val tabsIntent: CustomTabsIntent by lazy {
        CustomTabsIntent.Builder()
            .setStartAnimations(requireContext(), android.R.anim.fade_in, android.R.anim.fade_out)
            .setExitAnimations(requireContext(), android.R.anim.fade_in, android.R.anim.fade_out)
            .build()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = DataBindingUtil.inflate<FragmentPostDetailsBinding>(
        inflater,
        R.layout.fragment_post_details,
        container,
        false
    ).apply { post = item }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
    }

    private fun initUI() {
        val uri = (BASE_URL + item?.permalink).toUri()
        btnDetailMore.onClick { tabsIntent.launchUrl(requireContext(), uri) }
    }

    private companion object {
        const val BASE_URL = "https://www.reddit.com"
    }
}