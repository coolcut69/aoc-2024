class Day04(private val input: List<String>) {

    fun solvePart1(): Int =
        input.flatMapIndexed { y, row ->
            row.mapIndexed { x, c ->
                if (c == 'X') {
                    ALL_DIRECTIONS.count { vector ->
                        vectorFind("XMAS", x, y, vector)
                    }
                } else 0
            }
        }.sum()

    fun solvePart2(): Int =
        input.flatMapIndexed { y, row ->
            row.mapIndexed { x, c ->
                if (c == 'A') {
                    CORNERS
                        .map { (dx, dy) -> input.safeAt(x + dx, y + dy) }
                        .joinToString("") in setOf("MMSS", "MSSM", "SSMM", "SMMS")
                } else false
            }
        }.count { it }

    private fun List<String>.safeAt(x: Int, y: Int): Char =
        if (y in indices && x in this[y].indices) this[y][x] else ' '

    private tailrec fun vectorFind(target: String, x: Int, y: Int, vector: Pair<Int, Int>): Boolean =
        when {
            target.isEmpty() -> true
            target.first() != input.safeAt(x, y) -> false
            else -> vectorFind(target.substring(1), x + vector.first, y + vector.second, vector)
        }

    private companion object {
        val ALL_DIRECTIONS = listOf(
            -1 to -1, -1 to 0, -1 to 1,
            0 to -1, 0 to 1,
            1 to -1, 1 to 0, 1 to 1
        )
        val CORNERS = listOf(-1 to -1, -1 to 1, 1 to 1, 1 to -1)
    }

}

fun main() {

    fun part1(input: List<String>): Int {
        return Day04(input).solvePart1()
    }

    fun part2(input: List<String>): Int {
        return Day04(input).solvePart2()
    }

    val testInput = readInput("Day04_test")

    check(part1(testInput) == 18)
    check(part2(testInput) == 9)

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day04")
    check(part1(input) == 2427)
    check(part2(input) == 1900)
}


