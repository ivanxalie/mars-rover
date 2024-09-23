package com.stringconcat.marsrover

class Plateau(val width: Int = 5, val height: Int = 5) : Surface {
    private val taken = mutableSetOf<Coordinate>()

    init {
        require(width > 0) { "width must be positive!" }
        require(height > 0) { "height must be positive!" }
    }

    override fun land(coordinate: Coordinate) {
        if (coordinate.x > width || coordinate.y > height)
            throw PositionOutsideBound(coordinate, width, height)
        if (containsCoordinate(coordinate)) throw PositionAlreadyTaken(coordinate)
        taken.add(coordinate)
    }

    override fun move(source: Coordinate, destination: Coordinate): Coordinate {
        return if (destination.x > width || destination.y > height
            || taken.contains(destination)) source
        else {
            taken.remove(source)
            taken.add(destination)
            return destination
        }
    }

    override fun width() = width

    override fun height() = height

    override fun containsCoordinate(coordinate: Coordinate) = taken.contains(coordinate)
}