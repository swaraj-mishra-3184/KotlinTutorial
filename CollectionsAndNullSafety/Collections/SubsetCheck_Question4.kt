fun isSubset(subset: List<Int>, superset: List<Int>): Boolean {
    for (element in subset) {
        if (element !in superset) {
            return false
        }
    }
    return true
}

fun main() {
    val list1 = listOf(1, 2, 3)
    val list2 = listOf(1, 2, 3, 4, 5)
    val result = isSubset(list1, list2)
    println(result)  
}
// Output: true