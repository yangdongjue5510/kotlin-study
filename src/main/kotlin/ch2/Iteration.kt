package ch2

import java.util.*

fun fizzBuzz(i: Int) = when {
    i % 15 == 0 -> "FizzBuzz "
    i % 5 == 0 -> "Fizz "
    i % 3 == 0 -> "Buzz "
    else -> "$i "
}

fun exec() {
    val binaryReps = TreeMap<Char, String>()

    for (c in 'A'..'F') {
        val binary = Integer.toBinaryString(c.code)
        binaryReps[c] = binary
    }

    for ((letter, binary) in binaryReps) {
        println("$letter = $binary")
    }
}

fun isLetter(c: Char) = c in 'a'..'z' || c in 'A'..'Z'
fun isNotDigit(c: Char) = c !in '0'..'9'

fun recognize(c: Char) = when(c) {
    in 'a'..'z' -> "is lower case"
    in 'A'..'Z' -> "is upper case"
    in '0'..'9' -> "is numeric value"
    else -> "don't know"
}

fun main(args: Array<String>) {
    for (i in 1..100) {
        print(fizzBuzz(i))
    }
    println()
    for (i in 100 downTo 1 step 2) {
        print(fizzBuzz(i))
    }
    println()
    exec()
}
