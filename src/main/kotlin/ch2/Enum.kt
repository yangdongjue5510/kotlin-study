package ch2

import ch2.Color.*
import java.time.Year

enum class Color(
    val r: Int, val g: Int, val b: Int
) {
    RED(255, 0, 0),
    ORANGE(255, 165, 0),
    YELLOW(255, 255, 0); // 반드시 끝에 세미콜론

    fun rgb() = (r * 256 + g) * 256 + b
}

fun getFruitNameOf(color: Color) =
    when (color) {
        RED -> "Apple"
        ORANGE -> "Orange"
        Color.YELLOW -> "Banana"
    }

fun getTemperatureOf(color: Color) =
    when (color) {
        RED, ORANGE -> "Hot"
        Color.YELLOW -> "warm"
    }

fun mix(c1: Color, c2: Color) =
    when (setOf(c1, c2)) {
        setOf(RED, YELLOW) -> ORANGE
        setOf(RED, ORANGE) -> RED
        else -> throw Exception("Dirty Color")
    }

fun mixOptimized(c1: Color, c2: Color) =
    when {
        (c1 == RED && c2 == YELLOW) ||
                (c1 == YELLOW && c2 == RED) -> ORANGE
        (c1 == RED && c2 == ORANGE) ||
                (c1 == ORANGE && c2 == RED) -> RED
        else -> throw Exception("Dirty Color")
    }

fun main(args: Array<String>) {
    println(Color.YELLOW.rgb())
    println(getFruitNameOf(Color.YELLOW))
}
