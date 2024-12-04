import kotlin.math.abs

fun main() {

    fun part1(input: List<String>): Int {
        var answer = 0
        for (i in input.indices) {
            val line = input[i].split(" ")
            val lineInt = line.map { it.toInt() }
            var increasing = 0
            var decreasing = 0

            for (j in 1..<lineInt.size) {
                val diference = abs(lineInt[j] - lineInt[j - 1])
                if (lineInt[j - 1] < lineInt[j] && diference <= 3) {
                    increasing++
                } else if (lineInt[j - 1] > lineInt[j] && diference <= 3) {
                    decreasing++
                }
            }
            if (increasing == lineInt.size - 1 || decreasing == lineInt.size - 1) answer++
        }
        return answer
    }

    fun part2(input: List<String>): Int {
        var answer = 0
        for (i in input.indices) {
            val line = input[i].split(" ")
            val lineInt = line.map { it.toInt() }.toMutableList()
            var increasing = 0
            var decreasing = 0

            for (j in 1..<lineInt.size) {
                val diference = abs(lineInt[j] - lineInt[j - 1])
                if (lineInt[j - 1] < lineInt[j] && diference <= 3) {
                    increasing++
                } else if (lineInt[j - 1] > lineInt[j] && diference <= 3) {
                    decreasing++
                }
            }
            if (increasing == lineInt.size - 1 || decreasing == lineInt.size - 1) answer++
            else {
                increasing = 0
                decreasing = 0
                for (j in lineInt.indices) {
                    val value = lineInt.removeAt(j)
                    for (k in 1..<lineInt.size) {
                        val diference = abs(lineInt[k] - lineInt[k - 1])
                        if (lineInt[k - 1] < lineInt[k] && diference <= 3) {
                            increasing++
                        } else if (lineInt[k - 1] > lineInt[k] && diference <= 3) {
                            decreasing++
                        }
                    }
                    if (increasing == lineInt.size - 1 || decreasing == lineInt.size - 1) {
                        answer++
                        break
                    }
                    increasing = 0
                    decreasing = 0
                    lineInt.add(j, value)
                }
            }
        }
        return answer
    }

    val input = readInput("Day02")
    part1(input).println()
    part2(input).println()

}