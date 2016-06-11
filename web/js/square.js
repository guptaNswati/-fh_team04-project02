function Square( x, y ) {
    
    this.x = x;
    this.y = y;
    
}

Square.prototype.getX = function() {
    return this.x;
};

Square.prototype.getY = function() {
    return this.y;
};

Square.prototype.setY = function( yy ) {
    this.y = yy;
};

Square.prototype.setX = function( xx ) {
    this.x = xx;
};

Square.prototype.equals = function( sq ) {
    return sq.getX()==getX() && sq.getY()==getY();
};

Square.prototype.toString = function () {
    return "Square("+this.getX()+","+this.getY()+")";
}



