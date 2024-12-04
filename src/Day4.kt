
fun main() {

    fun part1(input: List<String>): Int {
        return 0
    }

    fun part2(input: List<String>): Int {
        return 0    }

    val testInput = readInput("Day03_test")

    check(part1(testInput) == 0)
    check(part2(testInput) == 0)

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day03")
    check(part1(input) == 0)
    check(part2(input) == 0)
}
