fun processStrings(strings: List<String>, startingLetter: Char): List<String> {
    return strings.filter { it.startsWith(startingLetter, ignoreCase = true) }
                  .map { it.uppercase() }
                  .sorted()
}

fun main() {
    val fruits = listOf("Apple", "Banana", "Apricot", "Orange", "Grape")
    
    val processedFruits = processStrings(fruits, 'a')
    println(processedFruits)
}
