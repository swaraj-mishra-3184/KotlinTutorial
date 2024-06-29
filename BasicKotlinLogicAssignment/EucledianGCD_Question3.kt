fun main() {
    var number1 = 56
    var number2 = 98

    while (number2 != 0) {
        val temp = number2
        number2 = number1 % number2
        number1 = temp
    }

    println("The GCD is $number1")
}
