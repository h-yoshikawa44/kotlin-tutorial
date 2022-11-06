package com.example

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

// StringSpec を継承すると String Spec 実装が可能となる
class NumberTestByStringSpec : StringSpec() {
    // init ブロック内にテストコードを実装することで、テスト対象として扱われる
    init {
        "isOdd:: when value is odd number then return true" {
            val number = Number(1)
            number.isOdd() shouldBe true
        }
        "isOdd:: when value is even number then return false" {
            val number = Number(2)
            number.isOdd() shouldBe false
        }
    }
}
