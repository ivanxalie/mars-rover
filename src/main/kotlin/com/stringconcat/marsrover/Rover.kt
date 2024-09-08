package com.stringconcat.marsrover

class Rover(
    var coordinates: Coordinate,
    var direction: Direction
) {
    fun turnLeft() {
        TODO("Not yet implemented")
    }

    fun move() {
        coordinates = when(direction) {
            Direction.SOUTH -> Coordinate(coordinates.x, coordinates.y.dec())
            Direction.NORTH -> coordinates.incY()
            Direction.WEST -> Coordinate(coordinates.x.dec(), coordinates.y)
            Direction.EAST -> Coordinate(coordinates.x.inc(), coordinates.y)
        }
    }

    fun turnRight() {
        TODO("Not yet implemented")
    }

    fun direction(): Direction {
        TODO("Not yet implemented")
    }

}
