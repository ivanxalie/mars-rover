package com.stringconcat.marsrover

class Rover internal constructor(
    var coordinates: Coordinate,
    var direction: Direction,
    val surface: Surface
) {
    init {
        surface.land(coordinates)
    }

    companion object {
        fun northFaced(x: Int = 0, y: Int = 0, surface: Surface = SphericalInVacuumSurface()) =
            Rover(Coordinate(x, y), Direction.NORTH, surface)

        fun southFaced(x: Int = 0, y: Int = 0, surface: Surface = SphericalInVacuumSurface()) =
            Rover(Coordinate(x, y), Direction.SOUTH, surface)

        fun eastFaced(x: Int = 0, y: Int = 0, surface: Surface = SphericalInVacuumSurface()) =
            Rover(Coordinate(x, y), Direction.EAST, surface)

        fun westFaced(x: Int = 0, y: Int = 0, surface: Surface = SphericalInVacuumSurface()) =
            Rover(Coordinate(x, y), Direction.WEST, surface)
    }

    fun move() {
        val source = coordinates
        try {
            val destination = when (direction) {
                Direction.SOUTH -> coordinates.decY()
                Direction.NORTH -> coordinates.incY()
                Direction.WEST -> coordinates.decX()
                Direction.EAST -> coordinates.incX()
            }
            val moveResult = surface.move(source, destination)
            coordinates = moveResult
        } catch (ignore: Exception) {
        }
    }

    fun turnLeft(times: Int = 1) {
        for (i in 1..times) {
            direction = when (direction) {
                Direction.SOUTH -> Direction.EAST
                Direction.NORTH -> Direction.WEST
                Direction.WEST -> Direction.SOUTH
                Direction.EAST -> Direction.NORTH
            }
        }
    }

    fun turnRight(times: Int = 1) {
        for (i in 1..times) {
            direction = when (direction) {
                Direction.SOUTH -> Direction.WEST
                Direction.NORTH -> Direction.EAST
                Direction.WEST -> Direction.NORTH
                Direction.EAST -> Direction.SOUTH
            }
        }
    }

    fun direction() = direction
}
