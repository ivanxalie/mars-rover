package com.stringconcat.marsrover

interface Surface {
    fun land(coordinate: Coordinate)

    fun move(source: Coordinate, destination: Coordinate): Coordinate

    fun containsCoordinate(coordinate: Coordinate): Boolean
}

class PositionOutsideBound(coordinate: Coordinate, width: Int, height: Int) :
    RuntimeException(
        "Coordinate $coordinate cannot be land outside plateau with width = $width," +
                " height = $height!"
    )

class PositionAlreadyTaken(coordinate: Coordinate) :
    RuntimeException("Position om $coordinate already taken!")