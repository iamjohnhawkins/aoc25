package com.aoc.days

/**
 * Day 3: Lobby
 *
 */
fun rankDigit(digits: List<Int>, n: Int, remaining: Int): List<Int> {
    var placed = false
    val lastIdx = remaining
    return digits.mapIndexed { idx,digit ->
        if (placed) return@mapIndexed -1
        if (digit < n && (digits.size - idx) <= lastIdx) {
            placed = true
            return@mapIndexed n
        } else
            return@mapIndexed digit
    }
}

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
fun calcHighestJoltage(batteries: String, num:Int): Long {
    val highestDigits =  batteries.foldIndexed (List<Int>(num){-1},
        {idx, acc, c ->
            val n = c.toString().toInt()
            rankDigit(acc,n,batteries.length-idx)
        })
    return highestDigits.joinToString("").toLong()
}

object Day03 : Day {
    override fun part1(input: String): Int =
        parseInput(input).fold(0,{ acc, s -> acc + calcHighestJoltage(s)})

    override fun part2(input: String): Long =
        parseInput(input).fold(0,{ acc, s -> acc + calcHighestJoltage(s,12)})


    private fun parseInput(input: String): List<String> =
        input.lines()
            .filter { it.isNotBlank() }
}
