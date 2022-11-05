package com.example.plugins

import io.ktor.server.routing.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.request.*

fun Application.configureRouting() {

    // Starting point for a Ktor app:
    routing {
        get("/") {
            call.respondText("Hello World!")
        }
    }
    // パスパラメータ
    routing {
        get("/hello/{name}") {
            val name = call.parameters["name"]
            call.respondText("Hello $name!")
        }
    }
    // クエリストリング
    routing {
        get("hello") {
            val name = call.parameters["name"]
            call.respondText("hello $name")
        }
    }
}
