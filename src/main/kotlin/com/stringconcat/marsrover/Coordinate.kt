package com.stringconcat.marsrover

data class Coordinate(
    val x: Int,
    val y: Int
) {
    fun incY() = Coordinate(x, y.inc())
    fun incX() = Coordinate(x.inc(), y)
    fun decY() = Coordinate(x, y.dec())
    fun decX() = Coordinate(x.dec(), y)
}