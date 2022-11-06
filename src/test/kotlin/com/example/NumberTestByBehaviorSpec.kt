package com.example

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

// BehaviorSpec クラスを継承すると Behavior（振る舞い） Spec 実装が可能となる
class NumberTestByBehaviorSpec : BehaviorSpec() {
    init {
        // 対象（関数名など）
        given("isOdd") {
            // 条件（xxx の場合）
            `when`("num is odd number") {
                val number = Number(1)
                // 結果（戻り値など）
                then("return true") {
                    number.isOdd() shouldBe true
                }
            }

            `when`("num is even number") {
                val number = Number(2)
                then("return false") {
                    number.isOdd() shouldBe false
                }
            }
        }
    }
}
