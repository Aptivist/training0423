package com.aptivist.training0423compose.ui.posts

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.aptivist.training0423compose.data.IPostsAPI
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.Exception

@Composable
fun PostsView(viewModel: PostsViewModel = hiltViewModel()) {

    val viewState = remember {
        viewModel.postListViewState
    }

    val list = remember {
        viewModel.postList
    }

    LaunchedEffect(true){
        viewModel.getList()
        /* No lo haga compa
        val retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        withContext(Dispatchers.IO) {

            val service = retrofit.create(IPostsAPI::class.java)

            val response = service.getPosts()

            println(response.body())

         */
    }

    LazyColumn(modifier = Modifier.fillMaxSize()){
        items(list){
            Card(modifier = Modifier.fillMaxWidth().padding(8.dp)) {
                Column(modifier = Modifier.fillMaxWidth().padding(8.dp), verticalArrangement = Arrangement.SpaceBetween) {
                    Text(text = it.title, style = MaterialTheme.typography.h5)
                    Text(text = it.content)
                }
            }
        }
    }


}

sealed class PostsViewState {
    object Idle : PostsViewState()
    data class Loading(val message: String): PostsViewState()
    data class Error(val errorTypes: ErrorTypes,val message: String): PostsViewState()
}

enum class ErrorTypes {
    NETWORK,
    EMPTY,
    CONNECTIVITY
}