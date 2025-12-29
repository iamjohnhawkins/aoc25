package com.aoc.days

import kotlin.test.Test
import kotlin.test.assertEquals

class Day06Test {

    private val sampleInput = """
    123 328  51 64 
     45 64  387 23 
      6 98  215 314
    *   +   *   +   
    """.trimIndent()

    val sampleAsRows = listOf(
        listOf("123","328","51","64"),
        listOf("45","64","387","23"),
        listOf("6","98","215","314"),
        listOf("*","+","*","+"))

    val sampleAsAlignedRows = listOf(
        listOf("123","328"," 51","64"),
        listOf(" 45","64","387","23"),
        listOf("  6","98","215","314"),
        listOf("*","+","*","+"))

    val sampleAsColumns = listOf(
        listOf("123","45","6","*"),
        listOf("328","64","98","+"),
        listOf("51","387","215","*"),
        listOf("64","23","314","+"))

    val sampleAsAlignedColumns = listOf(
        listOf("123"," 45","  6","*"),
        listOf("328","64","98","+"),
        listOf(" 51","387","215","*"),
        listOf("64","23","314","+"))


    val sampleAsCephalapodValues = listOf(
        listOf(1L,24L,356L),
        listOf(369L,248L,8L),
        listOf(32L,581L,175L),
        listOf(623L,431L,4L))

    @Test
     fun `part 1 - sample input`() {
         val result = Day06.part1(sampleInput)
         assertEquals(4277556, result)
     }

    @Test
    fun `part 2 - sample input`() {
        val result = Day06.part2(sampleInput)
        assertEquals(3263827, result)
    }

    @Test
    fun `parse lines`() {
        assertEquals(sampleAsRows
        ,parseLines(sampleInput.lines()))
    }


    @Test
    fun `convert to columns`() {
        val input = sampleInput.lines().map{ it.trim().split(Regex("\\s+"))}
        assertEquals(sampleAsColumns,convertToColumns(input))
    }

    @Test
    fun `convert to aligned rows based on position of math command`() {
        val input = sampleInput.lines()

        assertEquals(sampleAsAlignedRows, breakIntoAlignedRows(input))
    }

    @Test
    fun `calculate row total`() {
        assertEquals(33210,calculateColumnTotal(sampleAsColumns[0]))
        assertEquals(490,calculateColumnTotal(sampleAsColumns[1]))
        assertEquals(4243455,calculateColumnTotal(sampleAsColumns[2]))
        assertEquals(401,calculateColumnTotal(sampleAsColumns[3]))
    }


    @Test
    fun `calculate cephalapod values`() {
        assertEquals(sampleAsCephalapodValues[0],
            createCephalopodValues(sampleAsAlignedColumns[0].dropLast(1)))
        assertEquals(sampleAsCephalapodValues[1],
            createCephalopodValues(sampleAsAlignedColumns[1].dropLast(1)))
        assertEquals(sampleAsCephalapodValues[2],
            createCephalopodValues(sampleAsAlignedColumns[2].dropLast(1)))
        assertEquals(sampleAsCephalapodValues[3],
            createCephalopodValues(sampleAsAlignedColumns[3].dropLast(1)))
    }

}
