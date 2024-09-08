package com.stringconcat.marsrover

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Assertions.*
import kotlin.test.Test

class RoverTest {

    @Test
    fun `rover created - with initial coordinates`() {
        val rover = Rover(Coordinate(x = 0, y = 0), Direction.NORTH)

        rover.coordinates shouldBe Coordinate(x = 0, y = 0)
        rover.direction shouldBe Direction.NORTH
    }

    @Test
    fun `north faced rover moves - increase y`() {
        val rover = Rover(Coordinate(0, 0), Direction.NORTH)
        rover.move()

        rover.coordinates shouldBe Coordinate(0, 1)
        rover.direction shouldBe Direction.NORTH
    }

    @Test
    fun `south faced rover moves - decrease y`() {
        val rover = Rover(Coordinate(0, 1), Direction.SOUTH)
        rover.move()

        rover.coordinates shouldBe Coordinate(0, 0)
        rover.direction shouldBe  Direction.SOUTH
    }

    @Test
    fun `west faced rover moves - decrease x`() {
        val rover = Rover(Coordinate(1, 0), Direction.WEST)
        rover.move()

        rover.coordinates shouldBe Coordinate(0, 0)
        rover.direction shouldBe  Direction.WEST
    }

    @Test
    fun `east faced rover moves - increase x`() {
        val rover = Rover(Coordinate(1, 0), Direction.EAST)
        rover.move()

        rover.coordinates shouldBe Coordinate(2, 0)
        rover.direction shouldBe  Direction.EAST
    }
}