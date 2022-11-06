package com.example

import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe

class NumberTestByAnnotationSpec : AnnotationSpec() {
    @Test
    fun `isOdd when value is odd number then return true`() {
        val number = Number(1)
        number.isOdd() shouldBe true
    }
}
