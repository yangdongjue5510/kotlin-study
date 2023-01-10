package ch4

import java.io.Serializable

interface Clickable {
    fun click()

    fun methodImpl() = println("implemented Method in interface.")
}


interface Focusable {
    fun focus()

    fun methodImpl() = println("implemented too!")
}

class Clicker : Clickable, Focusable {
    override fun click() = println("click!")
    override fun focus() = println("focus!")
    override fun methodImpl() {
        super<Focusable>.methodImpl()
        super<Clickable>.methodImpl()
    }
}

open class RichButton: Clickable {

    fun cannotOverride() {}
    open fun animate() {}

    override fun click() = print("rich click")
}

open class TalkativeButton  {
    private fun hello() = {}
    protected fun bye() = {}
}

fun TalkativeButton.doSomething() {
}

class Outer {
    inner class Inner {
        fun getOuterReference() : Outer = this@Outer
    }
}

sealed class Expr {
    class Num : Expr()
    class Sum : Expr()
}

fun eval(e: Expr) : Int =
    when (e) {
        is Expr.Num -> 1
        is Expr.Sum -> 2
    }
