package ch8

import ch5.Person

fun doSomething(callback: (code: Int, content: String) -> Unit) {
    callback(1, "content")
}

fun doSomethingWithDefault(callback: ((code: Int, content: String) -> Unit)? = null) {
    callback?.invoke(1, "content")
        ?: run { println("input null") }
}

enum class OS {
    WINDOWS, MAC, IOS, ANDROID
}

data class SiteVisit(
    val path: String,
    val duration: Double,
    val os: OS
)

val log = listOf(
    SiteVisit("/", 1.0, OS.WINDOWS),
    SiteVisit("/hello", 2.0, OS.MAC),
    SiteVisit("/welcome", 3.0, OS.ANDROID),
    SiteVisit("/goodbye", 4.0, OS.ANDROID),
    SiteVisit("/welcome", 5.0, OS.IOS),
)

fun main() {
    doSomething { code, content -> println("code = $code, content = $content") }
    doSomethingWithDefault()
    doSomethingWithDefault({ code, content -> println("code = $code, content = $content") })

    val averageAndroidDuration = log
        .filter { it.os == OS.ANDROID }
        .map(SiteVisit::duration)
        .average()
    println(averageAndroidDuration)

    val averageMobileDuration = log
        .filter { it.os in setOf(OS.IOS, OS.ANDROID) }
        .map(SiteVisit::duration)
        .average()
    println(averageMobileDuration)
    println(log.averageDurationFor { it.os in setOf(OS.ANDROID, OS.IOS) })

    foo()

}

fun List<SiteVisit>.averageDurationFor(os: OS) =
    filter { it.os == os }
        .map(SiteVisit::duration)
        .average()

fun List<SiteVisit>.averageDurationFor(predicate: (SiteVisit) -> Boolean) =
    filter(predicate)
        .map(SiteVisit::duration)
        .average()

inline fun doSomething2(callback: () -> Unit) {
    println("start to do Something")
    callback()
    println("end of something")
}

fun foo() {
    println("it's foo function!")
    doSomething2 { println("do foo things~!") }
    println("end of foo function!")
}

val people = listOf(Person("Alice", 27), Person("Bob", 25))

fun lookForAlice(people: List<Person>) {
    for (person in people) {
        if (person.name == "Alice") {
            println("FOUND!!!")
            return
        }
    }
    println("Alice is not found...")
}

fun lookForAlice2(people: List<Person>) {
    people.forEach {
        if (it.name == "Alice") {
            println("FOUND!!")
            return
        }
    }
    println("Alice is not found...")
}

fun lookForAlice3(people: List<Person>) {
    people.forEach label@{
        if (it.name == "Alice") {
            println("FOUND!!")
            return@label
        }
    }
}

fun lookForAlice4(people: List<Person>) {
    people.forEach(fun (person) {
        if (person.name == "Alice") return
        println("${person.name} is not Alice")
    })
}
