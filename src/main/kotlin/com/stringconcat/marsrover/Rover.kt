package com.stringconcat.marsrover

class Rover(
    var coordinates: Coordinate,
    var direction: Direction,
    val surface: Surface = SphericalInVacuumSurface()
) {
    companion object {
        fun northFaced(x: Int = 0, y:Int = 0) = Rover(Coordinate(x, y), Direction.NORTH)
        fun southFaced(x: Int = 0, y:Int = 0) = Rover(Coordinate(x, y), Direction.SOUTH)
        fun eastFaced(x: Int = 0, y:Int = 0) = Rover(Coordinate(x, y), Direction.EAST)
        fun westFaced(x: Int = 0, y:Int = 0) = Rover(Coordinate(x, y), Direction.WEST)
    }

    fun move() {
        coordinates = when(direction) {
            Direction.SOUTH -> coordinates.decY()
            Direction.NORTH -> coordinates.incY()
            Direction.WEST -> coordinates.decX()
            Direction.EAST -> coordinates.incX()
        }
    }

    fun turnLeft(times: Int = 1) {
        for (i in 1..times) {
            direction = when(direction) {
                Direction.SOUTH -> Direction.EAST
                Direction.NORTH -> Direction.WEST
                Direction.WEST -> Direction.SOUTH
                Direction.EAST -> Direction.NORTH
            }
        }
    }

    fun turnRight(times: Int = 1) {
        for (i in 1..times) {
            direction = when(direction) {
                Direction.SOUTH -> Direction.WEST
                Direction.NORTH -> Direction.EAST
                Direction.WEST -> Direction.NORTH
                Direction.EAST -> Direction.SOUTH
            }
        }
    }

    fun direction(): Direction {
        TODO("Not yet implemented")
    }

}
