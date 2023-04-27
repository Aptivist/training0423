package com.aptivist.training0423compose.data

import com.aptivist.training0423compose.data.models.PersonDTO
import com.aptivist.training0423compose.data.models.PostDTO
import com.aptivist.training0423compose.data.models.PostDTOItem
import com.aptivist.training0423compose.domain.models.PersonDomain
import com.aptivist.training0423compose.domain.models.Posts

fun PersonDTO.toDomain() : PersonDomain{
    return PersonDomain("${this.name} ${this.surname}")
}

fun PostDTOItem.toDomain() : Posts {
    return Posts(this.title, this.body)
}