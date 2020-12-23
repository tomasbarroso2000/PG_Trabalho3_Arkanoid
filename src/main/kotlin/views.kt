import pt.isel.canvas.*

private const val THICKNESS = 0
private const val COLOR_LIGHT_RED = 0xFF6666
private const val FONT_SIZE = 35

private fun Game.drawCounter(canvas: Canvas){
    val totalPoints = this.totalPoints
    canvas.drawText(
        (CANVAS_WIDTH/2 - RACKET_EXTREME_AREA_WIDTH).toInt(),
        (CANVAS_HEIGHT - RACKET_MARGIN_BOTTOM/4).toInt(),
        "$totalPoints",
        WHITE,
        FONT_SIZE
    )
}

private fun Racket.drawRacketArea(canvas: Canvas, x: Double = this.location.x, y: Double = this.location.y, width: Double = this.width, height: Double = this.height/2, color: Int){
    canvas.drawRect(x.toInt(), y.toInt(), width.toInt(), height.toInt(), color, THICKNESS)
}

private fun Racket.drawRacketBase(canvas: Canvas){
    this.drawRacketArea(canvas = canvas, color = WHITE, height = this.height)
}

private fun Racket.drawRacketIntermediateArea(canvas: Canvas){
    this.drawRacketArea(
        canvas = canvas,
        x = this.location.x + RACKET_EXTREME_AREA_WIDTH,
        width = RACKET_INTERMEDIATE_AREA_WIDTH,
        color = COLOR_LIGHT_RED
    )
    this.drawRacketArea(
        canvas = canvas,
        x = this.location.x + RACKET_CENTRAL_AREA_WIDTH + RACKET_INTERMEDIATE_AREA_WIDTH + RACKET_EXTREME_AREA_WIDTH,
        width = RACKET_INTERMEDIATE_AREA_WIDTH,
        color = COLOR_LIGHT_RED
    )
}

private fun Racket.drawRacketExtremeArea(canvas: Canvas){
    this.drawRacketArea(
        canvas = canvas,
        width = RACKET_EXTREME_AREA_WIDTH,
        color = RED
    )
    this.drawRacketArea(
        canvas = canvas,
        x = this.location.x + RACKET_CENTRAL_AREA_WIDTH + 2*RACKET_INTERMEDIATE_AREA_WIDTH + RACKET_EXTREME_AREA_WIDTH,
        width = RACKET_EXTREME_AREA_WIDTH,
        color = RED
    )
}

private fun Racket.drawRacket(canvas: Canvas){
    this.drawRacketBase(canvas)
    this.drawRacketIntermediateArea(canvas)
    this.drawRacketExtremeArea(canvas)
}

fun Ball.drawBall(canvas: Canvas){
    canvas.drawCircle(this.center.x.toInt(), this.center.y.toInt(), this.radius.toInt(), this.color, 0)
}

fun Game.drawBalls(canvas: Canvas){
    this.balls.forEach {it.drawBall(canvas)}
}

fun Game.drawGame(canvas: Canvas){
    canvas.erase()
    this.racket.drawRacket(canvas)
    this.drawBalls(canvas)
    this.drawCounter(canvas)
    this.drawBlocks(canvas)
}

fun Block.drawBlock(canvas: Canvas){
    canvas.drawRect(this.location.x.toInt(), this.location.y.toInt(), this.width, this.height, this.color.toInt(),0)
    canvas.drawRect(this.location.x.toInt(), this.location.y.toInt(), this.width, this.height, BLACK,2)
}

fun Game.drawBlocks(canvas: Canvas){
    this.blocks.forEach { it.drawBlock(canvas) }
}

