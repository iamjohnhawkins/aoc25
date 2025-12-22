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
    return (ranges.any() { (a, b) -> a <= i && b >= i })
}

fun rangesOverlap(r1: Pair<Long, Long>, r2: Pair<Long, Long>): Boolean =
    r1.first <= r2.second && r1.second >= r2.first

fun overlappingIndices(pair: Pair<Long, Long>, ranges: List<Pair<Long, Long>>): List<Int> {
    return ranges.mapIndexedNotNull { idx, range ->
        idx.takeIf { rangesOverlap(pair, range) }
    }
}

fun coveringRange(
    newRange: Pair<Long, Long>,
    overlappingIndices: List<Int>,
    current: List<Pair<Long, Long>>
): Pair<Long, Long> {
    val indices = overlappingIndices.toSet()
    return current
        .filterIndexed { idx, _ -> idx in indices }
        .fold(newRange) { (start,end), (a, b) ->
            minOf(a, start) to maxOf(b, end)
        }
}

fun addRange(currentRanges: List<Pair<Long, Long>>, newRange: Pair<Long, Long>): List<Pair<Long, Long>> {
    // the new range will will either be discrete or overlap with one or more ranges
    val overlappingIndices = overlappingIndices(newRange, currentRanges)
    val coveringRange = coveringRange(newRange, overlappingIndices, currentRanges)

    return currentRanges.filterIndexed { idx, _ -> !(idx in overlappingIndices) } + coveringRange
}

fun discreteRanges(ranges: List<Pair<Long, Long>>): List<Pair<Long, Long>> {
    return ranges.fold(emptyList<Pair<Long, Long>>()) { acc, range -> addRange(acc, range) }
}

object Day05 : Day {
    override fun part1(input: String): Int {
        val (ranges, items) = splitRangesAndItems(parseInput(input))
        return items.count { isFresh(it.toLong(), ranges) }
    }

    override fun part2(input: String): Long {
        val (ranges, _) = splitRangesAndItems(parseInput(input))
        val discreteRanges = discreteRanges(ranges)
        return discreteRanges.sumOf { (a, b) -> (b - a + 1) }

    }

    private fun parseInput(input: String): List<String> = input.lines()
}
