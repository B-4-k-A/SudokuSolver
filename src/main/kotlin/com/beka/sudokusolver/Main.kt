@file:JvmName("Main")

package com.beka.sudokusolver

import java.io.File

fun main() {
    val input = readInput(".\\src\\main\\resources\\input")
    val solution = readInput(".\\src\\main\\resources\\answer")
    val result = validateGame(input, solution)
    println(result)
}

fun readInput(filePath: String): Map<Coordinate, Int> =
    File(filePath)
        .readLines()
        .withIndex()
        .flatMap { indexedValue ->
            val xCoordinate = indexedValue.index
            indexedValue.value.toCharArray().withIndex()
                .filter { indexedChar -> indexedChar.value != '.' }
                .map { indexedChar ->
                    val yCoordinate = indexedChar.index
                    val coordinate = Coordinate(xCoordinate, yCoordinate)
                    val number = Character.getNumericValue(indexedChar.value)
                    coordinate to number
                }
        }
        .toMap()
