class Person(val name: String, val age: Int)

fun sortPersons(persons: List<Person>): List<Person> {
    val personsCopy = persons.toMutableList()

    for (i in 0 until personsCopy.size - 1) {
        for (j in 0 until personsCopy.size - i - 1) {
            val p1 = personsCopy[j]
            val p2 = personsCopy[j + 1]

            if (p1.age > p2.age || (p1.age == p2.age && p1.name > p2.name)) {
                personsCopy[j] = p2
                personsCopy[j + 1] = p1
            }
        }
    }

    return personsCopy
}

fun main() {
    val persons = listOf(
        Person("Swaraj", 21),
        Person("Raj", 23),
        Person("Vishal", 22),
        Person("Rishu", 21),
        Person("Rounak", 22)
    )

    val sortedPersons = sortPersons(persons)

    for (person in sortedPersons) {
        println("Name: ${person.name}, Age: ${person.age}")
    }
}
/*
Output:
Name: Rishu, Age: 21
Name: Swaraj, Age: 21
Name: Rounak, Age: 22
Name: Vishal, Age: 22
Name: Raj, Age: 23
 */