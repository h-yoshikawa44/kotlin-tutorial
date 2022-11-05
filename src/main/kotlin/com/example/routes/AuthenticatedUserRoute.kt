package com.example.routes

import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.authenticatedUserRoute() {
    authenticate {
        get("/authenticated") {
            val user = call.authentication.principal<UserIdPrincipal>()
            call.respondText("authenticated id=${user?.name}")
        }
    }
}
