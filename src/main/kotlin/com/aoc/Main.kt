package com.aoc

import com.aoc.days.Day
import com.aoc.days.Day01
import com.aoc.days.Day02
import com.aoc.days.Day03
import com.aoc.days.Day04
import com.aoc.days.Day05
import com.aoc.days.Day06
import com.aoc.days.Day07

fun main() {
    val days = mapOf<Int, Day>(
        1 to Day01,
        2 to Day02,
        3 to Day03,
        4 to Day04,
        5 to Day05,
        6 to Day06,
        7 to Day07
    )

    println("🎄 Advent of Code 2025 🎄")
    println()

    days.forEach { (dayNumber, day) ->
        val input = readInput(dayNumber)

        println("Day $dayNumber:")
        println("  Part 1: ${day.part1(input)}")
        println("  Part 2: ${day.part2(input)}")
        println()
    }
}

fun readInput(day: Int): String {
    val paddedDay = day.toString().padStart(2, '0')
    return object {}.javaClass.getResourceAsStream("/inputs/day$paddedDay.txt")
        ?.bufferedReader()
        ?.readText()
        ?: throw IllegalArgumentException("Input file for day $day not found")
}
