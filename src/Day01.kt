import kotlin.math.abs

fun main() {
    fun part1(input: List<String>): Pair<MutableList<Int>, MutableList<Int>> {
        val list1 = mutableListOf<Int>()
        val list2 = mutableListOf<Int>()
        for (i in input.indices) {
            val values = input[i].split(" ")
            list1.add(values[0].toInt())
            list2.add(values[values.size - 1].toInt())
        }
        list1.sort()
        list2.sort()
        return Pair(list1, list2)
    }

    fun part2(input: Pair<List<Int>, List<Int>>): Int {
        var sum = 0
        for (i in 0..<1000) {
            sum += abs(input.first[i] - input.second[i])
        }
        return sum
    }

    val input = readInput("Day01")
    val p1 = part1(input)
    part2(p1).println()
}
