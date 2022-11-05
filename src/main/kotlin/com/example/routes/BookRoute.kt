package com.example.routes

import io.ktor.server.application.*
import io.ktor.server.locations.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.serialization.Serializable

@Serializable
data class BookResponse(
    val id: Long,
    val title: String,
    val author: String
)

@Serializable
data class RegisterRequest(
    val id: Long,
    val title: String,
    val author: String
)

fun Route.bookRoute() {
    route("/book") {
        @Location("/detail/{bookId}")
        data class BookLocation(val bookId: Long)
        get<BookLocation> { request ->
            val response = BookResponse(request.bookId, "Kotlin入門", "Kotlin太郎")
            call.respond(response)
        }

        post("/register") {
            val request = call.receive<RegisterRequest>()

            // 登録処理

            call.respondText("registerd. id=${request.id} title=${request.title} author=${request.author}")
        }
    }
}
