package ch6

import ch5.Person

val s: String? = null

fun main() {
    val upperS = s?.uppercase()
    val result: String = s?.uppercase() ?: "it's null"
    sayHello(null)
    sayHello("Tom")

    val manitto = Manitto()
    manitto.setManitto(Person("Bob", 11))
    manitto.hello()

    var str: String? = "hey"
    str.printHello()
    str = null
    str.printHello()
    printHashCode(null)

    val address = Company(null).address ?: fail("no address")
    println(address.length)
}

class Company(val address: String?)

fun fail(message: String) : Nothing {
    throw IllegalStateException(message)
}
fun equals(o1: Any?, o2: Any?): Boolean {
    val person1: Person = o1 as? Person ?: return false
    val person2: Person = o2 as? Person ?: return false
    return person1.name == person2.name && person1.age == person2.age
}

fun sayHello(name: String?) {
    name?.let {
        println("hi my name is $name")
    }
}

class Manitto {
    private lateinit var manitto: Person

    fun setManitto(person: Person) {
        this.manitto = person
    }

    fun hello() = println("hi my name is ${manitto.name}")
}

fun String?.printHello() {
    if (this == null) println("it's null") else println("hello $this")
}

fun <T> printHashCode(t: T) {
    println(t?.hashCode())
}

fun <T: Any> printHashCode2(t: T) {
    println(t.hashCode())
}
