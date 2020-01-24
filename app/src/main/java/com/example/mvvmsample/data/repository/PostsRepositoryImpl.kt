package com.example.mvvmsample.data.repository

import androidx.lifecycle.LiveData
import com.example.mvvmsample.data.db.PostsDao
import com.example.mvvmsample.data.db.PostsEntry
import com.example.mvvmsample.data.network.PostsNetworkDataSource
import com.example.mvvmsample.data.network.response.PostsResponse

class PostsRepositoryImpl(
    postsNetworkDataSource: PostsNetworkDataSource,
    private val postsDao: PostsDao
) : PostsRepository {

    init {
        postsNetworkDataSource.downloadedPosts.observeForever {
            persistFetchedPosts(it)
        }
    }

    override fun getPosts(): LiveData<List<PostsEntry>> {
        return postsDao.getPosts()
    }

    private fun persistFetchedPosts(fetchedPosts: List<PostsResponse>) {
        for (items in 0..fetchedPosts.size)
            postsDao.updateOrInsert(fetchedPosts[items].postsEntry)
    }
}