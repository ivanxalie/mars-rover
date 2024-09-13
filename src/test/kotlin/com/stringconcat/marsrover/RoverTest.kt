package com.stringconcat.marsrover

import io.kotest.matchers.shouldBe
import kotlin.test.Test

class RoverTest {

    @Test
    fun `rover created - with initial coordinates`() {
        val rover = Rover.northFaced()

        rover.coordinates shouldBe Coordinate(x = 0, y = 0)
        rover.direction shouldBe Direction.NORTH
    }

    @Test
    fun `north faced rover moves - increase y`() {
        val rover = Rover.northFaced()
        rover.move()

        rover.coordinates shouldBe Coordinate(0, 1)
        rover.direction shouldBe Direction.NORTH
    }

    @Test
    fun `south faced rover moves - decrease y`() {
        val rover = Rover.southFaced(0, 1)
        rover.move()

        rover.coordinates shouldBe Coordinate(0, 0)
        rover.direction shouldBe  Direction.SOUTH
    }

    @Test
    fun `west faced rover moves - decrease x`() {
        val rover = Rover.westFaced(1, 0)
        rover.move()

        rover.coordinates shouldBe Coordinate(0, 0)
        rover.direction shouldBe  Direction.WEST
    }

    @Test
    fun `east faced rover moves - increase x`() {
        val rover = Rover.eastFaced(1, 0)
        rover.move()

        rover.coordinates shouldBe Coordinate(2, 0)
        rover.direction shouldBe  Direction.EAST
    }

    @Test
    fun `north faced rover turns left - direction west`() {
        val rover = Rover.northFaced()
        rover.turnLeft()

        rover.direction shouldBe Direction.WEST
    }

    @Test
    fun `north faced rover turns left twice - direction south`() {
        val rover = Rover.northFaced()
        rover.turnLeft(2)

        rover.direction shouldBe Direction.SOUTH
    }

    @Test
    fun `north faced rover turns left 3 times - direction east`() {
        val rover = Rover.northFaced()
        rover.turnLeft(3)

        rover.direction shouldBe Direction.EAST
    }

    @Test
    fun `north faced rover turns left 4 times - direction north`() {
        val rover = Rover.northFaced()
        rover.turnLeft(4)

        rover.direction shouldBe Direction.NORTH
    }

    @Test
    fun `north faced rover turns right - direction east`() {
        val rover = Rover.northFaced()
        rover.turnRight()

        rover.direction shouldBe Direction.EAST
    }

    @Test
    fun `north faced rover turns right twice - direction south`() {
        val rover = Rover.northFaced()
        rover.turnRight(2)

        rover.direction shouldBe Direction.SOUTH
    }

    @Test
    fun `north faced rover turns right 3 times - direction west`() {
        val rover = Rover.northFaced()
        rover.turnRight(3)

        rover.direction shouldBe Direction.WEST
    }

    @Test
    fun `north faced rover turns right 4 times - direction north`() {
        val rover = Rover.northFaced()
        rover.turnRight(4)

        rover.direction shouldBe Direction.NORTH
    }
}