package com.example.mvvmsample.data.network

import androidx.lifecycle.LiveData
import com.example.mvvmsample.data.network.response.PostsResponse
import com.example.mvvmsample.utils.Constants
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET

interface PostsNetworkDataSource {

    val downloadedPosts: LiveData<ArrayList<PostsResponse>>

    @GET(Constants.POSTS)
    fun getPosts(): Single<Response<PostsResponse>>
}