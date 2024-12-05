fun main() {

    fun checkPage(page: String, sortRules: java.util.ArrayList<String>): Boolean {
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

    fun part1(input: List<String>): Int {
        val sortRules: ArrayList<String> = ArrayList()
        val pages: ArrayList<String> = ArrayList()

        for (line in input) {
            if (line.contains('|')) {
                sortRules.add(line)
            }
            if (line.contains(',')) {
                pages.add(line)
            }
        }

        val correctPages: ArrayList<String> = ArrayList()
        for (page in pages) {
            if (checkPage(page, sortRules)) {
                correctPages.add(page)
            }
        }

        var sum = 0
        correctPages.forEach { correctPage ->
            val split = correctPage.split(',')
            sum += split[split.size / 2].toInt()
        }
        return sum
    }

    fun fixPages(pages: java.util.ArrayList<String>, sortRules: java.util.ArrayList<String>): List<String> {
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
        val sortRules: ArrayList<String> = ArrayList()
        val pages: ArrayList<String> = ArrayList()

        for (line in input) {
            if (line.contains('|')) {
                sortRules.add(line)
            }
            if (line.contains(',')) {
                pages.add(line)
            }
        }

        val inCorrectPages: ArrayList<String> = ArrayList()
        for (page in pages) {
            if (!checkPage(page, sortRules)) {
                inCorrectPages.add(page)
            }
        }

        val correctedPages = fixPages(inCorrectPages, sortRules)

        var sum = 0
        correctedPages.forEach { correctPage ->
            val split = correctPage.split(',')
            sum += split[split.size / 2].toInt()
        }
        return sum
    }

    val testInput = readInput("Day05_test")

    check(part1(testInput) == 143)
    check(part2(testInput) == 123)

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day05")
    println(part1(input))
    check(part1(input) == 4689)
    println(part2(input))
//    check(part2(input) == 0)
}


