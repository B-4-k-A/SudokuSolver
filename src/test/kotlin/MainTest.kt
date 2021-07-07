import com.beka.sudokusolver.*
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class MainTest {
    @Test
    fun `correct solution should return ok result`() {
        val input = """
            ..6..297.
            78.....12
            .2.9.8.45
            .14..9.3.
            89.536...
            3...217.9
            642..3..7
            ..189.2.4
            ...26.153
        """.trimIndent().asGameBoard()
        val solution = """
            45.31...8
            ..96453..
            1.3.7.6..
            2..78.5.6
            ..7...421
            .654...8.
            ...15.89.
            53...7.6.
            978..4...
        """.trimIndent().asGameBoard()
        Assertions.assertEquals(CheckOutCome.Ok, validateGame(input, solution))
    }

    @Test
    fun `incomplite solution should return incomplite result`() {
        val input = """
            ..6..297.
            78.....1.
            .2.9.8.45
            .14..9.3.
            89.536...
            3...217.9
            642..3..7
            ..189.2.4
            ...26.153
        """.trimIndent().asGameBoard()
        val solution = """
            45.31...8
            ..96453..
            1.3.7.6..
            2..78.5.6
            ..7...421
            .654...8.
            ...15.89.
            53...7.6.
            978..4...
        """.trimIndent().asGameBoard()
        Assertions.assertEquals(CheckOutCome.Incomplite, validateGame(input, solution))
    }

    @Test
    fun `failed solution should return failed result`() {
        val input = """
            ..6..297.
            78.....12
            .2.9.8.45
            .14..9.3.
            89.536...
            3...217.9
            642..3.17
            ..189.2.4
            ...26.153
        """.trimIndent().asGameBoard()
        val solution = """
            45.31...8
            ..96453..
            1.3.7.6..
            2..78.5.6
            ..7...421
            .654...8.
            ...15.89.
            53...7.6.
            978..4...
        """.trimIndent().asGameBoard()
        Assertions.assertEquals(CheckOutCome.Failed, validateGame(input, solution))
    }

    @Test
    fun `row generator should return coordinates in single row`() {
        val generator = rowCoordinateGenerator(rowNumber = 0)
        val generated = listOf(generator(1), generator(0), generator(100))
        Assertions.assertEquals(listOf(Coordinate(0, 1), Coordinate(0, 0), Coordinate(0, 100)), generated)
    }

    @Test
    fun `col generator should return coordinates in single column`() {
        val generator = colCoordinateGenerator(colNumber = 1)
        val generated = listOf(generator(1), generator(0), generator(100))
        Assertions.assertEquals(listOf(Coordinate(1, 1), Coordinate(0, 1), Coordinate(100, 1)), generated)
    }

    @Test
    fun `quad generator should return coordinates in single area`() {
        val generator = quadCoordinateGenerator(0)
        val generated = listOf(generator(1), generator(8), generator(5))
        Assertions.assertEquals(listOf(Coordinate(0, 1), Coordinate(2, 2), Coordinate(1, 2)), generated)
    }
}