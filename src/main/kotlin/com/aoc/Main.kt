package com.aoc

import com.aoc.days.Day
import com.aoc.days.Day01

fun main() {
    val days = mapOf<Int, Day>(
        1 to Day01
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
