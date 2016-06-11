function renderrow(rowNum) {
               
   row = document.getElementById("row"+rowNum);

   for ( x = 0; x < 8; x++ ) {

       canv = document.createElement("canvas");
       canv.setAttribute("height",boardSquareSize);
       canv.setAttribute("width",boardSquareSize);
       canv.setAttribute("id","square"+x+","+rowNum);

       //alert("in f() -- x:"+x+" y:"+y);
       kcolr = board.getSquareColorXY(x,y);

       colr = kcolr.colorcode;
       canv.style.background=colr;

       row.appendChild(canv);

   }
}

function renderboard() {
               
    brd = document.getElementById("board");

    for ( y=0; y < 8; y++ ) {

        row = document.createElement("div");
        row.setAttribute("id","row"+y);
        row.setAttribute("height",boardSquareSize);

        brd.appendChild(row);

        f(y);

   }
}

