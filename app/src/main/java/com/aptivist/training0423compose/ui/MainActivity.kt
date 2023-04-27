package com.aptivist.training0423compose.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.aptivist.training0423compose.domain.IPersonRepository
import com.aptivist.training0423compose.ui.posts.PostsView
import com.aptivist.training0423compose.ui.theme.Training0423ComposeTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Training0423ComposeTheme {
                PostsView()
            }
        }
    }
}
