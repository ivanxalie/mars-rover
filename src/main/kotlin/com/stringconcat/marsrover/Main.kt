import com.stringconcat.marsrover.Plateau
import com.stringconcat.marsrover.Rover

fun main(args: Array<String>) {
    val mars = Plateau(width = 20, height = 20)
    val rover = Rover.northFaced(surface = mars)

    rover.turnLeft()
    rover.move()
    rover.turnRight()

    println(rover.coordinates)
    println(rover.direction())

}