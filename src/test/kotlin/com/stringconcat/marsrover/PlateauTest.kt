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
        val source = Coordinate.zero()
        val destination = Coordinate.zero().incX()

        plateau.land(source)
        val moveResult = plateau.move(source, destination)

        plateau.containsCoordinate(destination) shouldBe true
        plateau.containsCoordinate(source) shouldBe false
        moveResult shouldBe destination
    }

    @Test
    fun `move left take new position on the left`() {
        val source = Coordinate(1, 1)
        val destination = source.decX()

        plateau.land(source)
        val moveResult = plateau.move(source, destination)

        plateau.containsCoordinate(destination) shouldBe true
        plateau.containsCoordinate(source) shouldBe false
        moveResult shouldBe destination
    }

    @Test
    fun `move down take new position on the down`() {
        val source = Coordinate(1, 1)
        val destination = source.decY()

        plateau.land(source)
        val moveResult = plateau.move(source, destination)

        plateau.containsCoordinate(destination) shouldBe true
        plateau.containsCoordinate(source) shouldBe false
        moveResult shouldBe destination
    }

    @Test
    fun `move up take new position on the up`() {
        val source = Coordinate(1, 1)
        val destination = source.incY()

        plateau.land(source)
        val moveResult = plateau.move(source, destination)

        plateau.containsCoordinate(destination) shouldBe true
        plateau.containsCoordinate(source) shouldBe false
        moveResult shouldBe destination
    }

    @Test
    fun `move right on edge should stay the same position`() {
        val source = Coordinate(5, 5)
        val destination = source.incX()

        plateau.land(source)
        val moveResult = plateau.move(source, destination)

        plateau.containsCoordinate(destination) shouldBe false
        plateau.containsCoordinate(source) shouldBe true
        moveResult shouldBe source
    }
}