package com.sandoval.chipperreddittest.presentation.ui.main.list.fragment

import android.os.Bundle
import androidx.navigation.fragment.findNavController
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.LinearLayoutManager
import com.sandoval.chipperreddittest.R
import com.sandoval.chipperreddittest.model.Post
import kotlinx.android.synthetic.main.fragment_posts_list.*
import org.koin.android.viewmodel.ext.android.sharedViewModel
import com.sandoval.chipperreddittest.presentation.common.BaseFragment
import com.sandoval.chipperreddittest.presentation.ui.main.list.PostsViewModel
import com.sandoval.chipperreddittest.presentation.ui.main.list.PostsViewModel.ListState
import com.sandoval.chipperreddittest.presentation.ui.main.list.PostsViewModel.ListState.*
import com.sandoval.chipperreddittest.presentation.ui.main.list.adapter.PostsAdapter
import com.sandoval.chipperreddittest.presentation.util.extension.gone
import com.sandoval.chipperreddittest.presentation.util.extension.invisible
import com.sandoval.chipperreddittest.presentation.util.extension.visible
import com.sandoval.chipperreddittest.presentation.util.nonNull
import com.sandoval.chipperreddittest.presentation.util.observe

class PostsListFragment : BaseFragment() {
    private val mainViewModel by sharedViewModel<PostsViewModel>()

    private val postsAdapter = PostsAdapter(this::selectItem)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_posts_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
        observePosts()
        observeState()
    }


    private fun initUI() {
        rvPostsList.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = postsAdapter
        }
        swipeRefreshList.setOnRefreshListener(this::refreshList)
    }

    private fun observePosts() {
        mainViewModel.postsLiveData.nonNull().observe(this, postsAdapter::submitList)
    }

    private fun observeState() {
        mainViewModel.stateLiveData.nonNull().observe(this, this::onStateChanged)
    }

    private fun onStateChanged(state: ListState) {
        when (state) {
            INITIAL_LOADING -> onInitialLoading()
            LOADED -> onLoaded()
            EMPTY -> onEmpty()
        }
    }

    private fun onInitialLoading() {
        rvPostsList.invisible()
        tvListEmpty.gone()
        groupListLoading.visible()
    }

    private fun onLoaded() {
        groupListLoading.gone()
        tvListEmpty.gone()
        rvPostsList.visible()
    }

    private fun onEmpty() {
        groupListLoading.gone()
        rvPostsList.invisible()
        tvListEmpty.visible()
    }

    private fun refreshList() {
        swipeRefreshList.isRefreshing = true
        mainViewModel.refresh { swipeRefreshList.isRefreshing = false }
    }

    private fun selectItem(item: Post) {
        val args = bundleOf(ARG_SELECTED_ITEM to item)
        findNavController().navigate(R.id.actionListToDetails, args)
    }

    companion object {
        const val ARG_SELECTED_ITEM = "selected_item"
    }
}