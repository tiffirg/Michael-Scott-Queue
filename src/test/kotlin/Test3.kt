package org.example

import org.jetbrains.kotlinx.lincheck.annotations.Operation
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Assertions.assertEquals
import kotlin.test.Test

class Test4 {
    private var q = MichaelScottQueue<Int>()

    @Operation
    fun push(number: Int) = q.push(number)

    @Operation
    fun pop() = q.pop()

    @BeforeEach
    fun init() {
        q = MichaelScottQueue()
    }

    @Test
    fun testMultiple() {
        push(100)
        push(101)
        push(102)

        assertEquals(100, pop())
        assertEquals(101, pop())
        assertEquals(102, pop())
    }
}