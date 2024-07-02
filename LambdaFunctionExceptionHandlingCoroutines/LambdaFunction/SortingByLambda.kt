fun main() {
    val people = listOf(
        "Pradyumna" to 20,
        "Rajesh" to 25,
        "Vishal" to 24,
        "Swaraj" to 22,
        "Rishu" to 21
    )
    
    //val sortByAge = { list: List<Pair<String, Int>> -> list.sortedBy { it.second } }
    
    val sortedPeople = { list: List<Pair<String, Int>> -> list.sortedBy { it.second } }(people)
    println(sortedPeople)
}
