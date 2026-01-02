package com.aoc.days

/**
 * Day 7: Teleporter
 *
 */

fun mapLine(startingLine: List<Char>, line: String): Pair<List<Char>,Int> {
    var splitCount = 0
    val newLine = startingLine.mapIndexed { index, c ->
        val prev = if (index > 0) line[index - 1] else '.'
        val next = if (index+1 < line.length) line[index + 1] else '.'
        val inpPrev = if (index > 0) startingLine[index - 1] else '.'
        val inpNext = if (index+1 < startingLine.size) startingLine[index + 1] else '.'
        when (line[index]) {
            'S' -> '|'
            '^' -> {if(c=='|') {splitCount = splitCount+1}; '.'}
            '.' -> if ((prev=='^' && inpPrev=='|') ||
                (next=='^' && inpNext == '|')) '|' else c
            else -> c
        }
    }
    return Pair(newLine,splitCount)
}

fun mapCountingBeams(startingLine: List<Long>, line: String): List<Long> {
    return startingLine.mapIndexed { index, beamCount ->
        val prev = if (index > 0) line[index - 1] else '.'
        val next = if (index+1 < line.length) line[index + 1] else '.'
        val inpPrev = if (index > 0) startingLine[index - 1] else 0
        val inpNext = if (index+1 < startingLine.size) startingLine[index + 1] else 0

        when (line[index]) {
            'S' -> 1
            '^' -> 0
            '.' -> (beamCount + (if (prev=='^') inpPrev else 0) + (if (next=='^') inpNext else 0))
            else -> beamCount
        }
    }
}

object Day07 : Day {
    override fun part1(input: String): Int {
        val lines = parseInput(input)
        val lineLength = lines.first().length
        return lines
            .fold(Pair(List(lineLength) { '.' },0),
            { acc,str ->
                val result = mapLine(acc.first,str)
                Pair(result.first,result.second+acc.second) })
            .second
    }

    override fun part2(input: String): Long {
        val lines = parseInput(input)
        val lineLength = lines.first().length
        return lines
            .fold(List(lineLength) { 0L },
                { acc,str ->
                    mapCountingBeams(acc,str) })
            .sumOf { it }
    }

    private fun parseInput(input: String): List<String> = input.lines()
}
