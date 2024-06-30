fun mapStringLengths(list: List<String>): Map<String, Int> {
    val resultMap = mutableMapOf<String, Int>()
    for (str in list) {
        resultMap[str] = str.length
    }
    return resultMap
}

fun main() {
    val list = listOf("apple", "banana", "cherry")
    val lengths = mapStringLengths(list)
    println(lengths)  
}
// Output: {apple=5, banana=6, cherry=6}