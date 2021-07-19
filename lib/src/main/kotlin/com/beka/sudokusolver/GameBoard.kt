package com.beka.sudokusolver

typealias GameBoard = Map<Coordinate, Int>

fun validateGame(input: GameBoard, solution: GameBoard): CheckOutCome {
    var result = CheckOutCome.Ok
    for (i in 0..8) {
        val rowCheckOutCome = validateSimilar(input, solution, rowCoordinateGenerator(rowNumber = i))
        if (rowCheckOutCome != CheckOutCome.Ok) {
            result = rowCheckOutCome
            break
        }
        val columnCheckOutCome = validateSimilar(input, solution, colCoordinateGenerator(colNumber = i))
        if (columnCheckOutCome != CheckOutCome.Ok) {
            result = columnCheckOutCome
            break
        }
        val quantCheckOutCome = validateSimilar(input, solution, quadCoordinateGenerator(quadNumber = i))
        if (quantCheckOutCome != CheckOutCome.Ok) {
            result = quantCheckOutCome
            break
        }
    }
    return result
}


fun validateSimilar(
    input: GameBoard,
    solution: GameBoard,
    coordinateGenerator: Generator
): CheckOutCome {
    var i = 0
    while (i < 8) {
        val checkedCoordinate = coordinateGenerator(i)
        val checkedValue = input[checkedCoordinate] ?: solution[checkedCoordinate] ?: return CheckOutCome.Incomplite
        var j = i + 1
        while (j < 9) {
            val internalCoordinate = coordinateGenerator(j)
            val internalValue =
                input[internalCoordinate] ?: solution[internalCoordinate] ?: return CheckOutCome.Incomplite
            if (checkedValue == internalValue) {
                return CheckOutCome.Failed
            }
            j++
        }
        i++
    }
    return CheckOutCome.Ok
}