package ch5

data class Person(val name: String, val age: Int)

val sum = { x: Int, y: Int -> x + y }

val sum2 = { x: Int, y: Int ->
    println("$x and $y")
    x + y
}

fun printMessageWithPrefix(messages: Collection<String>, prefix: String) {
    messages.forEach {
        println("$prefix")
    }
}

fun printProblemCounts(responses: Collection<String>) {
    var clientErrors = 0
    var serverError = 0
    responses.forEach {
        if (it.startsWith("4")) {
            clientErrors++
        } else if (it.startsWith("5")) {
            serverError++
        }
    }
    println("$clientErrors and $serverError")
}

val p = Person("Bob", 11)
val personAgeFunc = Person::age
val personAgeFunc2 = p::age
fun main() {
    println(sum(1, 2)) // 3
    println(sum2(1, 2)) // 3
    val people = listOf(Person("Bob", 10), Person("Rob", 11))
    println(people.maxBy { it.age })
    println(personAgeFunc(p))
    println(personAgeFunc2())
}
