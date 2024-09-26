import com.stringconcat.marsrover.CommandExecutor

// cli read было лениво делать, потом сделаю)
fun main(args: Array<String>) {
    val executor = CommandExecutor()
    executor.readCommand("5 5")
    executor.readCommand("1 2 N")
    executor.readCommand("LMLMLMLMM")
    executor.readCommand("3 3 E")
    executor.readCommand("MMRMMRMRRM")
}