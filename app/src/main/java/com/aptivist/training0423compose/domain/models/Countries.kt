package com.aptivist.training0423compose.domain.models

import androidx.annotation.DrawableRes

data class Countries(val name: String, val code: String, @DrawableRes val flag: Int)