fun main() {

    fun correctOrder(page: String, sortRules: List<String>): Boolean {
        val pageNumbers: List<String> = page.split(",")
        for (pageNumber in pageNumbers) {
            val rules = sortRules.filter { it.startsWith("$pageNumber|") }

            for (rule in rules) {
                val element = rule.substringAfter("|")
                if (pageNumbers.indexOf(element) != -1 && (pageNumbers.indexOf(pageNumber) > pageNumbers.indexOf(element))) {
                    return false
                }
            }
        }
        return true
    }

    fun pageInTheMiddle(correctPage: String): Int {
        val split = correctPage.split(',')
        return split[split.size / 2].toInt()
    }

    fun part1(input: List<String>): Int {
        val sortRules = input.filter { it.contains("|") }
        val pages = input.filter { it.contains(",") }

        val correctPages = pages.filter { correctOrder(it, sortRules) }
        return correctPages.sumOf(::pageInTheMiddle)
    }

    fun fixPages(pages: List<String>, sortRules: List<String>): List<String> {
        for (page in pages) {
            val pageNumbers: List<String> = page.split(",")
            for (pageNumber in pageNumbers) {
                val rules = sortRules.filter { it.startsWith("$pageNumber|") }

                for (rule in rules) {
                    val element = rule.substringAfter("|")
                    if (pageNumbers.indexOf(element) != -1 && (pageNumbers.indexOf(pageNumber) > pageNumbers.indexOf(element))) {
                        println(pageNumber)
                    }
                }
            }

        }

        return emptyList()
    }

    fun part2(input: List<String>): Int {
        val sortRules = input.filter { it.contains("|") }
        val pages = input.filter { it.contains(",") }

        val inCorrectPages = pages.filter { !correctOrder(it, sortRules) }

        val correctedPages = fixPages(inCorrectPages, sortRules)
        return correctedPages.sumOf(::pageInTheMiddle)
    }

    val testInput = readInput("Day05_test")

    check(part1(testInput) == 143)
//    check(part2(testInput) == 123)

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day05")
    println(part1(input))
    check(part1(input) == 4689)
    println(part2(input))
//    check(part2(input) == 0)
}


