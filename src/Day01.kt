import kotlin.math.max

fun main() {
    fun maxOfInts(leftInt: Int, rightInt: Int) : Int{
        if (leftInt > rightInt) {
            return  leftInt - rightInt
        } else {
            return  rightInt - leftInt
        }
    }

    fun part1(input: List<String>): Int {
        val leftList = ArrayList<Int>()
        val rightList = ArrayList<Int>()
        for (s in input) {
            leftList.add(s.split("   ")[0].toInt())
            rightList.add(s.split("   ")[1].toInt())
        }
        leftList.sort()
        rightList.sort()
        var sum: Int = 0
        for ((index, i) in leftList.withIndex()) {
            sum += maxOfInts(i, rightList[index])
        }
//        sum += maxOfInts(leftList.max(), rightList.max())
        return sum
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    // Test if implementation meets criteria from the description, like:
//    check(part1(listOf("test_input")) == 1)

    // Or read a large test input from the `src/Day01_test.txt` file:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 11)

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day01")
    part1(input).println()
    part2(input).println()
}
