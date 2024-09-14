package com.stringconcat.marsrover


import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class PlateauTest {
    private val plateau = Plateau()

    @Test
    fun `plateau with negative coordinates cannot be created`() {
        shouldThrow<IllegalArgumentException> { Plateau(-1, -1) }
        shouldThrow<IllegalArgumentException> { Plateau(0, 0)  }
    }

    @Test
    fun `land on position beyond limitations are prohibited` () {
        shouldThrow<PositionOutsideBound> { plateau.land(Coordinate(6, 0)) }
        shouldThrow<PositionOutsideBound> { plateau.land(Coordinate(0, 6)) }
        shouldThrow<PositionOutsideBound> { plateau.land(Coordinate(6, 6)) }
    }

    @Test
    fun `land on the same position more than once at the same time are prohibited`() {
        plateau.land(Coordinate.zero())

        shouldThrow<PositionAlreadyTaken> { plateau.land(Coordinate.zero()) }
    }

    @Test
    fun `move right take new position on the right`() {
        plateau.land(Coordinate.zero())
        val moveResult = plateau.move(Coordinate.zero(), Coordinate.zero().incX())

        plateau.containsCoordinate(Coordinate.zero().incX()) shouldBe true
        plateau.containsCoordinate(Coordinate.zero()) shouldBe false
    }

    @Test
    fun `move move left take new position on the left`() {
        val source = Coordinate(1, 1)
        val destination = source.decX()

        plateau.land(source)
        plateau.move(source, destination)

        plateau.containsCoordinate(destination) shouldBe true
        plateau.containsCoordinate(source) shouldBe false
    }
}