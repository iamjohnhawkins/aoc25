package com.aoc.days

/**
 * Day 5: Canteen
 *
 */

fun splitRangesAndItems(lines: List<String>): Pair<List<Pair<Long, Long>>, List<String>> {
    val splitIndex = lines.indexOfFirst { it.isBlank() }
    return Pair(
        lines.take(splitIndex).map {
            it.split("-").let { (a, b) ->
                a.toLong() to b.toLong()
            }
        },
        lines.drop(splitIndex + 1)
    )
}

fun isFresh(i: Long, ranges: List<Pair<Long, Long>>): Boolean {
    return (ranges.any() { (a, b) -> a <= i && b >= i } )
}

object Day05 : Day {
    override fun part1(input: String): Int {
        val (ranges, items) = splitRangesAndItems(parseInput(input))
        return items.count { isFresh(it.toLong(), ranges) }
    }

    override fun part2(input: String): Int = 0

    private fun parseInput(input: String): List<String> = input.lines()
}
