package com.aptivist.training0423compose.domain

import com.aptivist.training0423compose.domain.models.PersonDomain

interface IPersonRepository {
    fun getPerson(): PersonDomain
}