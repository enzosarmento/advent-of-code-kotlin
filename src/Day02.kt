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

    val input = readInput("Day02")
    part1(input).println()

}