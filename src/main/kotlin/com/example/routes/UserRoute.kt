package com.example.routes

import io.ktor.server.application.*
import io.ktor.server.locations.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

@Location("/user/{id}")
data class GetUserLocation(val id: Long)

fun Route.userRoute() {
    get<GetUserLocation> { param ->
        val id = param.id
        call.respondText("id=$id")
    }
}
