private const val regex = """mul\((\d{1,3}),(\d{1,3})\)"""
private const val doRegex = """do\(\)"""
private const val dontRegex = """don't\(\)"""

fun addValidMultiplicationPart2(line: String): Long {
    var sum = 0L
    var enabled = true
    """$regex|$doRegex|$dontRegex""".toRegex().findAll(line).forEach { match ->
        when (match.value) {
            "don't()" -> enabled = false
            "do()" -> enabled = true
            else -> if (enabled) sum += match.multiplyNumber()
        }
    }
    return sum
}

private fun MatchResult.multiplyNumber(): Long {
    val (first, second) = destructured
    return first.toLong() * second.toLong()
}


fun main() {

    fun part1(input: List<String>): Long {
        var answer = 0L
        for (i in input.indices) {
            val values = regex.toRegex().findAll(input[i])
            for (value in values) {
                answer += value.groupValues[1].toInt() * value.groupValues[2].toInt()
            }
        }
        return answer
    }

    fun part2(input: List<String>): Long {
        return addValidMultiplicationPart2(input.joinToString())
    }


    val input = readInput("Day03")
    part1(input).println()
    part2(input).println()
}