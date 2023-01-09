package ch3

import java.lang.IllegalArgumentException

val set = hashSetOf(1, 2, 3)
val list = arrayListOf(1, 2, 3)
val map = hashMapOf(1 to "hi", 2 to "ho")

fun <T> joinToString(
    collection: Collection<T>,
    separator: String = ":",
    prefix: String = "",
    postfix: String = ""
) : String {
    val result = StringBuilder(prefix)
    for ((index, element) in collection.withIndex()) {
        if (index > 0) result.append(separator)
        result.append(element)
    }
    result.append(postfix)
    return result.toString()
}

// 확장 함수와 확장 프로퍼티

fun String.lastChar(): Char = this[this.length - 1]

var StringBuilder.lastChar2: Char
    get() = get(length - 1)
    set(value) {
        this.setCharAt(length - 1, value)
    }

fun <T> Collection<T>.joinToString2(
    separator: String = ":",
    prefix: String = "",
    postfix: String = ""
) : String {
    val result = StringBuilder(prefix)
    for ((index, element) in withIndex()) {
        if (index > 0) result.append(separator)
        result.append(element)
    }
    result.append(postfix)
    return result.toString()
}

val map1 = mapOf(1.to("one"))
val map2 = mapOf(2 to "one")

fun main() {
    println("hello".lastChar())
    val list = listOf(1, 2, 3)
    println(joinToString(list, ":", "{", "}"))
    println(joinToString(prefix = "{", collection = list, separator = ":", postfix = "}"))
    println(joinToString(prefix = "{", collection = list, postfix= "}"))
    println(list.joinToString2(prefix = "{", postfix = "}"))

    val sb = StringBuilder("Kotlin?")
    sb.lastChar2 = '!'
    println(sb)

    val array = arrayOf(1, 2, 3)
    val listWithZero = listOf(0, *array)
    println(listWithZero)

    val line = "12.345-6.A"
    println(line.split("\\.|-".toRegex()))
    println(line.split(".", "-"))
}

class User(val id: Int, val name: String, val address: String)

fun saveUser(user: User) {
    if (user.name.isEmpty()) {
        throw IllegalArgumentException("${user.id} empty name" )
    }

    if (user.address.isEmpty()) {
        throw IllegalArgumentException("${user.id} empty email" )
    }
}

fun saveUser2(user: User) {
    fun validate(user: User, value: String, fieldName: String) {
        if (value.isEmpty()) {
            throw IllegalArgumentException("${user.id} empty $fieldName")
        }
    }
    validate(user, user.name, "Name")
    validate(user, user.address, "Address")
    // save logic
}

fun saveUser3(user: User) {
    fun validate(value: String, fieldName: String) {
        if (value.isEmpty()) {
            throw IllegalArgumentException("${user.id} empty $fieldName")
        }
    }
    validate(user.name, "Name")
    validate(user.address, "Address")
    // save logic
}

fun User.validateBeforeSave() {
    fun validate(value: String, fieldName: String) {
        if (value.isEmpty()) {
            throw IllegalArgumentException("$id empty $fieldName")
        }
    }
    validate(name, "Name")
    validate(address, "Address")
}

fun saveUser4(user: User) {
    user.validateBeforeSave()
    // save logic...
}
