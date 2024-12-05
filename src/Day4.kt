enum class Direction {
    NORTH, SOUTH, WEST, EAST, NORTH_EAST, SOUTH_EAST, SOUTH_WEST, NORD_WEST
}

private fun Char.isX(): Boolean {
    return this == 'X'
}

private fun Char.isM(): Boolean {
    return this == 'M'
}

private fun Char.isA(): Boolean {
    return this == 'A'
}

private fun Char.isS(): Boolean {
    return this == 'S'
}


fun main() {

    fun part1(input: List<String>): Int {
        val width = input[0].length
        val height = input.size
        println("width $width")
        println("height $height")
        var count = 0

        for (y in 0 until height) {
            for (x in 0 until width) {
                val lengthOfXmas = 4
                if (y - lengthOfXmas >= -1) {
                    if (input[y][x].isX() && input[y - 1][x].isM() && input[y - 2][x].isA() && input[y - 3][x].isS()) {
                        println("x $y, y $x NORTH")
                        count++
                    }
                }
                if (y - lengthOfXmas >= -1 && x + lengthOfXmas <= width) {
                    if (input[y][x].isX() && input[y - 1][x + 1].isM() && input[y - 2][x + 2].isA() && input[y - 3][x + 3].isS()) {
                        println("x $y, y $x NORTH_EAST")
                        count++
                    }
                }
                if (x + lengthOfXmas <= width) {
                    if (input[y][x].isX() && input[y][x + 1].isM() && input[y][x + 2].isA() && input[y][x + 3].isS()) {
                        println("x $y, y $x EAST")
                        count++
                    }
                }
                if (y + lengthOfXmas <= height && x + lengthOfXmas <= width) {
                    if (input[y][x].isX() && input[y + 1][x + 1].isM() && input[y + 2][x + 2].isA() && input[y + 3][x + 3].isS()) {
                        println("x $y, y $x SOUTH_EAST")
                        count++
                    }
                }
                if (y + lengthOfXmas <= height) {
                    if (input[y][x].isX() && input[y + 1][x].isM() && input[y + 2][x].isA() && input[y + 3][x].isS()) {
                        println("x $y, y $x SOUTH")
                        count++
                    }
                }
                if (y + lengthOfXmas <= height && x - lengthOfXmas >= -1) {
                    if (input[y][x].isX() && input[y + 1][x - 1].isM() && input[y + 2][x - 2].isA() && input[y + 3][x - 3].isS()) {
                        println("x $y, y $x SOUTH_WEST")
                        count++
                    }
                }
                if (x - lengthOfXmas >= -1) {
                    if (input[y][x].isX() && input[y][x - 1].isM() && input[y][x - 2].isA() && input[y][x - 3].isS()) {
                        println("x $y, y $x WEST")
                        count++
                    }
                }
                if (y - lengthOfXmas >= -1 && x - lengthOfXmas >= -1) {
                    if (input[y][x].isX() && input[y - 1][x - 1].isM() && input[y - 2][x - 2].isA() && input[y - 3][x - 3].isS()) {
                        println("x $y, y $x NORTH_WEST")
                        count++
                    }
                }
            }

        }
        return count
    }

    fun part2(input: List<String>): Int {
        return 0
    }

    val testInput = readInput("Day04_test")

    check(part1(testInput) == 18)
    check(part2(testInput) == 0)

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day04")
    check(part1(input) == 0)
//    check(part2(input) == 0)
}


