import kotlin.math.abs

fun main() {
    fun part1(input: List<String>): Int {
        val list1 = mutableListOf<Int>()
        val list2 = mutableListOf<Int>()
        for (i in input.indices) {
            val values = input[i].split(" ")
            list1.add(values[0].toInt())
            list2.add(values[values.size - 1].toInt())
        }
        list1.sort()
        list2.sort()
        val pair = Pair(list1, list2)

        var sum = 0
        for (i in 0..<1000) {
            sum += abs(pair.first[i] - pair.second[i])
        }
        return sum
    }

    fun part2(input: List<String>): Int {
        val list1 = mutableListOf<Int>()
        val list2 = mutableListOf<Int>()
        for (i in input.indices) {
            val values = input[i].split(" ")
            list1.add(values[0].toInt())
            list2.add(values[values.size - 1].toInt())
        }

        var score = 0
        for (i in list1.indices) {
            var similarity = 0
            list2.forEach {
                if (list1[i] == it) {
                    similarity++
                }
            }
            score += list1[i] * similarity
        }
        return score
    }

    val input = readInput("Day01")
    part1(input).println()
    part2(input).println()
}
