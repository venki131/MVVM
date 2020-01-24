package com.example.mvvmsample.data.repository

import androidx.lifecycle.LiveData
import com.example.mvvmsample.data.db.PostsEntry

interface PostsRepository {
    fun getPosts(): LiveData<List<PostsEntry>>
}