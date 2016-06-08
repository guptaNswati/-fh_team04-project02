/* 
 *  This file contains among other things the board layout and KColors enum...
 */
// ENUM of Kamisado Board Square Colors
//var KColors = {
//    ORANGE : {value: 0 , name:"ORANGE", code: "S", colorcode:"#FFA500" }, 
//    BLUE : {value: 1 , name:"BLUE", code: "S", colorcode:"#0000FF"},
//    PURPLE :{value:2 , name:"PURPLE", code: "S", colorcode:"#800080"},
//    PINK :{value: 3, name:"PINK", code: "S",colorcode:"#E8ADAA"},
//    YELLOW :{value: 4, name:"YELLOW", code: "S", colorcode:"#FFFF00"},
//    RED :{value:5 , name:"RED", code: "S", colorcode:"#FF0000"},
//    GREEN :{value: 6, name:"GREEN", code: "S", colorcode:"#00FF00"},
//    BROWN :{value: 7, name:"BROWN", code: "S", colorcode:"#A52A2A"} };

/*
 * 
 * @type Array --  Colors for Entire 8x8 Kamisado Board
 */

//var Player;
//var KColors;

/*var*/  boardColors = [ [ KColors.ORANGE, KColors.BLUE, KColors.PURPLE, KColors.PINK,KColors.YELLOW,KColors.RED,KColors.GREEN,KColors.BROWN ],
                    [ KColors.RED,KColors.ORANGE,KColors.PINK,KColors.GREEN,KColors.BLUE,KColors.YELLOW,KColors.BROWN,KColors.PURPLE ],
                    [ KColors.GREEN,KColors.PINK,KColors.ORANGE,KColors.RED,KColors.PURPLE,KColors.BROWN,KColors.YELLOW,KColors.BLUE ],
                    [ KColors.PINK,KColors.PURPLE,KColors.BLUE,KColors.ORANGE,KColors.BROWN,KColors.GREEN,KColors.RED,KColors.YELLOW ],
                    [ KColors.YELLOW,KColors.RED,KColors.GREEN,KColors.BROWN,KColors.ORANGE,KColors.BLUE,KColors.PURPLE,KColors.PINK ],
                    [ KColors.BLUE,KColors.YELLOW,KColors.BROWN,KColors.PURPLE,KColors.RED,KColors.ORANGE,KColors.PINK,KColors.GREEN ],
                    [ KColors.PURPLE,KColors.BROWN,KColors.YELLOW,KColors.BLUE,KColors.GREEN,KColors.PINK,KColors.ORANGE,KColors.RED ],
		    [ KColors.BROWN,KColors.GREEN,KColors.RED,KColors.YELLOW,KColors.PINK,KColors.PURPLE,KColors.BLUE,KColors.ORANGE ] ];
                
/*var*/ boardPieces = [];   // 8x8 array of Pieces
/*var*/ pieceLocations = [];   // 2x8 array of Squares

function Board() {
    
    for (y=0;y<8;y++) {
        boardPieces[y] = [];
        for(x=0;x<8;x++) {
            boardPieces[y][x]=null;     
        }
    }

    for (y=0;y<2;y++) {
        pieceLocations[y]=[];
        for (x=0;x<8;x++) {
            pieceLocations[y][x]=null;
        }
    }
    
    for ( x=0; x<8; x++ ) {
	
        /*Square*/ s = new Square( x , 0 );
        /*KColors*/ c = this.getSquareColor(s);
	/*Piece*/ p = new Piece( Player.WHITE,c );
	this.setBoardPiece(s,p);
        this.setPieceLocation(p,s);
			
	s = new Square( x,7 );
        c = this.getSquareColor(s);
        p = new Piece( Player.BLACK, c);
	this.setBoardPiece(s,p);
	this.setPieceLocation(p,s);
			
    }
    
    //alert( "at end of Board constructor -- "+boardPieces[0][0].getPlayer().name);
}

/**
 * get the color of the square referenced by x,y / Square
 * @param x   x index on board
 * @param y   y index on board
 * @return    the color of the square at x,y
 */
Board.prototype.getSquareColorXY = function(/*int*/ x, /*int*/ y) {
        return boardColors[y][x];
};

Board.prototype.getSquareColor = function(/*Square*/s) {
        return boardColors[s.getY()][s.getX()];
};

/**
 * get the Piece at a particular square / x,y
 * @param x   x index on board
 * @param y   y index on board
 * @return    the Piece on the board square at x,y
 *            will return null if square is not occupied
 */
Board.prototype.getPieceOnSquareXY= function(/*int*/ x, /*int*/ y) {
        return boardPieces[y][x];
}

Board.prototype.getPieceOnSquare = function(/*Square*/ s) {
        return boardPieces[s.getY()][s.getX()];
}

/**
 * return the Square the specified Piece is on
 * @param p  -- specified Piece
 * @return -- the Square the specified Piece is on.
 */
Board.prototype.getSquarePieceIsOn = function( /*Piece*/ p ) {
    
        //alert("in getSquarePieceIsOn ... "+p.toString());
        return pieceLocations[p.getPlayer().value][p.getPieceColor().value];
}

/**
 * set the board location ( square / x,y ) to a particular Piece
 * @param s
 * @param p
 */
Board.prototype.setBoardPiece = function( /*Square*/ s, /*Piece*/ p) {
    
        boardPieces[s.getY()][s.getX()] = p;
}

Board.prototype.setPieceLocation = function(/*Piece*/ p, /*Square*/ loc ) {
        //alert("in setPieceLocation()  --> p"+p.getPlayer()+" c"+p.getPieceColor());
        pieceLocations[p.getPlayer().value][p.getPieceColor().value] = loc;
}

/**
 *  
 * @param p  -- the piece to be moved
 * @param s  -- the square to move the piece to
 * @return   -- true if move is valid
 */
Board.prototype.move = function(/*Piece*/ p, /*Square*/ s) {
    
    //alert("in Board.move()");
    
    start = pieceLocations[p.getPlayer().value][p.getPieceColor().value];
    // set board piece square ( start ) to null;
    this.setBoardPiece( start, null);
    this.setBoardPiece( s, p );
    this.setPieceLocation( p , s);

    return false;
}

/**
 * 
 * @param p  -- the piece to move
 * @param s  -- the intended square to move to...
 * @return   -- true if move is valid
 */
Board.prototype.isValidMove = function(/*Piece*/ p, /*Square*/ s) {
        // TODO Auto-generated method stub
       return true;
}

/**
 * returns a list of allowable moves for the specified Piece
 * 
 */
Board.prototype.getAllowableMoves = function(/*Piece*/ p) {
    
    var allowable = [];
    
    direction = p.getPlayer()==Player.WHITE?1:-1;
		
    /*Square*/ start = this.getSquarePieceIsOn( p );

    var x,y;

    y=start.getY()+direction;
    while (y<8 && y>=0) {

        /*Square*/ s1 = new Square( start.getX(), y );
        if (( this.getPieceOnSquare(s1)!==null)) break;
        allowable[allowable.length] = s1;
        y+=direction;
        
    }

    if ( start.getX()>0 ) {

        x = start.getX()-1;
        y = start.getY()+direction;

        while ( x>=0 && y<8 && y>=0 ) {
            /*Square*/ s2 = new Square(x,y);
            if (( this.getPieceOnSquare(s2)!==null)) break;
            allowable[allowable.length]=s2;
            x--;
            y+=direction;

        }
    }

    if (start.getX()<7) {

        y = start.getY()+direction;
        x = start.getX()+1;

        while ( x<8 && y<8 && y>=0 ) {

            /*Square*/ s3=new Square(x,y);
            if (( this.getPieceOnSquare(s3)!==null)) break;
            allowable[allowable.length] = s3;
            x++;
            y+=direction;

        }
    }

    return allowable;

}

/**
 * Simple text rendering of board
 */
Board.prototype.render = function() {
    
        var s = "<br>";

        for ( y=0; y<8; y++ ) {
                for ( x=0; x<8; x++ ) {

                        /*Square*/ sq = new Square(x,y);

                        /*KColors*/  c = this.getSquareColor(sq);
                        /*Piece*/ p = this.getPieceOnSquare(sq);

                        colr = c.name.substring(0, 2);

                        if (p!=null) {
                                /*KColor*/ pcolr = p.getPieceColor();
                                pcolrname=pcolr.name.substring(0, 2);
                                if ( p.getPlayer()==Player.BLACK) s=s+"["+pcolrname+"]";
                                else s=s+"("+pcolrname+")";
                            }
                        else
                                s=s+" "+colr+" ";
                }
                s=s+'<br>';
        }
        return s;
}
