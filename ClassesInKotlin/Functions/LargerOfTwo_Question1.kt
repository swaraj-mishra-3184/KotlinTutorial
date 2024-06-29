fun largerOfTwo(a: Int, b: Int): Int {
    return if (a > b) a else b
}

fun main() {
    var x:Int = 10
    var y:Int = 9
    
    println("Among $x and $y, ${largerOfTwo(x, y)} is larger")
}
//Output: Among 10 and 9, 10 is larger