fun reverseList(list: List<Int>): List<Int> {
    val reversedList = mutableListOf<Int>()
    for (i in list.indices.reversed()) {
        reversedList.add(list[i])
    }
    return reversedList
}

fun main() {
    val list = listOf(1, 2, 3, 4, 5)
    val reversed = reverseList(list)
    println(reversed)  
}
// Output: [5, 4, 3, 2, 1]