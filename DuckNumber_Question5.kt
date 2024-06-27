fun main() {
    val number = 3210 
    var num = number
    var isDuck = false

    while (num > 0) {
        val digit = num % 10
        if (digit == 0) {
            isDuck = true
            break
        }
        num /= 10
    }

    if (isDuck) {
        println("$number is a duck number.")
    } else {
        println("$number is not a duck number.")
    }
}
