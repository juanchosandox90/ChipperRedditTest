package com.sandoval.chipperreddittest.ui.list

import android.content.Intent
import androidx.test.filters.SmallTest
import androidx.test.rule.ActivityTestRule
import com.agoda.kakao.screen.Screen
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.sandoval.chipperreddittest.domain.repository.PostsRepository
import com.sandoval.chipperreddittest.presentation.di.localModules
import com.sandoval.chipperreddittest.presentation.di.networkModules
import com.sandoval.chipperreddittest.presentation.di.useCaseModules
import com.sandoval.chipperreddittest.presentation.di.viewModelModules
import com.sandoval.chipperreddittest.presentation.ui.main.MainActivity
import com.sandoval.chipperreddittest.ui.screen.detail.DetailsTestScreen
import com.sandoval.chipperreddittest.ui.screen.list.ListTestScreen
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.koin.core.context.loadKoinModules
import org.koin.core.context.stopKoin
import org.koin.dsl.module

@SmallTest
class PostsListTest {
    @get:Rule
    val activityTestRule = ActivityTestRule(MainActivity::class.java, true, false)

    private val mockRepositoryModule = module {
        single {
            mock<PostsRepository> {
                onBlocking { getRemotePosts(PAGE_SIZE) } doReturn getTestPostsContainer(PAGE_SIZE)
            }
        }
    }

    @Before
    fun setup() {
        loadKoinModules(
            listOf(
                mockRepositoryModule,
                useCaseModules,
                networkModules,
                localModules,
                viewModelModules
            )
        )

        activityTestRule.launchActivity(Intent())
    }

    @After
    fun teardown() {
        stopKoin()
    }

    @Test
    fun checkDetailsDisplayed() {
        Screen.onScreen<ListTestScreen> {
            recycler {
                // 1. Check if list is displayed
                isVisible()

                firstChild<ListTestScreen.Item> {
                    // 2. Click first item
                    click()
                }
            }
        }

        Screen.onScreen<DetailsTestScreen> {
            title {
                // 3. Check if details fragment is displayed
                isVisible()
            }

            pressBack()
        }
    }

    private companion object {
        const val PAGE_SIZE = 25
    }
}