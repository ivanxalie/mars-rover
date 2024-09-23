package com.stringconcat.marsrover

class CommandExecutor {
    lateinit var surface: Surface
    private val surfaceRegex = Regex("""\d+\s+\d+""")

    fun readCommand(command: String) {
        val trimmedCommand = command.trim()
        
        if (surfaceRegex.matches(trimmedCommand))
            createSurface(trimmedCommand)
    }

    private fun createSurface(command: String) {
        val pair = command.split(" ")
        surface = Plateau(pair[0].toInt(), pair[1].toInt())
    }

}
