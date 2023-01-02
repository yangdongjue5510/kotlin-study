package ch2

import java.util.StringJoiner

//class Person(val name: String)

class Person(
    val name: String,
    var isMarried: Boolean
)

fun main(args: Array<String>) {
    val person = Person("yang", false)
    println(person.name)
    person.isMarried = true
    println(person.isMarried)
}

class Rectangle(val height: Int, val width: Int) {
    val isSquare: Boolean
        get() {
            return height == width
        }

    val isSquare2: Boolean get() = height == width
}
