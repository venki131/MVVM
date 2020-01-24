package com.example.mvvmsample.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvmsample.R
import com.example.mvvmsample.data.repository.PostsRepository
import com.example.mvvmsample.databinding.ActivityMainBinding
import com.example.mvvmsample.ui.adapter.PostsAdapter
import com.example.mvvmsample.viewmodels.PostsViewModel
import com.example.mvvmsample.viewmodels.ViewModelProviderFactory
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: PostsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        //val viewModelProvider = ViewModelProviderFactory(null)
        viewModel = ViewModelProvider(this).get(PostsViewModel::class.java)

        viewModel.get()

        initRecyclerView()
    }

    private fun initRecyclerView() {
        recyclerView.layoutManager = LinearLayoutManager(this)
        val dividerItemDecoration = DividerItemDecoration(
            recyclerView.context, DividerItemDecoration.VERTICAL
        )
        recyclerView.addItemDecoration(dividerItemDecoration)
        recyclerView.adapter = PostsAdapter()
    }
}
