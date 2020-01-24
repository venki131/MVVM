package com.example.mvvmsample.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface PostsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun updateOrInsert(postsEntry: PostsEntry)

    @Query("SELECT * FROM posts")
    fun getPosts() : LiveData<List<PostsEntry>>
}