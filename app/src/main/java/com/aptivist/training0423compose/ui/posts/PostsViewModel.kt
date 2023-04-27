package com.aptivist.training0423compose.ui.posts

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aptivist.training0423compose.data.IPostsAPI
import com.aptivist.training0423compose.domain.IPostsRepository
import com.aptivist.training0423compose.domain.models.Posts
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import javax.inject.Inject

@HiltViewModel
class PostsViewModel @Inject constructor(private val apiRepository: IPostsRepository): ViewModel() {

    private val _postList = mutableStateListOf<Posts>()
    val postList : SnapshotStateList<Posts>
        get() = _postList

    private val _postListViewState = mutableStateOf<PostsViewState>(PostsViewState.Idle)
    val postListViewState : State<PostsViewState>
        get() = _postListViewState

    fun getList(){
         viewModelScope.launch(Dispatchers.IO) {
             val result = apiRepository.getPosts()
             _postList.clear()
             _postList.addAll(result)
         }

    }

    fun clearList(){

    }

}

