import pt.isel.canvas.Canvas

const val CANVAS_WIDTH = 13 * BLOCK_WIDTH
const val CANVAS_HEIGHT = 600

data class Area(val width: Double, val height: Double)

data class Game(val area: Area, val balls:List<Ball>, val racket:Racket, val blocks:List<Block> = listOf(), val totalPoints: Int)

private fun createArea(): Area =
    Area(CANVAS_WIDTH.toDouble(), CANVAS_HEIGHT.toDouble())

fun createGame(canvas: Canvas): Game{
    val area = createArea()
    val racket = createRacket()

    return Game(area, initializeBalls(), racket, initializeBlocks(), 0)
}

fun Game.updateGame(racket: Racket, x: Double): Game{
    val newRacket = createRacket(x, racket.location.y)
    return Game(this.area,this.balls,adjustRacket(newRacket), this.blocks, this.totalPoints)
}

fun Game.updateGame(list: List<Ball>): Game =
    Game(this.area, list, this.racket, this.blocks, this.totalPoints)

fun Game.updateGame() = Game(this.area,this.moveBalls(), this.racket, this.blocks, this.totalPoints)

fun initializeBalls(): List<Ball> {
    val ball1 = createBall(location = Location(x = 1 * 20.0, y = CANVAS_HEIGHT - 15.0), velocity = Velocity(0.0,0.0))
    val ball2 = createBall(location = Location(x = 2 * 20.0, y = CANVAS_HEIGHT - 15.0), velocity = Velocity(0.0,0.0))
    val ball3 = createBall(location = Location(x = 3 * 20.0, y = CANVAS_HEIGHT - 15.0), velocity = Velocity(0.0,0.0))
    val ball4 = createBall(location = Location(x = 4 * 20.0, y = CANVAS_HEIGHT - 15.0), velocity = Velocity(0.0,0.0))
    val ball5 = createBall(location = Location(x = 5 * 20.0, y = CANVAS_HEIGHT - 15.0), velocity = Velocity(0.0,0.0))
    val ball6 = createBall(location = Location(x = (CANVAS_WIDTH/2).toDouble(), y = CANVAS_HEIGHT - RACKET_MARGIN_BOTTOM - RACKET_HEIGHT), velocity = Velocity(0.0,0.0))

    return listOf(ball1, ball2, ball3, ball4, ball5, ball6)
}

fun Game.placeBallInRacket(): Game {
    val ball = createBall(location = Location(x = this.racket.location.x + this.racket.width/2, y = this.racket.location.y - racket.height), velocity = Velocity(0.0,0.0))
    return Game(this.area, this.balls - this.balls[this.balls.size-1] + ball, this.racket, this.blocks, this.totalPoints)
}

fun Game.isBallPlacedInRacket(): Boolean =
    this.balls[this.balls.size-1].center.x == this.racket.location.x + this.racket.width/2
            && this.balls[this.balls.size-1].velocity.dy == 0.0
            && this.balls[this.balls.size-1].velocity.dx == 0.0


















