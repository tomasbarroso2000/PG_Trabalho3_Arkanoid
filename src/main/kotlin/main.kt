import pt.isel.canvas.*

fun main(){
    onStart {
        val canvas = Canvas(CANVAS_WIDTH, CANVAS_HEIGHT, BLACK)
        var game = createGame()

        canvas.onMouseMove {
            game = game.updateGame(game.racket, it.x.toDouble())
        }

        canvas.onTimeProgress(10){
            //game = game.updateGame()
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