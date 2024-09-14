package com.stringconcat.marsrover


import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertFails
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class PlateauTest {
    private val plateau = Plateau()

    @Test
    fun `plateau with negative coordinates cannot be created`() {
        assertThrows<IllegalArgumentException> { Plateau(-1, -1) }
        assertThrows<IllegalArgumentException> { Plateau(0, 0) }
    }

    @Test
    fun `land on position beyond limitations are prohibited` () {
        val plateau = Plateau()

        assertThrows<PositionOutsideBound> { plateau.land(Coordinate(6, 0)) }
        assertThrows<PositionOutsideBound> { plateau.land(Coordinate(0, 6)) }
        assertThrows<PositionOutsideBound> { plateau.land(Coordinate(6, 6)) }
    }

    @Test
    fun `land on the same position more than once at the same time are prohibited`() {
        plateau.land(Coordinate.zero())
        assertThrows<PositionAlreadyTaken> { plateau.land(Coordinate.zero()) }
    }

    @Test
    fun `move right take new position on the right`() {
        plateau.land(Coordinate.zero())
        plateau.move(Coordinate.zero(), Coordinate.zero().incX())

        assertTrue { plateau.containsCoordinate(Coordinate.zero().incX()) }
        assertFalse { plateau.containsCoordinate(Coordinate.zero()) }
    }
}