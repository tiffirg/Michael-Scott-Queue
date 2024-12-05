package org.example

import org.jetbrains.kotlinx.lincheck.annotations.Operation
import org.jetbrains.kotlinx.lincheck.check
import org.jetbrains.kotlinx.lincheck.strategy.stress.StressOptions
import kotlin.test.Test

class Test2 {
    private val q = MichaelScottQueue<String>()

    @Operation
    fun push() = q.push("ad")

    @Operation
    fun pop() = q.pop()

    @Test
    fun testOptionsOneThread() =
        StressOptions()
            .threads(1)
            .check(this::class)

    @Test
    fun testOptionsMultiThread() =
        StressOptions()
            .threads(8)
            .iterations(16)
            .check(this::class)
}