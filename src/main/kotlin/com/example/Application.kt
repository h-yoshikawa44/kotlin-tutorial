package com.example

import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import com.example.plugins.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.auth.*
import io.ktor.server.locations.*
import io.ktor.server.plugins.contentnegotiation.*

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
}

fun Application.module() {
    install(Authentication) {
        basic {
            validate { credentials ->
                if (credentials.name == "user" && credentials.password == "password") {
                    // 認証成功時にセッションに保持される認証情報
                    UserIdPrincipal(credentials.name)
                } else {
                    null
                }
            }
        }
    }
    install(Locations)
    install(ContentNegotiation) {
        json()
    }
    configureRouting()
}
