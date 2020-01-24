package com.example.mvvmsample.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmsample.R
import com.example.mvvmsample.data.db.PostsEntry
import com.example.mvvmsample.databinding.PostsItemLayoutBinding


class PostsAdapter : RecyclerView.Adapter<PostsAdapter.PostsViewHolder>() {

    private var posts : List<PostsEntry> = ArrayList()
    class PostsViewHolder(itemView: PostsItemLayoutBinding) : RecyclerView.ViewHolder(itemView.root) {

        public fun bind(postsEntry: PostsEntry) {
            postsEntry.id
            postsEntry.title
            postsEntry.body
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostsViewHolder {
        var view = DataBindingUtil.inflate<PostsItemLayoutBinding>(LayoutInflater.from(parent.context),R.layout.posts_item_layout, parent, false)
        return PostsViewHolder(view)
    }

    override fun getItemCount(): Int {
        return 10;
        //return posts.size
    }

    override fun onBindViewHolder(holder: PostsViewHolder, position: Int) {
        //holder.bind(posts[position])
    }
}