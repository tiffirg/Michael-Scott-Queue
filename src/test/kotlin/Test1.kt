package org.example

import org.jetbrains.kotlinx.lincheck.annotations.Operation
import org.jetbrains.kotlinx.lincheck.check
import org.jetbrains.kotlinx.lincheck.strategy.stress.StressOptions
import kotlin.test.Test

class Test1 {
    private val q = MichaelScottQueue<String>()

    @Operation
    fun push() = q.push("ad")

    @Operation
    fun pop() = q.pop()

    @Test
    fun test() = StressOptions().check(this::class)
}