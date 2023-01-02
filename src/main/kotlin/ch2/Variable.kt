package ch2

import java.util.Arrays

val statement = "중요한 문장입니다."
val number = 1
val numberWithType: Int = 1

// 값을 뜻하는 value - 초기화 이후 변경 불가
val value = 1

// 변수를 뜻하는 variable - 초기화 이후 변경 가능
var variable = 1

fun main(args: Array<String>) {
    val value : Int
    value =2
}

fun doMessage(input : String) {
    val message : String
    if (input.length == 0) {
        message = "빈 문자열 전달받음."
        // 연산...
    }
    else {
        message = input + " 전달받음"
        // 연산...
    }
}

fun stringTemplate(input: String) {
    val name = input.ifEmpty { "Kotlin" }
    println("Hello $name!")
    println("HELLO ${name.uppercase()}")
}
