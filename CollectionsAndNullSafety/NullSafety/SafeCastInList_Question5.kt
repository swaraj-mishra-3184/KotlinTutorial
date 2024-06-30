fun filterStrings(list: List<Any>): List<String> {
    val resultList = mutableListOf<String>()
    for (element in list) {
        (element as? String)?.let { resultList.add(it) }
    }
    return resultList
}

fun main() {
    val list: List<Any> = listOf(1, "apple", 2, "banana", 3.0)
    val strings = filterStrings(list)
    println(strings)  
}
// Output: [apple, banana]