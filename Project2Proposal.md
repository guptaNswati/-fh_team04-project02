###Project 2 Proposal###

####Kamisado####

__Team Composition:__<br>

Christopher Barbee,  Christopher Dunleavy , Hanyu Chen (Matt), Swati Gupta

June 16, 2016

---

####Table of Contents####

* 1 Project Overview 
  * 1.1 Abstract…………………………………….………………………Pg 2
  * 1.2 Target Customer……………….…………………………………Pg 2
  * 1.3 Search Words……………….……………………………………Pg 2
  * 1.4 Scope and Objectives….…………………………………………Pg 2, 3
* 2 Team and Constraints
  * 2.1 Team Profile…….……………………………………………….…Pg 3
  * 2.2 Challenges……….……………………………………………….Pg 3
  * 2.3 Assumptions and Constraints………………………………....Pg 3,4
* 3 Deliverables and Milestones
 * 3.1 Project Deliverables……………………………………………..Pg 4
 * 3.2 Schedule and Budget Summary…..…………………………..Pg 4,5


---

## 1.0	Project Overview
### 1.1 Abstract

The purpose of this project is to develop a Java implementation of the board game Kamisado. Kamisado is a two-player game that was released in 2008, and it takes about ten minutes to play. One player controls eight black pieces, and the other player controls eight white pieces. The board is an 8x8 area comprised of colored squares. Each of the players' eight pieces is marked with a different color corresponding to the colors on the board. Each piece can move forward or diagonally-forward as many spaces as possible without crossing through occupied spaces, but the player doesn't get to choose which piece he moves – the piece he must move is the piece whose color matches that of the space that his opponent landed on last turn. The first player to move one of his pieces to the opposite end of the board wins the game. 

The software will be written in Java, using Swing for the GUI. Graphics for the pieces will be drawn in Paint.NET.

The game will be playable by two players locally on one machine. The user will start up the program, start a two player game, and play along with a friend. Each player will take turns using the mouse to move their pieces. The spaces available for them to move their piece to will be highlighted. The game will automatically end when the win condition for one player is met.

Additionally, there will be a single-player mode available, in which one player can play against a computer opponent.

Also, a web version of the Game will be made.  Two players ( with internet access ) will go to the Kamisado game webpage.  When both players have connedted to the Kamisado Game server the game will begin with the white player moving first.  The users moves will be reflected on both the players browsers. Additionally the users can send chat messages ( trash talk ? ) to each other.  When there is a winner,  both players will be notified.  Idealy this version will be deployable to the web ( like Heroku and other JEE hosting sites on the web ).

The local version will have a color-blind-mode that will allow color-blind users to use/play this Kamisado game.

### 1.2.	Target Customer [important part]

The client for this project would be a PC game distribution service like Steam, EA Origin, or Uplay. The client would sell the game over their distribution service and take a percentage of the profits. 

The users of this software are the people who want to play Kamisado either with a friend or against a computer opponent. They would buy the game from the distributor and play it on their computers. Users would also have access to the web version.


### 1.3.	Search Words 

Kamisado, Chess, Board, Game, Two-Player, Computer Opponent, Colorblind


###1.4.	Scope and Objectives 
Graphics will need to be created for the board and the pieces. Additionally, graphics will be created for the purposes of highlighting valid board spaces and for colorblind use.

There will be a Main Menu from which the user can start a one or two-player game, or play a two-player game with colorblind mode enabled.

The starting player will start by clicking on any piece to start with. Only the active piece will be able to move, and the game will display an overlay of highlighted game spaces, indicating the spaces that are legal for the active piece to move onto. If a player finishes a move and the opponent's active piece is blocked, leaving it with no valid moves, the player will get an additional turn, moving the piece with the color of the blocked piece's color. 

The game will detect when the win condition has been met by either player the game will end.

There will be an option for a single player to play against a computer opponent. Since the computer only needs to worry about moving one piece at a time, and doesn't need to decide which piece to move, it will either move the piece that wins the game, or move to a space that doesn't allow its opponent (the player) to win next turn. The computer will determine which of the available spaces is ideal. 

## 2.0	Team and Constraints

###2.1.	Team profile
* Chris Dunleavy - proficient in Java, has some experience with JavaScript, HTML, CSS, and SQL
* Chris Barbee - Some professional experience in Java ( Hibernate, some RESTful web services, some jsp, some UML ( Class Diagram and Sequence Diagrams ). Some javascript ( including JSON, and HTTPRequest ). I enjoy the design phase ( making UML diagrams for instance )
* Hanyu Chen - Good at using Java and taking CS1C now in Foothill College. Although technically I don't have much experience in Java, but I will try my best to learn and help my team.
* Swati Gupta - Java, Java GUI

### 2.1.	Challenges
* Time constraints -- 4 weeks ,  4 sprints.
* Getting up to speed with Java Swing and J2D(basically is making model of board and game pieces, also need to learn how to drag and drop pieces. 
* Designing a computer component with AI
* Porting Kamisado model ( in java ) to javscript ( for the web version ).
* Changing the design of the software as we determine what makes for the most user-friendly experience
* Making graphics that are pleasing to the eye
* Making sure all rules are implemented correctly


### 2.2.	Assumptions and Constraints

* Non-Technical Constraints:
  * Users have a general understanding of how to user computers ( mouse / keyboard / GUI )
  * We only have 4 weeks to complet this proect
  * Manpower is not as good as other groups.  
  * Users have the ability to diferentiate betweeen different colored squares ( for no-color-blind version )
* Techinical Constraints:
  *  Assuming the user(s) has a version on Java VM with Swing and Java2D libraries.
  *  Assuming the user(s) have a reasonably recent computer that can run a version of JRE ( with J2D and Swing set )
  *  Assuming users have access to the web and an HTML5 compliant browser.

---

##3.0	Deliverables and Milestones

### 3.1.	Project Deliverables 

Deliverables include:
*	Software System Project Proposal.
*	Preliminary design docs ( interfaces )
*	Class Diagram and Sequence diagrams
*	README.txt list of files submitted for instrutor review
*	Presenations
*	javadoc
*	java code
*	HTML pages
*	Javascript code
*	Other associate files like .png images for board pieces and marking allowable moves.
*	Short movies demonstrating current functionality ( both fof the Swing GUI version and the web version ).


### 3.2.	Schedule and Budget Summary [critical section]

* Schedule -- Project 2 has a limited number of sprints (4)
* Main milestones are
    --  Modeling the board and pieces ( initializing the board and pieces )
    --  Valid movement of a players piece
    --  Showing the set of a players moves
    --  Checking for game winning move
    --  Drag and Drop pieces ( ? )
    --  AI / Look-ahead engine...

####Milestones

| Item                       | Date            |
| :--------------------------|:----------------|
| Project Proposal           | May 19, 2016  |
| Proposal Presentation      | May 19, 2016  |
| Building board model and simple view of an initialized board ( with pieces ) | May 26, 2016 |
| Basic functionality to move a piece and logic to validate the users move  | June 2, 2016 |
| Functionality to show users possible moves ( higlighting ), if possible, develope AI and look-ahead engine | June 9, 2016] |
| Demonstration and Delivery | June 16, 2016    |
