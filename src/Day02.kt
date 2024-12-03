import kotlin.math.absoluteValue
import kotlin.math.sign

private fun parse(input: List<String>): List<List<Int>> =
    input.map { row ->
        row.split(" ").map { it.toInt() }
    }

fun main() {

    fun isReportSafe(split: List<Int>): Boolean {
        for (i in 0..split.size - 3) {
            val diffOne = split[i] - split[i + 1]
            val diffTwo = split[i + 1] - split[i + 2]

            if (diffOne.absoluteValue > 3) {
                return false
            }

            if (diffTwo.absoluteValue > 3) {
                return false
            }

            if (diffOne.sign != diffTwo.sign) {
                return false
            }
        }
        return true
    }

    fun part1(reports: List<String>): Int {
        return parse(reports).count { isReportSafe(it) }
    }

    fun isSafeDampened(report: List<Int>): Boolean {
        return report.indices.any { removeThis ->
            isReportSafe(report.filterIndexed { index, _ -> removeThis != index })
        }
    }

    fun part2(reports: List<String>): Int {
        return parse(reports).count { isSafeDampened(it) }
    }

    // Or read a large test input from the `src/Day01_test.txt` file:
    val testInput = readInput("Day02_test")
    check(part1(testInput) == 2)
    check(part2(testInput) == 4)

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day02")
    part1(input).println()
    check(part1(input) == 356)
    part2(input).println()
    check(part2(input) == 413)
}
