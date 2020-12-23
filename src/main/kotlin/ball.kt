import kotlin.random.Random

const val GAME_MARGIN = 3.5
const val BALL_RADIUS = 7.0
private const val COLOR_BLUE = 0x0080FF
private const val DX_MIN = -6.0
private const val DX_MAX = 6.0
private const val DY_START = -4.0

data class Ball(
    val center: Location,
    val velocity: Velocity,
    val radius: Double,
    val color: Int
)

fun createBall(
    location: Location = Location(Random.nextDouble(0.0, CANVAS_WIDTH.toDouble()), CANVAS_HEIGHT + GAME_MARGIN),
    velocity: Velocity = Velocity(Random.nextDouble(DX_MIN,DX_MAX),DY_START)
) = Ball(location, velocity, BALL_RADIUS, COLOR_BLUE)

fun Ball.isBallInGameAreaXBounds(width: Double): Boolean =
    this.center.x - this.radius >= 0 && this.center.x + this.radius <= width

fun Ball.isBallInGameAreaYBounds() =
    this.center.y - this.radius >= 0

fun Ball.isBallInGameAreaBounds(width: Double): Boolean =
    this.isBallInGameAreaXBounds(width) && this.isBallInGameAreaYBounds()

