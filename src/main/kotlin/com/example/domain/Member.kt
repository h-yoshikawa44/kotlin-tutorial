package com.example.domain

import MemberEntity

data class MemberModel(val id: Int, val name: String) {
    constructor(entity: MemberEntity) : this(entity.id.value, entity.name)
}
