private fun executeMuls(instructions: String): Int =
    """mul\((\d{1,3}),(\d{1,3})\)"""
        .toRegex()
        .findAll(instructions)
        .sumOf { match ->
            match.groupValues
                .drop(1)
                .map { it.toInt() }
                .reduce(Int::times)
        }


private fun executeDisabled(instructions: String): Int =
    """(^|do\(\)).*?($|don't\(\))"""
        .toRegex()
        .findAll(instructions)
        .sumOf { executeMuls(it.value) }


fun main() {

    fun part1(input: List<String>): Int {
        val text = input[0]
        return executeMuls(text)
    }

    fun part2(input: List<String>): Int {
        val text = input[0]
        return executeDisabled(text)
    }

    val testInput = readInput("Day03_test")

    check(part1(testInput) == 161)
    check(part2(testInput) == 48)

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day03")
    check(part1(input) == 182619815)
    check(part2(input) == 80747545)
}
