package com.aoc.days

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class Day01Test {

    private val sampleInput = """
        L68
        L30
        R48
        L5
        R60
        L55
        L1
        L99
        R14
        L82
    """.trimIndent()


    @Test
    fun `parse string to turn command`() {
        assertEquals(TurnCommand(Direction.RIGHT,63),parseTurnCommand("R63"))
        assertEquals(TurnCommand(Direction.LEFT,63),parseTurnCommand("L63"))
        assertFailsWith<IllegalArgumentException> { parseTurnCommand("J64")}
        assertEquals(TurnCommand(Direction.LEFT,2),parseTurnCommand("L2"))
        assertFailsWith<IllegalArgumentException> { parseTurnCommand("JPP")}
    }
    
    @Test
    fun `execute turn command`() {
        assertEquals(51,turnDial(50, TurnCommand(Direction.RIGHT,1)))
        assertEquals(49,turnDial(50, TurnCommand(Direction.LEFT,1)))
        assertEquals(82,turnDial(50, TurnCommand(Direction.LEFT,68)))
    }

    @Test
    fun `passes zero`() {
        assertEquals(0,passesZero(0, TurnCommand(Direction.RIGHT,1)))
        assertEquals(0,passesZero(0, TurnCommand(Direction.LEFT,1)))
        assertEquals(1,passesZero(0, TurnCommand(Direction.LEFT,100)))
        assertEquals(1,passesZero(50, TurnCommand(Direction.LEFT,100)))
        assertEquals(2,passesZero(50, TurnCommand(Direction.LEFT,200)))

        assertEquals(1,passesZero(0, TurnCommand(Direction.RIGHT,100)))
        assertEquals(1,passesZero(50, TurnCommand(Direction.RIGHT,100)))
        assertEquals(2,passesZero(50, TurnCommand(Direction.RIGHT,200)))
        assertEquals(10,passesZero(50, TurnCommand(Direction.RIGHT,1000)))
        assertEquals(0,passesZero(82, TurnCommand(Direction.LEFT,30)))

    }

    @Test
    fun `passes zero test data`() {
        assertEquals(1,passesZero(50, TurnCommand(Direction.LEFT,68)))
        assertEquals(1,passesZero(52, TurnCommand(Direction.RIGHT,48)))
        assertEquals(1,passesZero(95, TurnCommand(Direction.RIGHT,60)))
        assertEquals(1,passesZero(55, TurnCommand(Direction.LEFT,55)))
        assertEquals(1,passesZero(99, TurnCommand(Direction.LEFT,99)))
        assertEquals(1,passesZero(14, TurnCommand(Direction.LEFT,82)))

        assertEquals(0,passesZero(82, TurnCommand(Direction.LEFT,30)))
        assertEquals(0,passesZero(0, TurnCommand(Direction.LEFT,5)))

    }

     @Test
     fun `part 1 - sample input`() {
         val result = Day01.part1(sampleInput)
         assertEquals(3, result)
     }

    @Test
    fun `part 2 - sample input`() {
        val result = Day01.part2(sampleInput)
        assertEquals(6, result)
    }

    // @Test
    // fun `part 1 - single value returns zero increases`() {
    //     val result = Day01.part1("100")
    //     assertEquals(0, result)
    // }

    // @Test
    // fun `part 1 - all increasing values`() {
    //     val input = """
    //         1
    //         2
    //         3
    //         4
    //     """.trimIndent()
    //     val result = Day01.part1(input)
    //     assertEquals(3, result)
    // }

    // @Test
    // fun `part 1 - all decreasing values`() {
    //     val input = """
    //         10
    //         9
    //         8
    //         7
    //     """.trimIndent()
    //     val result = Day01.part1(input)
    //     assertEquals(0, result)
    // }

    // @Test
    // fun `part 2 - sample input`() {
    //     val result = Day01.part2(sampleInput)
    //     assertEquals(5, result)
    // }

    // @Test
    // fun `part 2 - minimum window size`() {
    //     val input = """
    //         1
    //         2
    //         3
    //         4
    //     """.trimIndent()
    //     val result = Day01.part2(input)
    //     assertEquals(1, result)
    // }

    // @Test
    // fun `part 2 - no increases in windows`() {
    //     val input = """
    //         10
    //         10
    //         10
    //         10
    //     """.trimIndent()
    //     val result = Day01.part2(input)
    //     assertEquals(0, result)
    // }
}
