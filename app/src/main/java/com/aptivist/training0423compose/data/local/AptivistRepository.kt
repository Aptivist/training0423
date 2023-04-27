package com.aptivist.training0423compose.data.local

import android.content.Context
import com.aptivist.training0423compose.domain.IPersonRepository
import com.aptivist.training0423compose.R
import com.aptivist.training0423compose.data.models.PersonDTO
import com.aptivist.training0423compose.domain.models.PersonDomain

class AptivistRepository(val context: Context): IPersonRepository {

    override fun getPerson(): PersonDomain {
        val result = PersonDTO(context.getString(R.string.name), context.getString(R.string.surname))
        return PersonMappers.dtoToDomain(result)
    }

}

object PersonMappers {
    fun dtoToDomain(personDTO: PersonDTO): PersonDomain {
        return PersonDomain("${personDTO.name} ${personDTO.surname}")
    }
}