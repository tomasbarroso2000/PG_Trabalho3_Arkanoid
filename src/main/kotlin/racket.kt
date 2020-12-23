const val RACKET_CENTRAL_AREA_WIDTH = 10.0
const val RACKET_EXTREME_AREA_WIDTH = 10.0
const val RACKET_INTERMEDIATE_AREA_WIDTH = 15.0
const val RACKET_MARGIN_BOTTOM = 60.0
const val RACKET_WIDTH = 60.0
const val RACKET_HEIGHT = 10.0

data class Racket(
    val location: Location,
    val width: Double,
    val height: Double
)

data class Line(val start: Location, val end: Location)

fun createRacket(
    x: Double = (CANVAS_WIDTH - RACKET_WIDTH)/2,
    y: Double = (CANVAS_HEIGHT - RACKET_MARGIN_BOTTOM)
): Racket = Racket(Location(x,y),RACKET_WIDTH,RACKET_HEIGHT)

private fun isRacketInBounds(racket: Racket): Boolean =
    racket.location.x - racket.width/2 >= 0 && racket.location.x <= CANVAS_WIDTH - RACKET_WIDTH/2

private fun placeRacketInBounds(racket: Racket): Racket =
    if(racket.location.x - racket.width/2 < 0)
        Racket(
            Location(0.0, racket.location.y),
            racket.width,
            racket.height
        )
    else
        Racket(
            Location(CANVAS_WIDTH - racket.width, racket.location.y),
            racket.width,
            racket.height
        )

/**
 * Gets the start and end location of the left intermediate area of the racket
 * @param racket
 * @return line with start and end location of that area
 */
private fun getRacketLeftIntermediateArea(racket: Racket): Line =
    Line(
        Location(racket.location.x + RACKET_EXTREME_AREA_WIDTH  + racket.width/2,racket.location.y - racket.height/2),
        Location(racket.location.x + RACKET_EXTREME_AREA_WIDTH + RACKET_INTERMEDIATE_AREA_WIDTH,racket.location.y - racket.height/2)
    )

/**
 * Checks if the ball is in the left intermediate area of the racket
 * @param ball
 * @param racket
 * @return whatever the ball is in the specified area
 */
fun isBallInLeftIntermediateArea(ball: Ball, racket: Racket): Boolean{
    val line = getRacketLeftIntermediateArea(racket)
    return ball.center.x >= line.start.x && ball.center.x < line.end.x
}

/**
 * Gets the start and end location of the right intermediate area of the racket
 * @param racket
 * @return line with start and end location of that area
 */
private fun getRacketRightIntermediateArea(racket: Racket): Line =
    Line(
        Location(racket.location.x + RACKET_EXTREME_AREA_WIDTH + RACKET_INTERMEDIATE_AREA_WIDTH + RACKET_CENTRAL_AREA_WIDTH  + racket.width/2,racket.location.y - racket.height/2),
        Location(racket.location.x + RACKET_EXTREME_AREA_WIDTH + RACKET_INTERMEDIATE_AREA_WIDTH + RACKET_CENTRAL_AREA_WIDTH + RACKET_INTERMEDIATE_AREA_WIDTH,racket.location.y - racket.height/2)
    )

/**
 * Checks if the ball is in the right intermediate area of the racket
 * @param ball
 * @param racket
 * @return whatever the ball is in the specified area
 */
fun isBallInRightIntermediateArea(ball: Ball, racket: Racket): Boolean{
    val line = getRacketRightIntermediateArea(racket)
    return ball.center.x > line.start.x && ball.center.x <= line.end.x
}

/**
 * Gets the start and end location of the left extreme area of the racket
 * @param racket
 * @return line with start and end location of that area
 */
private fun getRacketLeftExtremeArea(racket: Racket): Line =
    Line(
        Location(racket.location.x,racket.location.y + racket.height/2),
        Location(racket.location.x + RACKET_EXTREME_AREA_WIDTH,racket.location.y - racket.height/2)
    )

/**
 * Checks if the ball is in the left extreme area of the racket
 * @param ball
 * @param racket
 * @return whatever the ball is in the specified area
 */
fun isBallInLeftExtremeArea(ball: Ball, racket: Racket): Boolean{
    val line = getRacketLeftExtremeArea(racket)
    return ball.center.x >= line.start.x && ball.center.x < line.end.x
}

/**
 * Gets the start and end location of the right extreme area of the racket
 * @param racket
 * @return line with start and end location of that area
 */
private fun getRacketRightExtremeArea(racket: Racket): Line =
    Line(
        Location(racket.location.x + RACKET_EXTREME_AREA_WIDTH + RACKET_INTERMEDIATE_AREA_WIDTH + RACKET_CENTRAL_AREA_WIDTH + RACKET_INTERMEDIATE_AREA_WIDTH,racket.location.y - racket.height/2),
        Location(racket.location.x + racket.width, racket.location.y - racket.height/2)
    )

/**
 * Checks if the ball is in the right extreme area of the racket
 * @param ball
 * @param racket
 * @return whatever the ball is in the specified area
 */
fun isBallInRightExtremeArea(ball: Ball, racket: Racket): Boolean{
    val line = getRacketRightExtremeArea(racket)
    return ball.center.x > line.start.x && ball.center.x <= line.end.x
}

/**
 * When the racket moves, accordingly to its new location, creates a new racket
 * with that location or a corrected one if its not in bounds
 * @param racket
 * @return new racket
 */
fun adjustRacket(racket: Racket): Racket = when{
    isRacketInBounds(racket) -> createRacket(racket.location.x - RACKET_WIDTH/2, racket.location.y)
    else -> placeRacketInBounds(racket)
}