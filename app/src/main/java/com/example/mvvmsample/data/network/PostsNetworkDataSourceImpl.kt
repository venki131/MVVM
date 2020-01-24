package com.example.mvvmsample.data.network

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.example.mvvmsample.data.db.PostsEntry
import com.example.mvvmsample.data.network.response.PostsResponse
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Response

class PostsNetworkDataSourceImpl(
    private val retrofitBuilder: RetrofitBuilder
) : PostsNetworkDataSource {

    private val _downloadedPosts = MediatorLiveData<ArrayList<PostsResponse>>()

    override val downloadedPosts: LiveData<ArrayList<PostsResponse>>
        get() = _downloadedPosts

    override fun getPosts(): Single<Response<PostsResponse>> {
        val getPosts = retrofitBuilder.getPosts()
        var postList = ArrayList<PostsEntry>()

        getPosts.subscribeOn(Schedulers.io())
            .map {
                if (it.isSuccessful) {
                    it.body()?.postsEntry?.let { it1 -> postList.add(it1) }
                }
            }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe()

        //_downloadedPosts.postValue(postList)
        return getPosts
    }

    init {
        retrofitBuilder.getRetrofitObj()
    }

}
