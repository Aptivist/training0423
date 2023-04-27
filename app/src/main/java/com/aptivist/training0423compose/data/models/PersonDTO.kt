package com.aptivist.training0423compose.data.models

import com.aptivist.training0423compose.domain.models.PersonDomain

data class PersonDTO(val name:String = "", val surname: String = "", val age: Int = 0) {
    companion object {
        fun dtoToDomain(personDTO: PersonDTO): PersonDomain {
            return PersonDomain("${personDTO.name} ${personDTO.surname}")
        }
    }
}