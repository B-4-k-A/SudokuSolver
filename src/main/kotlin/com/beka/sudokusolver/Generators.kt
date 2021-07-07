package com.beka.sudokusolver

typealias Generator = (Int) -> Coordinate

fun rowCoordinateGenerator(rowNumber: Int): Generator = { index -> Coordinate(x = rowNumber, y = index) }
fun colCoordinateGenerator(colNumber: Int): Generator = { index -> Coordinate(x = index, y = colNumber) }
fun quadCoordinateGenerator(quadNumber: Int): Generator = { index ->
    val x = 3 * (quadNumber / 3) + index / 3
    val y = 3 * (quadNumber % 3) + index % 3
    Coordinate(x, y)
}