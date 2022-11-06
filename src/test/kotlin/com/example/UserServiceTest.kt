package com.example

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify

class UserServiceTest : StringSpec() {
    init {
        "createMessage:: when user name is exist then return message" {
            // モックオブジェクトの生成
            val userRepository = mockk<UserRepository>()
            val target = UserService(userRepository)

            val id = 100

            // モックオブジェクトの関数の挙動を定義
            every { userRepository.findName(any()) } returns "Kotest"

            // 戻り値の検証
            val result = target.createMessage(id)

            result shouldBe "Hello Kotest"
            // モックオブジェクトの関数呼び出しの検証
            verify { userRepository.findName(id) }
        }

        "createMessage:: when user name is not exist then return null" {
            val userRepository = mockk<UserRepository>()
            val target = UserService(userRepository)

            val id = 100

            every { userRepository.findName(any()) } returns null

            val result = target.createMessage(id)

            result shouldBe null
            verify { userRepository.findName(id) }
        }

        "createMessage:: when id less than 0 then return null" {
            val userRepository = mockk<UserRepository>()
            val target = UserService(userRepository)

            val id = -1

            every { userRepository.findName(any()) } returns null

            val result = target.createMessage(id)

            result shouldBe null
            // exactly で検証したい呼び出し回数を指定
            verify(exactly = 0) { userRepository.findName(any()) }
        }
    }
}
