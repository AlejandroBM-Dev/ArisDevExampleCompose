package com.raiseralex.composeexample

class Example

open class Person constructor(val age: Int) {
    open fun talk(): String {
        val message = "I am a simple person aged $age."
        println(message)
        return message
    }
}

class Teacher constructor(age: Int) : Person(age = age) {
    override fun talk(): String {
        // super.talk()
        val message: String
        message = "I am teacher aged $age"
        println(message)
        return message
    }

    fun teach() {
        println("I teach")
    }
}

fun main(args: Array<String>) {
    val simplePerson = Person(age = 10)
    simplePerson.talk()

    var teacher = Teacher(age = 40)
    teacher.talk()
    teacher.teach()

    teacher = Teacher(age = 13)
    teacher.talk()
}
