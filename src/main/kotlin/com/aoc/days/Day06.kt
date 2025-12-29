package com.aoc.days

/**
 * Day 6: Trash Compactor
 *
 */

fun convertToColumns(rows: List<List<String>>): List<List<String>> {
    return rows[0].indices.map { col ->
        rows.map { it[col] }
    }
}

fun calculateColumnTotal(column: List<String>): Long {
    val values = column.dropLast(1).map { it.toLong() }
    when (column.last()) {
        "+" -> return values.sum()
        "*" -> return values.fold(1L) { acc, i -> acc * i }
        else -> return 0
    }
}
fun createCephalopodValues(columnValues: List<String>): List<Long> {
    val maxLength = columnValues.maxOf { it.length }
    return (0 until maxLength).map { col ->
        columnValues.mapNotNull { it.getOrNull(col) }
            .filterNot { it.isWhitespace() }
            .joinToString("")
            .toLong()


    }
}
fun calculateCephalopodTotal(column: List<String>): Long {
    val values = createCephalopodValues(column.dropLast(1))
    when (column.last()) {
        "+" -> return values.sum()
        "*" -> return values.fold(1L) { acc, i -> acc * i }
        else -> return 0
    }
}
fun parseLines(input: List<String>): List<List<String>> {
    return input.map { it.trim().split(Regex("\\s+")) }

}

fun breakIntoAlignedRows(input: List<String>): List<List<String>> {
    val guideLine = input.last()
    val splitPoints = guideLine.indices.filter { !guideLine[it].isWhitespace() }
    return input.map { str ->
        splitPoints.mapIndexed { i, start ->
            val end = splitPoints.getOrElse(i + 1) { str.length }
            str.substring(start, end).trimEnd()
        }
    }
}

object Day06 : Day {
    override fun part1(input: String): Long {
        val rows = parseLines(parseInput(input))
        val columns = convertToColumns(rows)
        return columns.sumOf { calculateColumnTotal(it) }
    }

    override fun part2(input: String): Long {
        val rows = breakIntoAlignedRows(parseInput(input))
        val columns = convertToColumns(rows)
        return columns.sumOf{ calculateCephalopodTotal(it)}
    }

    private fun parseInput(input: String): List<String> = input.lines()
}
