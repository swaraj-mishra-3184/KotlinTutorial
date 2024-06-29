class BankAccount(val accountNumber: String, var balance: Double) {

    fun deposit(amount: Double) {
        if (amount > 0) {
            balance += amount
        }
    }

    fun withdraw(amount: Double) {
        if (amount > 0 && amount <= balance) {
            balance -= amount
        }
    }

    fun checkBalance(): Double {
        return balance
    }
}

fun main() {
    val account = BankAccount("ABCD0123456789", 25000.0)
    account.withdraw(5000.0)
    account.deposit(7000.0)
    println("Account number: ${account.accountNumber}, Balance: ${account.checkBalance()}")
}
//Output: Account number: ABCD0123456789, Balance: 27000.0
