import com.stringconcat.marsrover.Coordinate
import com.stringconcat.marsrover.Direction
import com.stringconcat.marsrover.Plateau
import com.stringconcat.marsrover.Rover

fun main(args: Array<String>) {
    val rover = Rover.northFaced()
    val mars = Plateau(width = 20, height = 20)
    mars.land(rover.coordinates)

    rover.turnLeft()
    rover.move()
    rover.turnRight()

    println(rover.coordinates)
    println(rover.direction())

}