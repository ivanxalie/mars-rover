package com.stringconcat.marsrover

data class Coordinate internal constructor(
    val x: Int,
    val y: Int
) {
    init {
        require(x >= 0) { "x cannot be negative!" }
        require(y >= 0) { "y cannot be negative!" }
    }

    companion object {
        fun zero() = Coordinate(0, 0)
    }

    fun incY() = Coordinate(x, y.inc())
    fun incX() = Coordinate(x.inc(), y)
    fun decY() = Coordinate(x, y.dec())
    fun decX() = Coordinate(x.dec(), y)
    
    override fun toString() = "Coordinate(x=$x, y=$y)"
}

