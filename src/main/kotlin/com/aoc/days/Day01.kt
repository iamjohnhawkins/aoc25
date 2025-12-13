package com.aoc.days

/**
 * Day 1: Safe
 *
 */
enum class Direction {
    RIGHT,
    LEFT;

    companion object {
        fun from(value: String): Direction = when(value) {
            "R" -> RIGHT
            "L" -> LEFT
            else -> throw IllegalArgumentException("Invalid direction: $value")
        }
    }

}
data class TurnCommand(val direction: Direction, val turns: Int)

fun parseTurnCommand(cmd: String): TurnCommand {
    return TurnCommand(Direction.from(cmd.take(1)),cmd.drop(1).toInt())
}

fun turnDial(start: Int, cmd: TurnCommand): Int {
    return when (cmd.direction) {
        Direction.RIGHT -> (start + cmd.turns).mod(100)
        Direction.LEFT ->  (start - cmd.turns).mod(100)
    }
}

fun passesZero(start: Int, cmd: TurnCommand): Int {
    return when (cmd.direction) {
        Direction.LEFT -> (cmd.turns / 100) + if (start>0 && (cmd.turns % 100) >= start) 1 else 0
        Direction.RIGHT -> (start + cmd.turns) / 100
    }
}
/**
 * Day 1: Secret Entrance
 *
 * Count how many measurements are larger than the previous measurement.
 * Part 2: Use a sliding window of 3 measurements.
 */
object Day01 : Day {

    override fun part1(input: String): Int =
        parseInput(input).fold(50 to 0) { (position, count), cmd ->
            val newPosition = turnDial(position, cmd)
            newPosition to if (newPosition == 0) count + 1 else count
        }.second

    override fun part2(input: String): Int =
        parseInput(input).fold(50 to 0) { (position, count), cmd ->
            turnDial(position, cmd) to count+passesZero(position, cmd)
        }.second


    private fun parseInput(input: String): List<TurnCommand> =
        input.lines()
            .filter { it.isNotBlank() }
            .map { parseTurnCommand(it.trim()) }
}
