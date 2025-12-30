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


    @Test
     fun `part 1 - sample input`() {
         val result = Day07.part1(sampleInput)
         assertEquals(21, result)
     }

}
