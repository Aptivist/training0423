package com.aptivist.training0423compose.ui.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun DetailPostView(title: String, body: String) {
    Column {
        Text(text = title, style = MaterialTheme.typography.h5)
        Text(text = body)
    }
}