package com.stringconcat.marsrover

class CommandExecutor {
    lateinit var currentRover: Rover
    lateinit var surface: Surface
    private val surfaceRegex = Regex("""\d+\s+\d+""")
    private val startPositionRegex = Regex("""\d+\s+\d+\s+[NESW]""")
    private val leftRightMoveRegex = Regex("""[LRM]+""")

    fun readCommand(command: String) {
        val trimmedCommand = command.trim()

        if (surfaceRegex.matches(trimmedCommand))
            createSurface(trimmedCommand)
        else if (startPositionRegex.matches(trimmedCommand))
            landRover(trimmedCommand)
        else if (leftRightMoveRegex.matches(trimmedCommand))
            turnOrMove(trimmedCommand)
    }

    private fun createSurface(command: String) {
        val commandParts = command.split(" ")
        surface = Plateau(commandParts[0].toInt(), commandParts[1].toInt())
    }

    private fun landRover(command: String) {
        ensureSurfaceIsInitialized()
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

    private fun ensureSurfaceIsInitialized() {
        if (!::surface.isInitialized) throw SurfaceNotInitializedException()
    }

    private fun turnOrMove(command: String) {
        ensureSurfaceIsInitialized()
        if (!::currentRover.isInitialized) throw RoverNotInitializedException()
        command.split("").forEach {
            when (it) {
                "M" -> currentRover.move()
                "L" -> currentRover.turnLeft()
                "R" -> currentRover.turnRight()
            }
        }
        println("${currentRover.coordinates.x} ${currentRover.coordinates.y} ${currentRover.direction}")
    }
}

class SurfaceNotInitializedException : RuntimeException("Rover need a surface!")

class RoverNotInitializedException : RuntimeException("We need rover to execute command on!")