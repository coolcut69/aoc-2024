fun main() {

    fun parseMull(it: String): Long {
        val substringAfter = it.substringBefore(")").substringAfter("mul(")
        val split = substringAfter.split(",")
        return split[0].toLong() * split[1].toLong()
    }

    fun part1(input: List<String>): Long {
        val text = input[0]

        val pattern = Regex("mul\\(\\d+,\\d+\\)")
        val matches = pattern.findAll(text).map { it.value }.toList()
        return matches.sumOf { parseMull(it) }
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    val testInput = readInput("Day03_test")

    check(part1(testInput) == 161L)
//    check(part2(testInput) == 1)

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day03")
//    check(part1(testInput) == 1)
//    check(part2(testInput) == 1)
    part1(input).println()
    part2(input).println()
}
