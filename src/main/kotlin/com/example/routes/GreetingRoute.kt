package com.example.routes

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.greetingRoute() {
    // パスの共通化
    route("greeting") {
        get("/hello") {
            call.respondText("Hello!")
        }

        get("/goodmorning") {
            call.respondText("Good morning!")
        }
    }
}
