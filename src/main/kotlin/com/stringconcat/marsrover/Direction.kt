package com.stringconcat.marsrover

enum class Direction {
    NORTH, WEST, EAST, SOUTH;

    companion object {
        fun from(direction: String): Direction {
            when (direction) {
                "N" -> return NORTH
                "W" -> return WEST
                "E" -> return EAST
                "S" -> return SOUTH
            }
            throw IllegalArgumentException("$direction is not known!")
        }
    }
}