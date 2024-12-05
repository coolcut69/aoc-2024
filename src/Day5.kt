fun pageInTheMiddle(correctPage: String): Int {
    val split = correctPage.split(',')
    return split[split.size / 2].toInt()
}

fun comparator(sortRules: List<String>): java.util.Comparator<String> = Comparator { a, b ->
    when {
        "$a|$b" in sortRules -> -1
        "$b|$a" in sortRules -> 1
        else -> 0
    }
}

fun hasCorrectOrder(page: String, sortRules: List<String>): Boolean {
    val pageNumbers: List<String> = page.split(",")
    return page == pageNumbers.sortedWith(comparator(sortRules)).joinToString(",")
}

fun main() {

    fun part1(input: List<String>): Int {
        val sortRules = input.filter { it.contains("|") }
        val pages = input.filter { it.contains(",") }

        val correctPages = pages.filter { hasCorrectOrder(it, sortRules) }
        return correctPages.sumOf(::pageInTheMiddle)
    }

    fun fixPages(pages: List<String>, sortRules: List<String>): List<String> {
        return pages.map { page ->
            val pageNumbers: List<String> = page.split(",")
            pageNumbers.sortedWith(comparator(sortRules)).joinToString(",")
        }
    }

    fun part2(input: List<String>): Int {
        val sortRules = input.filter { it.contains("|") }
        val pages = input.filter { it.contains(",") }

        val inCorrectPages = pages.filter { !hasCorrectOrder(it, sortRules) }

        val correctedPages = fixPages(inCorrectPages, sortRules)
        return correctedPages.sumOf(::pageInTheMiddle)
    }

    val testInput = readInput("Day05_test")

    check(part1(testInput) == 143)
    check(part2(testInput) == 123)

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day05")
    check(part1(input) == 4689)
    check(part2(input) == 6336)
}


