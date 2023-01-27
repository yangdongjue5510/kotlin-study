package ch7

import kotlin.reflect.KProperty

data class Point(var x: Int, var y: Int) : Comparable<Point> {
    override fun compareTo(other: Point): Int {
        return compareValuesBy(this, other, Point::x, Point::y)
    }
}

operator fun Point.plus(other: Point): Point {
    return Point(x + other.x, y + other.y)
}

operator fun Point.times(scale: Int): Point {
    return Point(x * scale, y * scale)
}

//operator fun Point.plusAssign(other: Point) {
//    this.x += other.x
//    this.y += other.y
//}

operator fun Point.unaryMinus(): Point {
    return Point(-x, -y)
}

operator fun Point.inc(): Point {
    return Point(++x, ++y)
}

operator fun Point.get(index: Int): Int {
    return when (index) {
        0 -> x
        1 -> y
        else -> throw IllegalArgumentException()
    }
}

operator fun Point.set(index: Int, value: Int) {
    when (index) {
        0 -> this.x = value
        1 -> this.y = value
        else -> throw IllegalArgumentException()
    }
}

operator fun Point.contains(other: Point): Boolean {
    return other.x <= x && other.y <= y
}

operator fun ClosedRange<Point>.iterator(): Iterator<Point> =
    object : Iterator<Point> {
        var current = start
        override fun hasNext(): Boolean = current <= endInclusive
        override fun next(): Point = current.apply { current = Point(current.x + 1, current.y + 1) }
    }

operator fun Point.component1() = x
operator fun Point.component2() = y

class Foo {
    var p: Int by Delegate()
}

class Delegate {
    operator fun getValue(foo: Foo, property: KProperty<*>): Int {
        TODO("Not yet implemented")
    }

    operator fun setValue(foo: Foo, property: KProperty<*>, i: Int) {
        TODO("Not yet implemented")
    }
}

class Person(val name: String) {
    private var _emails: List<String>? = null
    val emails: List<String>
        get() {
            if (_emails == null) _emails = loadEmail()
            return emails
        }
}

class Person2(val name: String) {
    val emails: List<String> by lazy { loadEmail() }
}

class Human {
    private val _attribute = hashMapOf<String, String>()
    fun setAttribute(attrName: String, value: String) {
        _attribute[attrName] = value
    }

    val name: String by _attribute
}


class Person3 {
    private val _attributes = hashMapOf<String, String>()

    fun setAttribute(attrName: String, value: String) {
        _attributes[attrName] = value
    }

    val name: String by _attributes
//        get() = _attributes["name"]!!
}

fun loadEmail(): List<String> {
    return ArrayList()
}

fun main() {
    var p1 = Point(1, 2)
    var p2 = Point(3, 4)

    //println(p1 + p2) // x = 4, y = 6
    println(p1 * 2) // x = 2, y = 4
    // p1 * 2는 컴파일 되지 않는다.
    p1 += p2
    println(p1)
    println(-p2)
    println(p2++)
    println(++p2)
    println(Point(3, 4) == Point(3, 4))
    println(Point(3, 4) <= Point(4, 3))

    val point = Point(1, 2)
    println(point[0]) // 1
    point[0] = 2
    println(point[0]) // 2

    println(Point(1, 1) in Point(3, 3)) // true
    val point2 = Point(1, 2)
    val (x, y) = point2
    println(x) // 1
    println(y) // 2

    val person3 = Person3()
    for ((name, value) in mapOf("name" to "Bob", "company" to "woowa")){
        person3.setAttribute(name, value)
    }
    println(person3.name)
}
