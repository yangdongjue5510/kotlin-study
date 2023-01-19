package ch5

fun alphabet(): String {
    val result = StringBuilder()
    for (letter in 'a'..'z') {
        result.append(letter)
    }
    result.append("\n alphabet end~\n")
    return result.toString()
}

fun alphabet2(): String {
    return with(StringBuilder()) {
        for (letter in 'a'..'z') {
            append(letter)
        }
        append("\n alphabet end~ \n")
        toString()
    }
}

fun alphabet3(): String {
    return StringBuilder().apply {
        for (letter in 'a'..'z') {
            append(letter)
        }
        append("\n alphabet end~ \n")
    }.toString()
}

fun alphabet4(): String {
    return buildString {
        for (letter in 'a'..'z') {
            append(letter)
        }
        append("\n alphabet end~ \n")
    }
}

fun main() {
    print(alphabet())
}
