package com.aoc.days

import kotlin.test.Test
import kotlin.test.assertEquals

class Day03Test {

    private val sampleInput = """
    987654321111111
    811111111111119
    234234234234278
    818181911112111
    """.trimIndent()

    @Test
    fun `calculate highest joltage`() {
        assertEquals(98,calcHighestJoltage("987654321111111"))
        assertEquals(89,calcHighestJoltage("811111111111119"))
        assertEquals(78,calcHighestJoltage("234234234234278"))
        assertEquals(92,calcHighestJoltage("818181911112111"))
    }

    @Test
    fun `calculate highest joltage from 12`() {
        assertEquals(987654321111,calcHighestJoltage("987654321111111",12))
        assertEquals(811111111119,calcHighestJoltage("811111111111119",12))
        assertEquals(434234234278,calcHighestJoltage("234234234234278",12))
        assertEquals(888911112111,calcHighestJoltage("818181911112111",12))
    }

    @Test
    fun `rank digit`() {
        assertEquals(listOf(9,-1,-1,-1),rankDigit(listOf(-1,-1,-1,-1), 9, 5))
        assertEquals(listOf(9,8,-1,-1),rankDigit(listOf(9,-1,-1,-1), 8, 5))
        assertEquals(listOf(9,8,9,-1),rankDigit(listOf(9,8,-1,-1), 9, 2))
    }


    @Test
     fun `part 1 - sample input`() {
         val result = Day03.part1(sampleInput)
         assertEquals(357, result)
     }

    @Test
    fun `part 2 - sample input`() {
        val result = Day03.part2(sampleInput)
        assertEquals(3121910778619L, result)
    }
}
