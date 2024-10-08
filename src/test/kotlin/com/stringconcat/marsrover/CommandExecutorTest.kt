package com.stringconcat.marsrover

import com.stringconcat.marsrover.Direction.*
import io.kotest.assertions.throwables.shouldThrow
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

    @Test
    fun `land rover on position 1 2`() {
        executor.readCommand(" 4 4 ")
        executor.readCommand("1 2 N")

        val surface = executor.surface
        val rover = executor.currentRover

        surface shouldNotBe null
        rover shouldNotBe null
        rover.direction shouldBe NORTH
        surface.width() shouldBe 4
        surface.height() shouldBe 4
        surface.containsCoordinate(Coordinate(1, 2)) shouldBe true
    }

    @Test
    fun `land on missing surface should fail`() {
        shouldThrow<SurfaceNotInitializedException> { executor.readCommand("1 2 N") }
    }

    @Test
    fun `land north faced rover than turn it left should have west direction`() {
        executor.readCommand(" 4 4 ")
        executor.readCommand("1 2 N")
        executor.readCommand("L")

        val rover = executor.currentRover

        rover shouldNotBe null
        rover.direction shouldBe WEST
    }

    @Test
    fun `land north faced rover than turn it left then right should have north direction`() {
        executor.readCommand(" 4 4 ")
        executor.readCommand("1 2 N")
        executor.readCommand("LR")

        val rover = executor.currentRover

        rover shouldNotBe null
        rover.direction shouldBe NORTH
    }

    @Test
    fun `test full integration scenario`() {
        executor.readCommand("5 5")
        executor.readCommand("1 2 N")
        executor.readCommand("LMLMLMLMM")

        val firstRover = executor.currentRover

        firstRover.coordinates shouldBe Coordinate(1, 3)
        firstRover.direction shouldBe NORTH

        executor.readCommand("3 3 E")
        executor.readCommand("MMRMMRMRRM")

        val secondRover = executor.currentRover

        firstRover shouldNotBe secondRover

        secondRover.coordinates shouldBe Coordinate(5, 1)
        secondRover.direction shouldBe EAST
    }
}