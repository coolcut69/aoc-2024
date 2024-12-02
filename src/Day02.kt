import kotlin.math.absoluteValue
import kotlin.math.sign

fun main() {

    fun part1(reports: List<String>): Int {
        var validReports = 0
        for (report in reports) {
            var validReport = true
            val split = report.split(" ").map { it.toInt() }

            val windowed = split.windowed(3)

            for (ints in windowed) {
                val diffOne = ints[0] - ints[1]
                val diffTwo = ints[1] - ints[2]
//                println(diffTwo)
//                println(diffOne)
                if (diffTwo.absoluteValue > 3 || diffOne.absoluteValue > 3) {
                    validReport = false
                }
                if (diffTwo.sign != diffOne.sign) {
                    validReport = false
                }

            }
            if (validReport) {
                validReports++
            }
        }

        return validReports
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    // Test if implementation meets criteria from the description, like:
//    check(part1(listOf("test_input")) == 1)

    // Or read a large test input from the `src/Day01_test.txt` file:
    val testInput = readInput("Day02_test")
    println(part1(testInput))
    check(part1(testInput) == 2)
//    check(part2(testInput) == 31)

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day02")
    part1(input).println()
    part2(input).println()
}
