package com.linlif

/**
 *
 * Created by linlif on 2020/5/22
 */

fun main(){


    op()
}
class Parent {
    var name = ""

    override fun toString(): String {
        return "Parent(name='$name')"
    }
}

class Child {
    var name = ""
    override fun toString(): String {
        return "Child(name='$name')"
    }

}

fun op() {
    var name = "op Method!!!"
    var age = 19

    var parent = Parent()

    var child = Child()



   var sss=  parent.takeUnless {

        it.name = "opppppo Method"
        true
    }

    System.out.println("name : $sss , age : $age , parent.name : ${parent.name}")
}