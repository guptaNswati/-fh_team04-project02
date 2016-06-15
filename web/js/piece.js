function Piece( player, pcolor ) {
    
    this.player = player;
    this.pcolor = pcolor;
    
    //alert("in Piece constructor: "+this.toString())
    
}

Piece.prototype.getPlayer = function() {
    return this.player;
};

Piece.prototype.getPieceColor = function() {
    return this.pcolor;
};

Piece.prototype.setPlayer = function( plyr ) {
    this.player = plyr;
};

Piece.prototype.setPieceColor = function( colr ) {
    this.pcolor = colr;
};

Piece.prototype.equals = function ( p ) {
    return p.getPlayer() == getPlayer() && p.getColor() == getColor();
}

Piece.prototype.toString = function () {
    return "Piece("+this.getPlayer().name+","+this.getPieceColor().name+")";
}