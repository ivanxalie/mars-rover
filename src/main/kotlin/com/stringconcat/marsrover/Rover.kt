package com.stringconcat.marsrover

class Rover internal constructor(
    var coordinates: Coordinate,
    var direction: Direction,
    private val surface: Surface
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
            val moveResult = surface?.move(source, destination)
            coordinates = moveResult!!
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

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Rover

        if (coordinates != other.coordinates) return false
        if (direction != other.direction) return false

        return true
    }

    override fun hashCode(): Int {
        var result = coordinates.hashCode()
        result = 31 * result + direction.hashCode()
        return result
    }

    override fun toString() = "Rover(coordinates=$coordinates, direction=$direction)"
}