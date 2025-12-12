package com.aoc.days

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue
import kotlin.test.assertFalse


class Day02Test {

    private val sampleInput = """
        11-22,95-115,998-1012,1188511880-1188511890,222220-222224,1698522-1698528,446443-446449,38593856-38593862,565653-565659,824824821-824824827,2121212118-2121212124
    """.trimIndent()


    @Test
    fun `has two repeating sequences`() {
        assertEquals(true, hasTwoRepeatingSequences(11.toString()))
        assertEquals(true, hasTwoRepeatingSequences(12341234.toString(),))
    }
    @Test
    fun `is a single char repeated`() {
        assertTrue(isSingleCharRepeated("1111111111"))
        assertTrue(isSingleCharRepeated("11"))
        assertTrue(isSingleCharRepeated("444"))
        assertFalse(isSingleCharRepeated("1"))
        assertFalse(isSingleCharRepeated(""))
        assertFalse(isSingleCharRepeated("1212"))

    }

    @Test
    fun `does not have two repeating sequences`() {
        assertFalse( hasTwoRepeatingSequences(101.toString()))
        assertFalse( hasTwoRepeatingSequences(1101.toString()))
    }
    @Test
    fun `can generate factors`() {
        assertEquals(listOf(1), factors(1))
        assertEquals(listOf(1,2), factors(2))
        assertEquals(listOf(1,2,5,10), factors(10))
        assertEquals(listOf(1,2,4,8), factors(8))
    }


    @Test
    fun `has any repeating sequences`() {
        assertTrue( hasAnyRepeatingSequences(11.toString()))
        assertTrue( hasAnyRepeatingSequences(12341234.toString(),))
        assertTrue( hasAnyRepeatingSequences(111.toString(),))
        assertTrue( hasAnyRepeatingSequences(123123123.toString(),))
        assertTrue( hasAnyRepeatingSequences(123123123123.toString(),))
        assertTrue( hasAnyRepeatingSequences(565656.toString(),))
        assertTrue( hasAnyRepeatingSequences(999.toString(),))
    }


    @Test
    fun `sum of invalid ids`() {
        assertEquals(33, sumInvalidIds(11,22))
    }

    @Test
    fun `sum of all invalid ids`() {
        assertEquals(33, sumAllInvalidIds(11,22))
        assertEquals(2009, sumAllInvalidIds(998,1012))
    }

    @Test
     fun `part 1 - sample input`() {
         val result = Day02.part1(sampleInput)
         assertEquals(1227775554, result)
     }
}
