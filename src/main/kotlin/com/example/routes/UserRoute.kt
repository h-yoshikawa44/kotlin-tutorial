package com.example.routes

import io.ktor.server.application.*
import io.ktor.server.locations.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

@Location("/user")
class UserLocation {
    @Location("/{id}")
    data class GetLocation(val id: Long)

    @Location("/detail/{id}")
    data class GetDetailLocation(val id: Long)
}

fun Route.userRoute() {
    get<UserLocation.GetLocation> { param ->
        val id = param.id
        call.respondText("id=$id")
    }

    get<UserLocation.GetDetailLocation> { param ->
        val id = param.id
        call.respondText("getDetail id=$id")
    }
}
