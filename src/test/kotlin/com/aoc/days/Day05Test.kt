package com.aoc.days

import kotlin.test.Test
import kotlin.test.assertEquals

class Day05Test {

    private val sampleInput = """
    3-5
    10-14
    16-20
    12-18

    1
    5
    8
    11
    17
    32
    """.trimIndent()

    val ranges = listOf(3L to 5L, 10L to 14L, 16L to 20L, 12L to 18L)

    @Test
    fun `split input`() {
        assertEquals(
            Pair(
                ranges,
                listOf("1","5","8","11","17","32")),
            splitRangesAndItems(sampleInput.lines()))
    }

    @Test
    fun `is fresh`() {
        assertEquals(false, isFresh(1, ranges))
        assertEquals(true, isFresh(5, ranges))
        assertEquals(false, isFresh(8, ranges))
        assertEquals(true, isFresh(11, ranges))
        assertEquals(true, isFresh(17, ranges))
        assertEquals(false, isFresh(32, ranges))
    }

    @Test
     fun `part 1 - sample input`() {
         val result = Day05.part1(sampleInput)
         assertEquals(3, result)
     }


}
