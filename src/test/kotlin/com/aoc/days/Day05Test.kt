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
    val discreteRanges = listOf(3L to 5L, 10L to 20L)

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
    fun `test for overlapping indices`() {
        assertEquals(listOf(),overlappingIndices(3L to 5L,listOf(6L to 7L)))
        assertEquals(listOf(0),overlappingIndices(3L to 5L,listOf(4L to 7L)))
        assertEquals(listOf(1,2),overlappingIndices(3L to 5L,listOf(1L to 2L, 3L to 4L,4L to 5L)))
        assertEquals(listOf(0),overlappingIndices(3L to 6L,listOf(4L to 5L)))

    }

    @Test
    fun `covering range`() {
        assertEquals(3L to 5L,coveringRange(3L to 5L,listOf<Int>(),listOf(6L to 7L)))
        assertEquals(3L to 7L,coveringRange(3L to 5L,listOf(0),listOf(4L to 7L)))
        assertEquals(3L to 5L,coveringRange(3L to 5L,listOf(1,2),listOf(1L to 2L, 3L to 4L,4L to 5L)))
    }

    @Test
    fun `add range`() {
        assertEquals(listOf(3L to 5L),
            addRange(listOf(), 3L to 5L)
        )
        assertEquals(listOf(3L to 5L),
            addRange(listOf(3L to 5L), 3L to 5L)
        )
    }

    @Test
    fun `discrete ranges`() {
        assertEquals(discreteRanges,discreteRanges(ranges))
    }

    @Test
     fun `part 1 - sample input`() {
         val result = Day05.part1(sampleInput)
         assertEquals(3, result)
     }

    @Test
    fun `part 2 - sample input`() {
        val result = Day05.part2(sampleInput)
        assertEquals(14L, result)
    }

}
