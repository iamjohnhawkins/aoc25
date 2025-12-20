package com.aoc.days

import kotlin.test.Test
import kotlin.test.assertEquals

class Day04Test {

    private val sampleInput = """
    ..@@.@@@@.
    @@@.@.@.@@
    @@@@@.@.@@
    @.@@@@..@.
    @@.@@@@.@@
    .@@@@@@@.@
    .@.@.@.@@@
    @.@@@.@@@@
    .@@@@@@@@.
    @.@.@@@.@.
    """.trimIndent()

    private val firstRemovedState = """
        .......@..
        .@@.@.@.@@
        @@@@@...@@
        @.@@@@..@.
        .@.@@@@.@.
        .@@@@@@@.@
        .@.@.@.@@@
        ..@@@.@@@@
        .@@@@@@@@.
        ....@@@...
    """.trimIndent()

    @Test
    fun `count neighbours`() {
        assertEquals(2,
            countNeighbours("..@@.@@@@.",
                "","@@@.@.@.@@",0))
        assertEquals(4,
            countNeighbours("..@@.@@@@.",
                "","@@@.@.@.@@",1))
    }

    @Test
    fun `remove reachable packets`() {
        assertEquals(".......@..",
            removeIsolatedPackets("..@@.@@@@.",
                "","@@@.@.@.@@",3))

        assertEquals(".@@.@.@.@@",
            removeIsolatedPackets("@@@.@.@.@@",
                "..@@.@@@@.","@@@@@.@.@@",3))
    }

    @Test
    fun `remove all reachable packets`() {
        assertEquals(Pair(13,firstRemovedState.lines()),removeIsolatedPackets(sampleInput.lines()))
    }

    @Test
    fun `in line neighbours`() {
        assertEquals(1,inLineNeighbours("@@@.@.@.@@",0))
        assertEquals(2,inLineNeighbours("@@@.@.@.@@",1))
        assertEquals(1,inLineNeighbours("@@@.@.@.@@",2))
    }

    @Test
    fun `off line neighbours`() {
        assertEquals(0,offLineNeighbours("",0))
        assertEquals(2,offLineNeighbours("@@@.@.@.@@",0))
        assertEquals(3,offLineNeighbours("@@@.@.@.@@",1))
        assertEquals(2,offLineNeighbours("@@@.@.@.@@",2))
    }

    @Test
    fun `count reachable packets`() {
        assertEquals(5,
            countIsolatedPackets("..@@.@@@@.",
                "","@@@.@.@.@@",3))
        assertEquals(1,
            countIsolatedPackets("@@@.@.@.@@",
                "..@@.@@@@.","@@@@@.@.@@",3))
         }
    @Test
     fun `part 1 - sample input`() {
         val result = Day04.part1(sampleInput)
         assertEquals(13, result)
     }

    @Test
    fun `part 2 - sample input`() {
        val result = Day04.part2(sampleInput)
        assertEquals(43, result)
    }

}
