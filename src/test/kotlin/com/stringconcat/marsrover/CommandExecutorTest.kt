package com.stringconcat.marsrover

import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import org.junit.jupiter.api.Test

class CommandExecutorTest {
    private val executor = CommandExecutor()

    @Test
    fun `create coordinate command should create plateau`() {
        executor.readCommand("3 1")

        val surface = executor.surface
        surface shouldNotBe null
        surface.width() shouldBe 3
        surface.height() shouldBe 1
    }

    @Test
    fun `create coordinate with 4 X 4 should create plateau with correct coordinates`() {
        executor.readCommand(" 4 4 ")

        val surface = executor.surface
        surface shouldNotBe null
        surface.width() shouldBe 4
        surface.height() shouldBe 4
    }
}