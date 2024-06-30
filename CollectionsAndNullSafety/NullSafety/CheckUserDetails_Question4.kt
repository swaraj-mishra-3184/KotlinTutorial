data class User(val name: String?, val email: String?)

fun printUserDetails(user: User) {
    if (user.name == null || user.email == null) {
        println("Incomplete User")
    } else {
        println("Name: ${user.name}, Email: ${user.email}")
    }
}

fun main() {
    val user = User("Lucky", null)
    printUserDetails(user)  
}
// Output: Incomplete User