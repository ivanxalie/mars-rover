package com.stringconcat.marsrover

class Plateau(val width: Int = 5, val height: Int = 5) {
    private val taken = mutableSetOf<Coordinate>()

    init {
        require(width > 0) { "width must be positive!" }
        require(height > 0) { "height must be positive!" }
    }

    fun land(coordinate: Coordinate) {
        if (coordinate.x > width || coordinate.y > height)
            throw PositionOutsideBound(coordinate, width, height)
        if (containsCoordinate(coordinate)) throw PositionAlreadyTaken(coordinate)
        taken.add(coordinate)
    }

    fun move(source: Coordinate, destination: Coordinate): Coordinate {
        return if (destination.x > width || destination.y > height) source
        else {
            taken.remove(source)
            taken.add(destination)
            return destination
        }
    }

    fun containsCoordinate(coordinate: Coordinate) = taken.contains(coordinate)


}

class PositionOutsideBound(coordinate: Coordinate, width: Int, height: Int) :
    RuntimeException(
        "Coordinate $coordinate cannot be land outside plateau with width = $width," +
                " height = $height!"
    )

class PositionAlreadyTaken(coordinate: Coordinate) :
    RuntimeException("Position om $coordinate already taken!")