package com.aptivist.training0423compose.ui.login

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class LoginVIewModel(
) : ViewModel()  {


    //Opcion 1
    private var _user: MutableState<String> = mutableStateOf("")
    val user : State<String>
        get() = _user

    private var _password: MutableState<String> = mutableStateOf("")
    val password : State<String>
        get() = _password


    //Opcion 2

    private var _loginValue1: MutableState<LoginValues> = mutableStateOf(LoginValues())
    val loginValue1 : State<LoginValues>
        get() = _loginValue1

    //Opcion 3
    var loginValue: LoginValues by mutableStateOf(LoginValues())
        private set



    init {
    }

    fun obtainUserDataFromView(user: String) {

       //Option 1
        _user.value = user

        //Option 2
        _loginValue1.value = _loginValue1.value.copy(user = user)

        //Option 3
        loginValue = loginValue.copy(user = user)
    }

    fun obtainPasswordDataFromView(password: String) {
        //Option 1
        _password.value = password

        //Option 2
        _loginValue1.value = _loginValue1.value.copy(password = password)

        //Option 3
        loginValue = loginValue.copy(password = password)
    }

    fun getUserData(){
        viewModelScope.launch {
           // val user = repository.getUser("USER")
        }

    }

    fun setUserData(user:String){
        viewModelScope.launch(Dispatchers.Main) {
          //  repository.setUser("USER", user)
        }
    }
}

data class LoginValues (
    var user: String = "",
    var password: String = ""
)
