package com.stringconcat.marsrover

class SphericalInVacuumSurface : Surface {
    override fun land(coordinate: Coordinate) {
        // no-op
    }

    override fun move(source: Coordinate, destination: Coordinate) = destination

    override fun containsCoordinate(coordinate: Coordinate) = false
}