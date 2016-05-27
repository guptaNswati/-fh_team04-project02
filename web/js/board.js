/* 
 *  This file contains among other things the board layout and KColors enum...
 */
// ENUM of Kamisado Board Square Colors
var KColors = {
    ORANGE : {value: 0 , name:"ORANGE", code: "S", colorcode:"#FFA500" }, 
    BLUE : {value: 1 , name:"BLUE", code: "S", colorcode:"#0000FF"},
    PURPLE :{value:2 , name:"PURPLE", code: "S", colorcode:"#800080"},
    PINK :{value: 3, name:"PINK", code: "S",colorcode:"#E8ADAA"},
    YELLOW :{value: 4, name:"YELLOW", code: "S", colorcode:"#FFFF00"},
    RED :{value:5 , name:"RED", code: "S", colorcode:"#FF0000"},
    GREEN :{value: 6, name:"GREEN", code: "S", colorcode:"#00FF00"},
    BROWN :{value: 7, name:"BROWN", code: "S", colorcode:"#A52A2A"} };

/*
 * 
 * @type Array --  Colors for Entire 8x8 Kamisado Board
 */
var boardColors = [ [ KColors.ORANGE, KColors.BLUE, KColors.PURPLE, KColors.PINK,KColors.YELLOW,KColors.RED,KColors.GREEN,KColors.BROWN ],
                    [ KColors.RED,KColors.ORANGE,KColors.PINK,KColors.GREEN,KColors.BLUE,KColors.YELLOW,KColors.BROWN,KColors.PURPLE ],
                    [ KColors.GREEN,KColors.PINK,KColors.ORANGE,KColors.RED,KColors.PURPLE,KColors.BROWN,KColors.YELLOW,KColors.BLUE ],
                    [ KColors.PINK,KColors.PURPLE,KColors.BLUE,KColors.ORANGE,KColors.BROWN,KColors.GREEN,KColors.RED,KColors.YELLOW ],
                    [ KColors.YELLOW,KColors.RED,KColors.GREEN,KColors.BROWN,KColors.ORANGE,KColors.BLUE,KColors.PURPLE,KColors.PINK ],
                    [ KColors.BLUE,KColors.YELLOW,KColors.BROWN,KColors.PURPLE,KColors.RED,KColors.ORANGE,KColors.PINK,KColors.GREEN ],
                    [ KColors.PURPLE,KColors.BROWN,KColors.YELLOW,KColors.BLUE,KColors.GREEN,KColors.PINK,KColors.ORANGE,KColors.RED ],
		    [ KColors.BROWN,KColors.GREEN,KColors.RED,KColors.YELLOW,KColors.PINK,KColors.PURPLE,KColors.BLUE,KColors.ORANGE ] ];
