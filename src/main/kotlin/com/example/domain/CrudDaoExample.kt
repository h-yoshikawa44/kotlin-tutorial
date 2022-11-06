package com.example.domain

import MemberEntity
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.transactions.transaction

fun main() {
    selectList()
}

fun createSessionFactory() {
    // データベースへの接続
    Database.connect(
        "jdbc:mysql://127.0.0.1:3306/exposed_example",
        driver = "com.mysql.cj.jdbc.Driver",
        user = "root",
        password = "mysql"
    )
}

fun selectList() {
    createSessionFactory()
    transaction {
        val list = MemberEntity.all().map { MemberModel(it) }
        list.forEach {
            println(it)
        }
    }
}
