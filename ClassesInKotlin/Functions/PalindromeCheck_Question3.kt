fun isPalindrome(str: String): Boolean {
    val len = str.length
    for (i in 0 until len / 2) {
        if (str[i] != str[len - 1 - i]) {
            return false
        }
    }
    return true
}
fun main() {
    var str:String = "HelloolleH"
    println("$str is palindrome: ${isPalindrome(str)}")
}
//Output: HelloolleH is palindrome: true

