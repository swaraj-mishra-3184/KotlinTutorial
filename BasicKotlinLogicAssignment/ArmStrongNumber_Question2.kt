fun main() {
    val number = 153
    var temp = number
    var numDigits = 0
    var sum = 0

    while (temp != 0) {
        numDigits++
        temp /= 10
    }

    temp = number

    while (temp != 0) {
        val digit = temp % 10
        sum += Math.pow(digit.toDouble(), numDigits.toDouble()).toInt()
        temp /= 10
    }

    if (sum == number) {
        println("$number is an Armstrong number.")
    } else {
        println("$number is not an Armstrong number.")
    }
}
