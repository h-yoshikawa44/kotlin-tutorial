package com.example

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.headers
import io.kotest.data.row
import io.kotest.data.table
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
        // データ駆動テスト
        "isRange:: when value in range then return true" {
            forAll(
                table(
                    headers("value"),
                    row(1),
                    row(10)
                )
            ) { value ->
                val number = Number(value)
                number.isRange(1, 10) shouldBe true
            }
        }
        "isRange:: when value not in range then return false" {
            forAll(
                table(
                    headers("value"),
                    row(0),
                    row(11)
                )
            ) { value ->
                val number = Number(value)
                number.isRange(1, 10) shouldBe false
            }
        }
    }
}
