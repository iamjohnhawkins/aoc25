package com.aoc.days

import kotlin.test.Test
import kotlin.test.assertEquals

class Day07Test {

    private val sampleInput = """
.......S.......
...............
.......^.......
...............
......^.^......
...............
.....^.^.^.....
...............
....^.^...^....
...............
...^.^...^.^...
...............
..^...^.....^..
...............
.^.^.^.^.^...^.
...............
    """.trimIndent()

    @Test
    fun `test starting line conversion`() {
        assertEquals(Pair(listOf('.','|','.'),0),
            mapLine(listOf('.','.','.'),".S."))
    }
    @Test
    fun `straight beam flow`() {
        assertEquals(Pair(listOf('.','|','.'),0),
            mapLine(listOf('.','|','.'),"..."))
    }

    @Test
    fun `straight split flow`() {
        assertEquals(Pair(listOf('.','|','.'),0),
            mapLine(listOf('.','|','.'),"^.^"))
        assertEquals(Pair(listOf('|','.','|'),1),
            mapLine(listOf('.','|','.'),".^."))
    }

    // Tests for part 2
    @Test
    fun `pt 2 - test starting line conversion`() {
        assertEquals(listOf(0L,1L,0L),
            mapCountingBeams(listOf(0L,0L,0L),".S."))
    }
    @Test
    fun `pt 2 - straight beam flow`() {
        assertEquals(listOf(0L,1L,0L),
            mapCountingBeams(listOf(0L,1L,0L),"..."))
    }

    @Test
    fun `pt 2 - straight split flow`() {
        assertEquals(listOf(0L,1L,0L),
            mapCountingBeams(listOf(0L,1L,0L),"^.^"))
        assertEquals(listOf(1L,0L,1L),
            mapCountingBeams(listOf(0L,1L,0L),".^."))
        assertEquals(listOf(0L,2L,0L),
            mapCountingBeams(listOf(1L,0L,1L),"^.^"))
    }


    @Test
     fun `part 1 - sample input`() {
         val result = Day07.part1(sampleInput)
         assertEquals(21, result)
     }

    @Test
    fun `part 2 - sample input`() {
        val result = Day07.part2(sampleInput)
        assertEquals(40, result)
    }
}
