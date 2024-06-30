fun getLength(str: String?): Int = str?.length ?: -1

fun main() {
    val str: String? = null
    val length = getLength(str)
    println(length)  
}
// Output: -1