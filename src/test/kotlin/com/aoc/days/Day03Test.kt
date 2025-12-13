package com.aoc.days

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue
import kotlin.test.assertFalse


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
     fun `part 1 - sample input`() {
         val result = Day03.part1(sampleInput)
         assertEquals(357, result)
     }
}
