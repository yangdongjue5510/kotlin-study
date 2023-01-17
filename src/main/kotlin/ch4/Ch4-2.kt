package ch4

class User(val nickName: String)

class User2 constructor(_nickName: String) {
    val nickName: String

    init {
        nickName = _nickName
    }
}

class User3(_nickName: String) {
    val nickName = _nickName
}

class User4(val nickName: String = "untitled")

open class Book

class GoodBook : Book()

class CannotConstructUser private constructor()

open class View {
    constructor(i: Int) {}
    constructor(s: String) {}
}

class GoodView : View {
    constructor(i: Int) : this(i.toString()) {}
    constructor(s: String) : super(s) {}
}

interface User5 {
    val nickName: String
}

class PrivateUser(override val nickName: String) : User5

class EmailUser(val email: String) : User5 {
    override val nickName: String
        get() = email.substringBefore('@')
}

class FacebookUser(val id: Int) : User5 {
    override val nickName = getFacebookName(id)
}

fun getFacebookName(id: Int) = id.toString()

interface User6 {
    val nickName: String
    val email: String
        get() = email.substringBefore('@')
}

class User7(val name: String) {
    var address = "undefined"
        set(_address) {
            println("$field -> $_address")
            field = _address
        }
}

class User8 {
    var name: String = "hi"
        private set
}

fun main() {
    User7("hi").address = "new"
    println(User4().nickName)
    println(User4(nickName = "klay").nickName)
}
