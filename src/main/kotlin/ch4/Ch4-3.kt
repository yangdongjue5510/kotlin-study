package ch4

import ch2.Person
import java.awt.Window
import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent
import java.awt.event.MouseListener
import java.io.File

class DelegatingCollection<T> : Collection<T> {
    private val innerList = arrayListOf<T>()

    override val size: Int get() = innerList.size
    override fun containsAll(elements: Collection<T>) = innerList.containsAll(elements)
    override fun contains(element: T) = innerList.contains(element)
    override fun isEmpty() = innerList.isEmpty()
    override fun iterator(): Iterator<T> = innerList.iterator()
}

class CountingSet<T>(
    val innerSet: MutableCollection<T> = HashSet()
) : MutableCollection<T> by innerSet {

    var addCount = 0

    override fun add(element: T): Boolean {
        addCount++
        return innerSet.add(element)
    }

    override fun addAll(elements: Collection<T>): Boolean {
        addCount += elements.size
        return innerSet.addAll(elements)
    }
}

object Payroll {
    val allEmployees = arrayListOf<Person>()

    fun doSomething() {}
}

object FileComparator : Comparator<File> {
    override fun compare(o1: File, o2: File) = o1.path.compareTo(o2.path, ignoreCase = true)
}

data class NamedPerson(private val name: String) {

    object InnerObject {
        fun hello(namedPerson: NamedPerson) {
            println("hello ${namedPerson.name}")
        }
    }
}

data class NamedPerson2(private val name: String) {
    companion object {
        fun hello(namedPerson: NamedPerson2) {
            println("hello ${namedPerson.name}")
        }
    }
}

class Man private constructor(val name: String) {
    companion object {
        fun create(name: String) = Man(name)
    }
}


interface Creatable<T> {
    fun of(name: String) : T
}

class Boy(val name: String) {
    companion object : Creatable<Boy> {
        override fun of(name: String) = Boy(name)
    }
}

fun <T> createSomething(name:String, creatable: Creatable<T>) = creatable.of(name)

// 비즈니스 모듈
open class Human(val id: Int) {
    companion object
}

/* 클라이언트 서버 통신 모듈 */
fun Human.Companion.fromJson(jsonValue: String) : Human {
    return Human(jsonValue.toInt())
}

fun main() {
    NamedPerson2.hello(NamedPerson2("Klay"))
    Man.create("Klay")
}

fun foo(window: Window) {
    var clickAmount = 0

    window.addMouseListener(object : MouseAdapter() {
        override fun mouseClicked(e: MouseEvent?) {
           clickAmount++
        }
    })
}
var listener = object : MouseAdapter() {
    override fun mouseClicked(e: MouseEvent?) {
        // logic...
    }

    override fun mousePressed(e: MouseEvent?) {
        // logic...
    }
}
