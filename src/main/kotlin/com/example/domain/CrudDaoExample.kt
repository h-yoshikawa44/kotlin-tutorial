package com.example.domain

import MemberEntity
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.transactions.transaction

fun main() {
    selectById()
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

fun selectById() {
    createSessionFactory()
    transaction {
        val entity = MemberEntity.findById(2)
        entity?.let { println(MemberModel(it)) }
    }
}
