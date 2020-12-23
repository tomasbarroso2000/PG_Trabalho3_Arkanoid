import pt.isel.canvas.*

fun main(){
    onStart {
        val canvas = Canvas(CANVAS_WIDTH, CANVAS_HEIGHT, BLACK)
        var game = createGame(canvas)

        canvas.onMouseMove {
            game = game.updateGame(game.racket, it.x.toDouble())
            if(game.balls.size == 6 && game.balls[game.balls.size-1].velocity.dx == 0.0 && game.balls[game.balls.size-1].velocity.dy == 0.0) game = game.placeBallInRacket()
        }

        canvas.onMouseDown {
            if(game.isBallPlacedInRacket()){
                val ball = createBall(game.balls[game.balls.size-1].center, Velocity(game.balls[game.balls.size-1].velocity.dx, DY_START))
                game = game.updateGame(game.balls - game.balls[game.balls.size-1] + ball)
            }
            else{
                if(game.balls[game.balls.size-1].velocity.dx == 0.0 && game.balls[game.balls.size-1].velocity.dy == 0.0){
                    val ball = createBall(location = Location(x = (CANVAS_WIDTH/2).toDouble(), y = CANVAS_HEIGHT - RACKET_MARGIN_BOTTOM - RACKET_HEIGHT), velocity = Velocity(0.0,0.0))
                    game = Game(game.area, game.balls - game.balls[game.balls.size-1] + ball, game.racket, game.blocks, game.totalPoints)
                    game = game.placeBallInRacket()
                }
            }
        }

        canvas.onTimeProgress(10){
            game = game.updateGame()
            game.drawGame(canvas)
        }

        canvas.onTime(6000){
            canvas.onTimeProgress(10){
                if (game.balls.isEmpty()) canvas.close()
            }
        }
    }

    onFinish {
        println("Bye thanks for playing!")
    }

}