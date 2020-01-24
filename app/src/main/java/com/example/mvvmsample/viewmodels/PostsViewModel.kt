package com.example.mvvmsample.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmsample.data.db.PostsEntry
import com.example.mvvmsample.data.repository.PostsRepository
import com.example.mvvmsample.data.repository.PostsRepositoryImpl

class PostsViewModel (
    private val postsRepository: PostsRepository
) : ViewModel() {

    fun get(): LiveData<List<PostsEntry>> {
        return postsRepository.getPosts()
    }

    init {

    }
}