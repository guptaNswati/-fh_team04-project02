README.txt

Board Interface and Implementation ( plus other associated files ):

kamisado.board package:

   Board.java		Interface for a Kamisado board
   BoardImpl.java	Implementation of Board interface
   Color.java		An Enumeration of the set of colors on a Kamisado
 			board and pieces.
   Piece.java		A representation of a Kamisado board piece (
			containing both Color and Player components.
   Player.java		An Enumeration of the two player ( colors )
			(WHITE and BLACK )
   Square.java		A helper class representing a position on a
			Kamisado board ( for location items on a board
			like an available move and Piece location.

kamisado.websocket.server package:

   KamisadoSessionPair.java	A class that holds the Session information
				for pair of Kamisado players ( stored in a
				static Map in the WebSocketServer ).
   WebSocketServer.java		A Websocket endpoint that manages messages
				passed to and from the KAMISADO.html webpage.

Other associated files:

web/js folder:

   board.js		A ported version of the BoardImpl.java Board implementation.
   enuns.js		Enumerations for Color and Player ( as in the above java implemention )
   piece.js		A js style object ( using prototype keyword ).
   square.js		Similar to the Square object in the java implementation.

web folder:

   KAMISADO.html	A webpage “frontend” implementation allowing to separate
			players to player Kamisado from different browsers ( on
			different machines ( over the network )).  Also there is
			a built-in chat function so opponents can “chat” with each
			other ( trash talk ? )
   simpleWebSocketTest	A test I used to test functionality of a chat using
			websockets.
   testBoardColors.html A prototype of the KAMISADO.html webpage.

dist/

   KamisadoClient.war   A java web archive file ( to drop into a container ( server )
			to run ).  Am in the midst of using webapp-runner.jar to
			test deployment ( with the goal of deploying onto the web (
			like heroku ).	
			
FurtherDesignIdeas.txt  Some ideas about next steps / additonal functionality for this project.

   
