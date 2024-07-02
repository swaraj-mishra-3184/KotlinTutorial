fun calculateFactorial(n: Int): Long {
    val factorial = { num: Int ->
        if ( num == 0 || num == 1 ) 1 else num*calculateFactorial( num - 1 )
    }

    return factorial(n)
}

fun main() {
    val number = 5
    val factorial = calculateFactorial(number)
    println("Factorial of $number is: $factorial")
}
