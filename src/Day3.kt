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

    fun part2(input: List<String>): Long {
        val text = input[0]
        var sum: Long = 0
        var toParse = text.substringBefore("don't()")
        var leftOver = text.substringAfter("don't()")

        val pattern = Regex("mul\\(\\d+,\\d+\\)")
        var matches = pattern.findAll(toParse).map { it.value }.toList()
        sum += matches.sumOf { parseMull(it) }

        while (leftOver.contains(pattern)){
            toParse = leftOver.substringAfter("do()")
            if (toParse.contains("don't")){
                leftOver = toParse.substringAfter("don't()")
            } else {
                toParse = leftOver.substringAfter("do()")
                toParse = toParse.substringBefore("don't()")
                matches = pattern.findAll(toParse).map { it.value }.toList()
                sum += matches.sumOf { parseMull(it) }
                break
            }
            toParse = toParse.substringBefore("don't()")

            matches = pattern.findAll(toParse).map { it.value }.toList()
            sum += matches.sumOf { parseMull(it) }

        }
        return sum
    }

    val testInput = readInput("Day03_test")

    check(part1(testInput) == 161L)
    check(part2(testInput) == 48L)

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day03")
    check(part1(input) == 182619815L)
    check(part2(input) == 80747545L)
}
