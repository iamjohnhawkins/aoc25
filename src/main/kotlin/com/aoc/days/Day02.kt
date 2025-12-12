package com.aoc.days

/**
 * Day 2: Gift Shop
 *
 */

fun isSingleCharRepeated(s: String): Boolean =
    (s.length > 1) && s.all { it == s[0] }

fun hasTwoRepeatingSequences(s: String): Boolean {
    if (s.length % 2 != 0) return false
    val mid = s.length / 2

    return s.substring(0,mid) == s.substring(mid, s.length)
}

fun factors(num: Int): List<Int> {
    val result = mutableListOf<Int>()
    val limit = kotlin.math.sqrt(num.toDouble()).toInt()

    for (i in 1..limit) {
        if (num % i == 0) {
            result += i
            val other = num / i
            if (other != i) result += other
        }
    }

    return result.sorted()
}

fun hasAnyRepeatingSequences(s: String): Boolean {
    if (s.length < 2) return false
    val factors = factors(s.length)
    factors.dropLast(1).forEach {
        val chunks = s.chunked(it)
        if (chunks.toSet().size == 1) return true
    }
    return false
}

 fun sumInvalidIds(start: Long, end: Long): Long =
    ( start..end).fold(0) {curr,v -> if (hasTwoRepeatingSequences(v.toString())) curr+v else curr}

fun sumAllInvalidIds(start: Long, end: Long): Long =
    ( start..end).fold(0) {curr,v -> if (hasAnyRepeatingSequences(v.toString())) curr+v else curr}

object Day02 : Day {

    override fun part1(input: String): Long =
        parseInput(input).fold(0) { count, p ->
             count + sumInvalidIds(p.first.toLong(), p.second.toLong())
        }

    override fun part2(input: String): Long =
        parseInput(input).fold(0) { count, p ->
            count + sumAllInvalidIds(p.first.toLong(), p.second.toLong())
        }


    private fun parseInput(input: String): List<Pair<String,String>> =
        input.split(",").map { it.split("-").let { (a,b) -> a to b}}
}
