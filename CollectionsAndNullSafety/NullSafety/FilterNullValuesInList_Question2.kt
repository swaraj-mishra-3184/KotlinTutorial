fun main() {
    val list = listOf(1, null, 3, null, 5)
    val filtered = list.filterNotNull()
    println(filtered) 
}
// Output: [1, 3, 5]