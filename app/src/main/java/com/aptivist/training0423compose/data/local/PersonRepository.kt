package com.aptivist.training0423compose.data.local

import com.aptivist.training0423compose.data.models.PersonDTO
import com.aptivist.training0423compose.domain.IPersonRepository
import com.aptivist.training0423compose.domain.models.PersonDomain

class PersonRepository : IPersonRepository {

    override fun getPerson(): PersonDomain  {
        val myName = "Sergio"
        val myApellido = "Martinez"
        return PersonDomain("$myName $myApellido")
    }

}