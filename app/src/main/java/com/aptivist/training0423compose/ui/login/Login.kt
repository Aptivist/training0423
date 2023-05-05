package com.aptivist.training0423compose.ui.login

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel


@Composable
fun LoginView(
    navigateToPost: () -> Unit,
    viewModel: LoginVIewModel = hiltViewModel()
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 50.dp, top = 100.dp)
    ) {

        Column(modifier = Modifier.fillMaxWidth()) {
            TextField(
                value = viewModel.loginValue.user,
                onValueChange = {
                    viewModel.obtainUserDataFromView(it)

                }
            )
            TextField(
                value = viewModel.loginValue.password,
                onValueChange = {
                    viewModel.obtainPasswordDataFromView(it)

                }
            )
        }

        Text(text = "Login")
        Button(onClick = {
            navigateToPost()
        }) {
            Text(text = "Login")
        }
    }

}