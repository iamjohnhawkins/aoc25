package com.aoc.days

import kotlin.math.sqrt

/**
 * Day 3: Lobby
 *
 */
fun calcHighestJoltage(batteries: String): Int {
    val lastIdx = batteries.length-1
    val highestPair =  batteries.foldIndexed (Pair<Int,Int>(-1,-1),
        {idx, acc,c ->
            val n = c.toString().toInt()
            if (n > acc.first && idx != lastIdx)  Pair(n,-1)
            else if (n> acc.second) Pair(acc.first,n)
            else acc
        })
    return highestPair.first * 10 + highestPair.second
}

object Day03 : Day {
    override fun part1(input: String): Int =
        parseInput(input).fold(0,{ acc, s -> acc + calcHighestJoltage(s)})

    override fun part2(input: String): Int =
        0


    private fun parseInput(input: String): List<String> =
        input.lines()
            .filter { it.isNotBlank() }
}
