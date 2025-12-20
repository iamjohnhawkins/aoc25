package com.aoc.days

/**
 * Day 4: Printing Department
 *
 */
const val MAX_NEIGHBORS = 3


fun inLineNeighbours(line: String, idx: Int): Int {
    return listOf(idx - 1, idx + 1)
        .count { it in line.indices && line[it] == '@' }
}

fun offLineNeighbours(line: String, idx: Int): Int {
    return listOf(idx - 1, idx, idx + 1)
        .count { it in line.indices && line[it] == '@' }
}

fun countNeighbours(current: String, prev: String, next: String, idx: Int): Int {
    return inLineNeighbours(current,idx) +
            offLineNeighbours(next,idx) +
            offLineNeighbours(prev,idx)
}

fun countIsolatedPackets(current: String, prev: String, next: String, maxNeighbours:Int): Int {
    return current.foldIndexed(0,{idx ,acc, curr ->
    if (curr=='@' && countNeighbours(current,prev,next,idx) <= maxNeighbours) acc+1 else acc }
        )
}

fun removeIsolatedPackets(current: String, prev: String, next: String, maxNeighbours:Int): String {
    return current.mapIndexed( { idx,curr  ->
        if (curr=='@' && countNeighbours(current,prev,next,idx) <= maxNeighbours) '.' else curr }).joinToString("")

}
fun List<String>.getLineOrEmpty(idx: Int) = getOrNull(idx) ?: ""

fun removeIsolatedPackets(current: List<String>): Pair<Int, List<String> >{
    return current.foldIndexed(Pair(0,listOf()),
        {idx,acc,curr ->
            val prev = current.getLineOrEmpty(idx - 1)
            val next = current.getLineOrEmpty(idx + 1)

            Pair(acc.first+countIsolatedPackets(curr,prev,next,MAX_NEIGHBORS),
                acc.second+removeIsolatedPackets(curr,prev,next,MAX_NEIGHBORS))
    })
}

object Day04 : Day {
    override fun part1(input: String): Int  {
        val lines = parseInput(input)
        val lastIdx = lines.size -1
        return lines.foldIndexed(0,{idx,acc,curr ->
            acc + countIsolatedPackets(curr,
                if (idx != 0) lines[idx-1] else "",
                if (idx != lastIdx) lines[idx+1] else "",
                MAX_NEIGHBORS)
        })
    }

    override fun part2(input: String): Int {
        val lines = parseInput(input)
        val sequence = generateSequence(Pair(0,lines)) {
            val (count,newState) = removeIsolatedPackets(it.second)
            Pair(count,newState).takeIf {count!=0}
        }
        return sequence.sumOf {it.first}
    }

    private fun parseInput(input: String): List<String> =
        input.lines()
            .filter { it.isNotBlank() }
}
