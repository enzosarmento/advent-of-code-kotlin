import kotlin.math.abs

private fun rowList(input: List<String>): List<MutableList<Int>> {
    val list = mutableListOf<MutableList<Int>>()
    input.forEach { line ->
        val row = line.split(" ")
        list.add(row.map { it.toInt() }.toMutableList())
    }

    return list
}

private fun isSafe(row: List<Int>): Boolean {
    var increasing = 0
    var decreasing = 0
    for (i in 1..<row.size) {
        val diference = abs(row[i] - row[i - 1])
        if (row[i - 1] < row[i] && diference <= 3) {
            increasing++
        } else if (row[i - 1] > row[i] && diference <= 3) {
            decreasing++
        }
    }
    return increasing == row.size - 1 || decreasing == row.size - 1
}

fun main() {

    fun part1(input: List<String>): Int {
        val list = rowList(input)
        var answer = 0
        for (i in list.indices) {
            if (isSafe(list[i])) answer++
        }
        return answer
    }

    fun part2(input: List<String>): Int {
        val list = rowList(input)
        var answer = 0
        for (i in list.indices) {
            if (isSafe(list[i])) answer++
            else {
                for (j in list[i].indices) {
                    val value = list[i].removeAt(j)
                    if (isSafe(list[i])) {
                        answer++
                        break
                    }
                    list[i].add(j, value)
                }
            }
        }
        return answer
    }

    val input = readInput("Day02")
    part1(input).println()
    part2(input).println()

}