package com.aptivist.training0423compose.data.local

import com.aptivist.training0423compose.data.models.PersonDTO
import com.aptivist.training0423compose.domain.IPersonRepository
import com.aptivist.training0423compose.domain.models.PersonDomain

class ThinkinCodeRepository : IPersonRepository {
    override fun getPerson(): PersonDomain {
        val result =  PersonDTO("Jair", "Palma")
        return PersonDTO.dtoToDomain(result)
    }

}