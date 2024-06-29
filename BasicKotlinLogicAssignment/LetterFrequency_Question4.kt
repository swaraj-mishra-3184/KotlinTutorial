fun main() {
    val inputString = "Hello, World!!"
    val frequency = IntArray(26)

    for (char in inputString) {
        if (char.isLetter()) {
            val index = char.toLowerCase() - 'a'
            frequency[index]++
        }
    }

    for (i in frequency.indices) {
        if (frequency[i] > 0) {
            println("${('a' + i)}: ${frequency[i]}")
        }
    }
}
