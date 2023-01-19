package ch5

val list = listOf("a", "ab", "b")
val strings = listOf("abc", "def")
val people = listOf(Person("Bob", 10), Person("Rob", 11))

val printZeroTo100 = generateSequence(0) { it + 1}
    .takeWhile { it <= 100 }
    .forEach { println(it) }
fun main() {
    println(list.groupBy(String::first))
    println(strings.flatMap { it.toList() })
    val result = people.map(Person::name)
        .filter { it.startsWith("B") }
    people.asSequence()
        .map(Person::name)
        .filter { it.startsWith("B") }
    listOf(1,2,3,4).asSequence()
        .map { it*it }
        .find { it > 3 }
    //printZeroTo100

    fun compute(computation: Runnable) {
        computation.run()
    }
    // void compute(Runnable computation); 이란 자바코드가 있다고 가정
    compute { println("hi") }
    compute(object : Runnable {
        override fun run() {
           println("hi")
        }
    })
}

fun createAllRunnable() : Runnable {
    //람다는 안됨 return { println("GOOD!")}
    return Runnable { println("GOOD!") }
}
