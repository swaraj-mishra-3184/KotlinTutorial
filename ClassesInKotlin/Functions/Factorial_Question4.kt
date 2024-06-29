fun factorial(n: Int): Int {
    return if (n <= 1) 1 else n * factorial(n - 1)
}

fun main() {
    var num:Int = 5
    println("Factorial of $num is: ${factorial(num)}")
}
//Output: Factorial of 5 is: 120