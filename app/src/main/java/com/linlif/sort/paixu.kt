package com.linlif

/**
 *
 * Created by linlif on 2020/5/8
 */

fun main() {


    var array = arrayOf(4, 3, 2, 1)

    sort(array)


}


fun sort(array: Array<Int>) {
    for (j in 0 until array.size - 1) {
        for (i in 0 until array.size - 1 - j) {
            var temp: Int
            if (array[i] > array[i + 1]) {
                temp = array[i]
                array[i] = array[i + 1]
                array[i + 1] = temp
            }
        }
    }
    for (i in array.indices) {
        println(array[i])
    }
}