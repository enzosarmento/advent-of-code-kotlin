import kotlin.math.abs

private fun pairList(input: List<String>): List<Pair<Int, Int>> {
    val list1 = mutableListOf<Int>()
    val list2 = mutableListOf<Int>()
    input.map { it.split(" ") }.forEach {
        list1.add(it.first().toInt())
        list2.add(it.last().toInt())
    }
    list1.sort()
    list2.sort()
    return list1.zip(list2)
}


fun main() {
    fun part1(input: List<String>): Int {
        val list = pairList(input)
        var sum = 0
        list.forEach {
            sum += abs(it.first - it.second)
        }
        return sum
    }

    fun part2(input: List<String>): Int {
        val list = pairList(input)
        val compareList = list.map { it.second }
        var score = 0
        list.forEach { value ->
            var equals = 0
            compareList.forEach {
                if (value.first == it) {
                    equals++
                }
            }
            score += value.first * equals
        }

        return score
    }

    val input = readInput("Day01")
    part1(input).println()
    part2(input).println()
}
