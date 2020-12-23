import pt.isel.canvas.*

const val BLOCK_WIDTH = 32
const val BLOCK_HEIGHT = 15
private const val NORMAL_BLOCKS_MAX_HITS = 1
private const val SILVER_BLOCKS_MAX_HITS = 2
private const val GOLDEN_BLOCKS_MAX_HITS = -1
private const val WHITE_BLOCK_POINT = 1
private const val ORANGE_BLOCK_POINT = 2
private const val CYAN_BLOCK_POINT = 3
private const val GREEN_BLOCK_POINT = 4
private const val RED_BLOCK_POINT = 6
private const val BLUE_BLOCK_POINT = 7
private const val MAGENTA_BLOCK_POINT = 8
private const val YELLOW_BLOCK_POINT = 9
private const val ORANGE_COLOR = 0xFF8000
private const val SILVER_COLOR = 0xC0C0C0
private const val GOLDEN_COLOR = 0xCCCC00

enum class Color {
    WHITE,
    ORANGE,
    CYAN,
    GREEN,
    RED,
    BLUE,
    MAGENTA,
    YELLOW,
    SILVER,
    GOLDEN
}

data class Block(
    val location: Location,
    val width: Int = BLOCK_WIDTH,
    val height: Int = BLOCK_HEIGHT,
    val color: Color,
    val maxHits: Int,
    val points: Int
)

fun createBlock(color: Color, location: Location) =
    when(color){
        Color.WHITE -> Block(location = location, color = color, maxHits = NORMAL_BLOCKS_MAX_HITS, points = WHITE_BLOCK_POINT)
        Color.ORANGE -> Block(location = location, color = color, maxHits = NORMAL_BLOCKS_MAX_HITS, points = ORANGE_BLOCK_POINT)
        Color.CYAN -> Block(location = location, color = color, maxHits = NORMAL_BLOCKS_MAX_HITS, points = CYAN_BLOCK_POINT)
        Color.GREEN -> Block(location = location, color = color, maxHits = NORMAL_BLOCKS_MAX_HITS, points = GREEN_BLOCK_POINT)
        Color.RED -> Block(location = location, color = color, maxHits = NORMAL_BLOCKS_MAX_HITS, points = RED_BLOCK_POINT)
        Color.BLUE -> Block(location = location, color = color, maxHits = NORMAL_BLOCKS_MAX_HITS, points = BLUE_BLOCK_POINT)
        Color.MAGENTA -> Block(location = location, color = color, maxHits = NORMAL_BLOCKS_MAX_HITS, points = MAGENTA_BLOCK_POINT)
        Color.YELLOW -> Block(location = location, color = color, maxHits = NORMAL_BLOCKS_MAX_HITS, points = YELLOW_BLOCK_POINT)
        Color.SILVER -> Block(location = location, color = color, maxHits = SILVER_BLOCKS_MAX_HITS, points = 0)
        Color.GOLDEN -> Block(location = location, color = color, maxHits = GOLDEN_BLOCKS_MAX_HITS, points = 0)
    }

fun Color.toInt() = when(this){
    Color.WHITE -> WHITE
    Color.ORANGE -> ORANGE_COLOR
    Color.CYAN -> CYAN
    Color.GREEN -> GREEN
    Color.RED -> RED
    Color.BLUE -> BLUE
    Color.MAGENTA -> MAGENTA
    Color.YELLOW -> YELLOW
    Color.SILVER -> SILVER_COLOR
    Color.GOLDEN -> GOLDEN_COLOR
}

fun createBlocksLeftSection(): List<Block>{

    //YELLOW BLOCKS
    val yB1 = createBlock(Color.YELLOW,Location(1*BLOCK_WIDTH.toDouble(),3*BLOCK_HEIGHT.toDouble()))
    val yB2 = createBlock(Color.YELLOW,Location(2*BLOCK_WIDTH.toDouble(),3*BLOCK_HEIGHT.toDouble()))
    val yB3 = createBlock(Color.YELLOW,Location(3*BLOCK_WIDTH.toDouble(),3*BLOCK_HEIGHT.toDouble()))

    //MAGENTA BLOCKS
    val mB1 = createBlock(Color.MAGENTA,Location(1*BLOCK_WIDTH.toDouble(),4*BLOCK_HEIGHT.toDouble()))
    val mB2 = createBlock(Color.MAGENTA,Location(2*BLOCK_WIDTH.toDouble(),4*BLOCK_HEIGHT.toDouble()))
    val mB3 = createBlock(Color.MAGENTA,Location(3*BLOCK_WIDTH.toDouble(),4*BLOCK_HEIGHT.toDouble()))

    //BLUE BLOCKS
    val bB1 = createBlock(Color.BLUE,Location(1*BLOCK_WIDTH.toDouble(),5*BLOCK_HEIGHT.toDouble()))
    val bB2 = createBlock(Color.BLUE,Location(2*BLOCK_WIDTH.toDouble(),5*BLOCK_HEIGHT.toDouble()))
    val bB3 = createBlock(Color.BLUE,Location(3*BLOCK_WIDTH.toDouble(),5*BLOCK_HEIGHT.toDouble()))

    //RED BLOCKS
    val rB1 = createBlock(Color.RED,Location(1*BLOCK_WIDTH.toDouble(),6*BLOCK_HEIGHT.toDouble()))
    val rB2 = createBlock(Color.RED,Location(2*BLOCK_WIDTH.toDouble(),6*BLOCK_HEIGHT.toDouble()))
    val rB3 = createBlock(Color.RED,Location(3*BLOCK_WIDTH.toDouble(),6*BLOCK_HEIGHT.toDouble()))

    //GREEN BLOCKS
    val gB1 = createBlock(Color.GREEN,Location(1*BLOCK_WIDTH.toDouble(),7*BLOCK_HEIGHT.toDouble()))
    val gB2 = createBlock(Color.GREEN,Location(2*BLOCK_WIDTH.toDouble(),7*BLOCK_HEIGHT.toDouble()))
    val gB3 = createBlock(Color.GREEN,Location(3*BLOCK_WIDTH.toDouble(),7*BLOCK_HEIGHT.toDouble()))

    //CYAN BLOCKS
    val cB1 = createBlock(Color.CYAN,Location(1*BLOCK_WIDTH.toDouble(),8*BLOCK_HEIGHT.toDouble()))
    val cB2 = createBlock(Color.CYAN,Location(2*BLOCK_WIDTH.toDouble(),8*BLOCK_HEIGHT.toDouble()))
    val cB3 = createBlock(Color.CYAN,Location(3*BLOCK_WIDTH.toDouble(),8*BLOCK_HEIGHT.toDouble()))

    //ORANGE BLOCKS
    val oB1 = createBlock(Color.ORANGE,Location(1*BLOCK_WIDTH.toDouble(),9*BLOCK_HEIGHT.toDouble()))
    val oB2 = createBlock(Color.ORANGE,Location(2*BLOCK_WIDTH.toDouble(),9*BLOCK_HEIGHT.toDouble()))
    val oB3 = createBlock(Color.ORANGE,Location(3*BLOCK_WIDTH.toDouble(),9*BLOCK_HEIGHT.toDouble()))

    //WHITE BLOCKS
    val wB1 = createBlock(Color.WHITE,Location(1*BLOCK_WIDTH.toDouble(),10*BLOCK_HEIGHT.toDouble()))
    val wB2 = createBlock(Color.WHITE,Location(2*BLOCK_WIDTH.toDouble(),10*BLOCK_HEIGHT.toDouble()))
    val wB3 = createBlock(Color.WHITE,Location(3*BLOCK_WIDTH.toDouble(),10*BLOCK_HEIGHT.toDouble()))

    return listOf(
        yB1,yB2,yB3,
        mB1,mB2,mB3,
        bB1,bB2,bB3,
        rB1,rB2,rB3,
        gB1,gB2,gB3,
        cB1,cB2,cB3,
        oB1,oB2,oB3,
        wB1,wB2,wB3
    )
}

fun createBlocksMiddleSection(): List<Block>{
    //FIRST LINE
    val yB1 = createBlock(Color.WHITE,Location(5*BLOCK_WIDTH.toDouble(),3*BLOCK_HEIGHT.toDouble()))
    val yB2 = createBlock(Color.GOLDEN,Location(6*BLOCK_WIDTH.toDouble(),3*BLOCK_HEIGHT.toDouble()))
    val yB3 = createBlock(Color.WHITE,Location(7*BLOCK_WIDTH.toDouble(),3*BLOCK_HEIGHT.toDouble()))

    //ORANGE BLOCKS
    val mB1 = createBlock(Color.ORANGE,Location(5*BLOCK_WIDTH.toDouble(),4*BLOCK_HEIGHT.toDouble()))
    val mB2 = createBlock(Color.ORANGE,Location(6*BLOCK_WIDTH.toDouble(),4*BLOCK_HEIGHT.toDouble()))
    val mB3 = createBlock(Color.ORANGE,Location(7*BLOCK_WIDTH.toDouble(),4*BLOCK_HEIGHT.toDouble()))

    //CYAN BLOCKS
    val bB1 = createBlock(Color.CYAN,Location(5*BLOCK_WIDTH.toDouble(),5*BLOCK_HEIGHT.toDouble()))
    val bB2 = createBlock(Color.CYAN,Location(6*BLOCK_WIDTH.toDouble(),5*BLOCK_HEIGHT.toDouble()))
    val bB3 = createBlock(Color.CYAN,Location(7*BLOCK_WIDTH.toDouble(),5*BLOCK_HEIGHT.toDouble()))

    //GREEN BLOCKS
    val rB1 = createBlock(Color.GREEN,Location(5*BLOCK_WIDTH.toDouble(),6*BLOCK_HEIGHT.toDouble()))
    val rB2 = createBlock(Color.GREEN,Location(6*BLOCK_WIDTH.toDouble(),6*BLOCK_HEIGHT.toDouble()))
    val rB3 = createBlock(Color.GREEN,Location(7*BLOCK_WIDTH.toDouble(),6*BLOCK_HEIGHT.toDouble()))

    //RED BLOCKS
    val gB1 = createBlock(Color.RED,Location(5*BLOCK_WIDTH.toDouble(),7*BLOCK_HEIGHT.toDouble()))
    val gB2 = createBlock(Color.RED,Location(6*BLOCK_WIDTH.toDouble(),7*BLOCK_HEIGHT.toDouble()))
    val gB3 = createBlock(Color.RED,Location(7*BLOCK_WIDTH.toDouble(),7*BLOCK_HEIGHT.toDouble()))

    //BLUE BLOCKS
    val cB1 = createBlock(Color.BLUE,Location(5*BLOCK_WIDTH.toDouble(),8*BLOCK_HEIGHT.toDouble()))
    val cB2 = createBlock(Color.BLUE,Location(6*BLOCK_WIDTH.toDouble(),8*BLOCK_HEIGHT.toDouble()))
    val cB3 = createBlock(Color.BLUE,Location(7*BLOCK_WIDTH.toDouble(),8*BLOCK_HEIGHT.toDouble()))

    //MAGENTA BLOCKS
    val oB1 = createBlock(Color.MAGENTA,Location(5*BLOCK_WIDTH.toDouble(),9*BLOCK_HEIGHT.toDouble()))
    val oB2 = createBlock(Color.MAGENTA,Location(6*BLOCK_WIDTH.toDouble(),9*BLOCK_HEIGHT.toDouble()))
    val oB3 = createBlock(Color.MAGENTA,Location(7*BLOCK_WIDTH.toDouble(),9*BLOCK_HEIGHT.toDouble()))

    //SILVER BLOCKS
    val wB1 = createBlock(Color.SILVER,Location(5*BLOCK_WIDTH.toDouble(),10*BLOCK_HEIGHT.toDouble()))
    val wB2 = createBlock(Color.SILVER,Location(6*BLOCK_WIDTH.toDouble(),10*BLOCK_HEIGHT.toDouble()))
    val wB3 = createBlock(Color.SILVER,Location(7*BLOCK_WIDTH.toDouble(),10*BLOCK_HEIGHT.toDouble()))

    return listOf(
        yB1,yB2,yB3,
        mB1,mB2,mB3,
        bB1,bB2,bB3,
        rB1,rB2,rB3,
        gB1,gB2,gB3,
        cB1,cB2,cB3,
        oB1,oB2,oB3,
        wB1,wB2,wB3
    )
}

fun createBlocksRightSection(): List<Block>{
    //YELLOW LINE
    val yB1 = createBlock(Color.YELLOW,Location(9*BLOCK_WIDTH.toDouble(),3*BLOCK_HEIGHT.toDouble()))
    val yB2 = createBlock(Color.YELLOW,Location(10*BLOCK_WIDTH.toDouble(),3*BLOCK_HEIGHT.toDouble()))
    val yB3 = createBlock(Color.YELLOW,Location(11*BLOCK_WIDTH.toDouble(),3*BLOCK_HEIGHT.toDouble()))

    //MAGENTA BLOCKS
    val mB1 = createBlock(Color.MAGENTA,Location(9*BLOCK_WIDTH.toDouble(),4*BLOCK_HEIGHT.toDouble()))
    val mB2 = createBlock(Color.MAGENTA,Location(10*BLOCK_WIDTH.toDouble(),4*BLOCK_HEIGHT.toDouble()))
    val mB3 = createBlock(Color.MAGENTA,Location(11*BLOCK_WIDTH.toDouble(),4*BLOCK_HEIGHT.toDouble()))

    //BLUE BLOCKS
    val bB1 = createBlock(Color.BLUE,Location(9*BLOCK_WIDTH.toDouble(),5*BLOCK_HEIGHT.toDouble()))
    val bB2 = createBlock(Color.BLUE,Location(10*BLOCK_WIDTH.toDouble(),5*BLOCK_HEIGHT.toDouble()))
    val bB3 = createBlock(Color.BLUE,Location(11*BLOCK_WIDTH.toDouble(),5*BLOCK_HEIGHT.toDouble()))

    //RED BLOCKS
    val rB1 = createBlock(Color.RED,Location(9*BLOCK_WIDTH.toDouble(),6*BLOCK_HEIGHT.toDouble()))
    val rB2 = createBlock(Color.RED,Location(10*BLOCK_WIDTH.toDouble(),6*BLOCK_HEIGHT.toDouble()))
    val rB3 = createBlock(Color.RED,Location(11*BLOCK_WIDTH.toDouble(),6*BLOCK_HEIGHT.toDouble()))

    //GREEN BLOCKS
    val gB1 = createBlock(Color.GREEN,Location(9*BLOCK_WIDTH.toDouble(),7*BLOCK_HEIGHT.toDouble()))
    val gB2 = createBlock(Color.GREEN,Location(10*BLOCK_WIDTH.toDouble(),7*BLOCK_HEIGHT.toDouble()))
    val gB3 = createBlock(Color.GREEN,Location(11*BLOCK_WIDTH.toDouble(),7*BLOCK_HEIGHT.toDouble()))

    //CYAN BLOCKS
    val cB1 = createBlock(Color.CYAN,Location(9*BLOCK_WIDTH.toDouble(),8*BLOCK_HEIGHT.toDouble()))
    val cB2 = createBlock(Color.CYAN,Location(10*BLOCK_WIDTH.toDouble(),8*BLOCK_HEIGHT.toDouble()))
    val cB3 = createBlock(Color.CYAN,Location(11*BLOCK_WIDTH.toDouble(),8*BLOCK_HEIGHT.toDouble()))

    //ORANGE BLOCKS
    val oB1 = createBlock(Color.ORANGE,Location(9*BLOCK_WIDTH.toDouble(),9*BLOCK_HEIGHT.toDouble()))
    val oB2 = createBlock(Color.ORANGE,Location(10*BLOCK_WIDTH.toDouble(),9*BLOCK_HEIGHT.toDouble()))
    val oB3 = createBlock(Color.ORANGE,Location(11*BLOCK_WIDTH.toDouble(),9*BLOCK_HEIGHT.toDouble()))

    //WHITE BLOCKS
    val wB1 = createBlock(Color.WHITE,Location(9*BLOCK_WIDTH.toDouble(),10*BLOCK_HEIGHT.toDouble()))
    val wB2 = createBlock(Color.WHITE,Location(10*BLOCK_WIDTH.toDouble(),10*BLOCK_HEIGHT.toDouble()))
    val wB3 = createBlock(Color.WHITE,Location(11*BLOCK_WIDTH.toDouble(),10*BLOCK_HEIGHT.toDouble()))

    return listOf(
        yB1,yB2,yB3,
        mB1,mB2,mB3,
        bB1,bB2,bB3,
        rB1,rB2,rB3,
        gB1,gB2,gB3,
        cB1,cB2,cB3,
        oB1,oB2,oB3,
        wB1,wB2,wB3
    )
}

fun initializeBlocks(): List<Block> =
    createBlocksLeftSection() + createBlocksMiddleSection() + createBlocksRightSection()




