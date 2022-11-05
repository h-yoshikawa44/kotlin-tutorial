package com.example.routes

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.helloRoute() {
    // パスパラメータ
    get("/hello/{name}") {
        val name = call.parameters["name"]
        call.respondText("Hello $name!")
    }
    // クエリストリング
    get("hello") {
        val name = call.parameters["name"]
        call.respondText("hello $name")
    }
}
