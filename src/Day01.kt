import kotlin.math.abs

fun main() {

    fun part1(input: List<String>): Int {
        val leftList = ArrayList<Int>()
        val rightList = ArrayList<Int>()
        for (s in input) {
            leftList.add(s.substringBefore(" ").toInt())
            rightList.add(s.substringAfterLast(" ").toInt())
        }
        leftList.sort()
        rightList.sort()
        var sum: Int = 0
        for ((index, i) in leftList.withIndex()) {
            sum += abs(i - rightList[index])
        }
        return sum
    }

    fun part2(input: List<String>): Int {
        val leftList = ArrayList<Int>()
        val rightList = ArrayList<Int>()
        for (s in input) {
            leftList.add(s.substringBefore(" ").toInt())
            rightList.add(s.substringAfterLast(" ").toInt())
        }
        var sum: Int = 0
        for (i in leftList) {
            val count = rightList.count { it == i }
            sum += i * count
        }
        return sum


    }

    // Test if implementation meets criteria from the description, like:
//    check(part1(listOf("test_input")) == 1)

    // Or read a large test input from the `src/Day01_test.txt` file:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 11)
    check(part2(testInput) == 31)

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day01")
    part1(input).println()
    part2(input).println()
}
