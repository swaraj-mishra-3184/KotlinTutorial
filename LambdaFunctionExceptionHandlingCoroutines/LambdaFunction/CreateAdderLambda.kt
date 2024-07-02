fun createAdder(x: Int): (Int) -> Int {
    return { y -> x + y }
}

fun main() {
    val addFive = createAdder(5)
    println(addFive(10)) // Outputs 15
}
