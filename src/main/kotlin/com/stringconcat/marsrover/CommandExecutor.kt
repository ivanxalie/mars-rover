package com.stringconcat.marsrover

class CommandExecutor {
    lateinit var currentRover: Rover
    lateinit var surface: Surface
    private val surfaceRegex = Regex("""\d+\s+\d+""")
    private val startPositionRegex = Regex("""\d+\s+\d+\s+[NESW]""")

    fun readCommand(command: String) {
        val trimmedCommand = command.trim()

        if (surfaceRegex.matches(trimmedCommand))
            createSurface(trimmedCommand)
        else if (startPositionRegex.matches(trimmedCommand))
            landRover(trimmedCommand)
    }

    private fun createSurface(command: String) {
        val commandParts = command.split(" ")
        surface = Plateau(commandParts[0].toInt(), commandParts[1].toInt())
    }

    private fun landRover(command: String) {
        if (!::surface.isInitialized) throw SurfaceNotInitializedException()
        val commandParts = command.split(" ")
        val x = commandParts[0].toInt()
        val y = commandParts[1].toInt()
        val direction = Direction.from(commandParts[2])
        currentRover = when (direction) {
            Direction.NORTH -> Rover.northFaced(x, y, surface)
            Direction.WEST -> Rover.westFaced(x, y, surface)
            Direction.EAST -> Rover.eastFaced(x, y, surface)
            Direction.SOUTH -> Rover.southFaced(x, y, surface)
        }
    }
}

class SurfaceNotInitializedException : RuntimeException("Rover need a surface!")