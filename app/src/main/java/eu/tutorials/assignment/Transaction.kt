package eu.tutorials.assignment

data class Transaction(
    val amount: String,
    val transactionType: String,
    val transactionDetails: String,
    val isCompleted: Boolean,
    val grams: String
)

val transactionsToday = listOf(
    Transaction("₹ 20", "Manual Buy", "7:00 PM • Sep 18", true, "0.0045 gms"),
    Transaction("₹ 200", "Manual Buy", "7:00 PM • Sep 18", false, "0.0045 gms")
)

val transactionsYesterday = listOf(
    Transaction("₹ 649", "Manual Buy", "7:00 PM • Sep 18", true, "0.0045 gms"),
    Transaction("₹ 20", "Manual Buy", "7:00 PM • Sep 18", false, "0.0045 gms")
)

val transactions4Oct = listOf(
    Transaction("₹ 649", "Manual Buy", "7:00 PM • Sep 18", true, "0.0045 gms"),
    Transaction("₹ 20", "Manual Buy", "7:00 PM • Sep 18", false, "0.0045 gms")
)
