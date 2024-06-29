fun sumOfList(vararg numbers: Int): Int {
    var sum = 0
    for (number in numbers) {
        sum += number
    }
    return sum
}


fun main() {
    println("Sum of 10, 9, 7, 8, 6, 1, 13 is: ${sumOfList(10, 9, 7, 8, 6, 1, 13)}")
}
//Output: Sum of 10, 9, 7, 8, 6, 1, 13 is: 54

