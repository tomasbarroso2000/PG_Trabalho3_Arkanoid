data class Location(val x: Double, val y: Double)

data class Velocity(val dx: Double, val dy: Double)

data class Vector2D(val x: Double, val y: Double)

operator fun Vector2D.plus(other: Vector2D) = Vector2D(this.x + other.x, this.y + other.y)

fun Location.toVector() = Vector2D(this.x, this.y)

fun Velocity.toVector() = Vector2D(dx, dy)

fun Vector2D.toLocation() = Location(this.x, this.y)

fun add(ball: Ball) = (ball.center.toVector() + ball.velocity.toVector()).toLocation()

fun Ball.detectCollisionWithRacket(game: Game) =
    this.center.x in game.racket.location.x..game.racket.location.x + game.racket.width &&
    this.center.y + this.radius in game.racket.location.y - game.racket.height/2..game.racket.location.y + game.racket.height/2 &&
    this.velocity.dy > 0

fun Ball.createBallWithRacketDeflection(racket: Racket) =
    Ball(
        this.center,
        Velocity(
            when{
                isBallInLeftExtremeArea(this,racket) -> this.velocity.dx - 3
                isBallInRightExtremeArea(this,racket) -> this.velocity.dx + 3
                isBallInLeftIntermediateArea(this,racket) -> this.velocity.dx - 1
                isBallInRightIntermediateArea(this,racket) -> this.velocity.dx + 1
                else-> this.velocity.dx
            },
            -this.velocity.dy
        ),
        this.radius,
        this.color
    )

fun Ball.wallDeflectionLocation(game: Game) = Location(
    if(this.velocity.dx < 0){
        this.center.x
    } else {
        if(game.area.width - this.radius < this.center.x) game.area.width - this.radius else this.center.x
    },
    if(this.velocity.dy < 0){
        this.center.y
    } else {
        if(game.area.height - this.radius < this.center.x) game.area.height - this.radius else this.center.y
    }
)

fun Ball.wallDeflectionVelocity(game: Game) = Velocity(
    (if(!this.isBallInGameAreaXBounds(game.area.width)) -this.velocity.dx else this.velocity.dx),
    (if(!this.isBallInGameAreaYBounds()) -this.velocity.dy else this.velocity.dy)
)

fun Ball.deflectOnWall(game: Game): Ball {

    return createBall(
        this.wallDeflectionLocation(game),
        this.wallDeflectionVelocity(game)
    )
}

fun Ball.move(game: Game): Ball{
    val newBall = createBall(
        add(this),
        this.velocity
    )
    return when{
        newBall.detectCollisionWithRacket(game) -> createBallWithRacketDeflection(game.racket)
        newBall.isBallInGameAreaBounds(game.area.width) -> newBall
        else -> newBall.deflectOnWall(game)
    }
}

fun Game.moveBalls(): List<Ball> {
    return this.balls.map{it.move(this)}.filter{it.center.y - it.radius < this.area.height || it.velocity.dy < 0}
}
