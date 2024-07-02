fun transformStrings(list: List<String>, transform: (String) -> String): List<String> {
    return list.map(transform)
}

fun main() {
    val strings = listOf("hello", "world")
    val upperCaseStrings = transformStrings(strings) { it.uppercase() }
    println(upperCaseStrings)
}
