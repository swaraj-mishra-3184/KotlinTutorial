fun main() {
    val numbers = listOf(1, 2, 3, 4, 5)
    val processNumbers: (List<Int>) -> Int = { nums ->
        nums.map { it * it }
            .filter { it % 2 != 0 }
            .reduce { sum, number -> sum + number }
    }
    val result = processNumbers(numbers)
    println(result)  // Output will be 35
}
