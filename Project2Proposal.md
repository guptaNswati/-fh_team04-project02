###Project 2 Proposal###

####Kamisado####

__Team Composition:__<br>
[Name of Teammates]

May 19th, 2016

---

####Table of Contents####

[*This page enables the reader to quickly find relevant parts of the document. Including titles and page numbers of each section.
Note: The page numbers are for example only. Change these as you see fit.*]

* 1 Project Overview 
  * 1.1 Abstract…………………………………….………………………Pg 3
  * 1.2 Target Customer……………….…………………………………Pg 4
  * 1.3 Search Words……………….……………………………………Pg 4
  * 1.4 Scope and Objectives….…………………………………………Pg 4, 5
* 2 Team and Constraints
  * 2.1 Team Profile…….……………………………………………….…Pg 6
  * 2.2 Challenges……….……………………………………………….Pg 7
  * 2.3 Assumptions and Constraints………………………………....Pg 7
* 3 Deliverables and Milestones
 * 3.1 Project Deliverables……………………………………………..Pg 8
 * 3.2 Schedule and Budget Summary…..…………………………..Pg 9


---

## 1.0	Project Overview
### 1.1 Abstract

The purpose of this project is to develop a Java implementation of the board game Kamisado. Kamisado is a two-player game that was released in 2008, and it takes about ten minutes to play. One player controls eight black pieces, and the other player controls eight white pieces. The board is an 8x8 area comprised of colored squares. Each of the players' eight pieces is marked with a different color corresponding to the colors on the board. Each piece can move forward or diagonally-forward as many spaces as possible without crossing through occupied spaces, but the player doesn't get to choose which piece he moves – the piece he must move is the piece whose color matches that of the space that his opponent landed on last turn. The first player to move one of his pieces to the opposite end of the board wins the game. 

The software will be written in Java, using Swing for the GUI. Java2D may be used for graphics, but it may be easier to design the graphics in an external program like Photoshop or GIMP and use them in Swing.

The game will be playable by two players locally on one machine. The user will start up the program, start a two player game, and play along with a friend. Each player will take turns using the mouse to move their pieces. The spaces available for them to move their piece to will be highlighted, and if the user hovers over an available space, the opponent's piece that will move on the next turn will be highlighted. The game will automatically end when the win condition for one player is met, and the game can be reset at any time.

Additionally, the teams aims to include a computer player so that one player may still play the game. Due to the simple rules and the fact that only one piece is able to move each turn, a simple AI player should not be difficult to implement.


### 1.2.	Target Customer [important part]

The client for this project would be a PC game distribution service like Steam, EA Origin, or Uplay. The client would sell the game over their distribution service and take a percentage of the profits. 

The users of this software are the people who want to play Kamisado either with a friend or against a computer opponent. They would buy the game from the distributor and play it on their computers.


### 1.3.	Search Words 

Kamisado, Chess, Board, Game, Two-Player, Computer Opponent


###1.4.	Scope and Objectives [critical section]
Graphics will need to be created for the board and the pieces. Additionally, graphics will be created for the purposes of highlighting valid board spaces and highlighting which opponent's piece will move if a certain space is landed on.

The pieces will be able to be moved with the mouse, and will snap to the center of each board space. This way, pieces will appear aligned and centered. Only the active piece will be able to move, and the game will display an overlay of highlighted game spaces, indicating the spaces that are legal for the active piece to move onto. If a player finishes a move and the opponent's active piece is blocked, leaving it with no valid moves, the player will get an additional turn, moving the piece with the color of the blocked piece's color. 

The game will detect when the win condition has been met by either player and display a game results message, stating which player won. 

There will be an option for a single player to play against a computer opponent. Since the computer only needs to worry about moving one piece at a time, and doesn't need to decide which piece to move, it will either move the piece that wins the game, or move to a space that doesn't allow its opponent (the player) to win next turn. The computer will determine which of the available spaces is ideal. 

## 2.0	Team and Constraints

###2.1.	Team profile
[What are the strengths for each team member?]

[For each member of the team ***describe qualifications and strengths***<sup>[3](#footnote_3)</sup>.

*<sup><a name="footnote_3">3</a></sup>Note: Every team member is expected to be involved in all project activities. This section only describes individual strengths, and NOT the team member’s sole responsibilites.*]


### 2.1.	Challenges
[What are the challenges you foresee in successfully completing your project?]

[Provide a ***description of challenges*** that your group might face. These are often technical and non-technical aspects that may not be apparent to the reader.]

For example, if you were creating a software system for a dental office to manage patients, a challenge may be learning the domain, which involves following HIPPA regulations in disclosure of protected health information.

### 2.2.	Assumptions and Constraints
[Under what assumptions and constraints will the team adhere to?]

[**List any specific assumptions on which the project is based on and imposed constraints** that your team will be working under. Non-technical constraints could be: such as schedule and budget. Technical constraints may be design or implementation metholodogies, tools, operating system(s), hardware or software constraints.

* Non-Technical Constraints:
  * Such as time limit
  * add here...
* Techinical Constraints:
  *  Assuming the user(s) has a version on Java VM with Swing and Java2D libraries.
  *  Assuming the user(s) have a reasonably recent computer that can run a version of JRE ( with J2D and Swing set )

---

##3.0	Deliverables and Milestones

### 3.1.	Project Deliverables 

[What are the specific delivarables by your team?]

[***Provide a list of deliverables***<sup>[4](#footnote_4)</sup> of any project artifacts.]

Deliverables include:
*	Software System Project Proposal.
*	Preliminary design docs ( interfaces )
*	Class Diagram and Sequence diagrams
*	[user manual and installation instructions]
*	Presenations
*	javadoc
*	java code
*	[This list may include product deployment activities that are necessary for the successful use of the system your team develops.]

 *<sup><a name="footnote_4">4</a></sup>Note: This list may be modified over the weeks until the final submission.* 



### 3.2.	Schedule and Budget Summary [critical section]

* Schedule -- Project 2 has a limited number of sprints (4)
* Main milestones are
    --  Modeling the board and pieces ( initializing the board and pieces )
    --  Valid movement of a players piece
    --  Showing the set of a players moves
    --  Checking for game winning move
    --  Drag and Drop pieces ( ? )
    --  AI / Look-ahead engine...

[Fill in your teams projected milestones. You will be modifying this over the next few weeks.]


####Milestones

| Item                       | Date            |
| :--------------------------|:----------------|
| Project Proposal           | May 19, 2016  |
| Proposal Presentation      | May 19, 2016  |
| Building board model and simple view of an initialized board ( with pieces ) | May 26, 2016 |
| Basic functionality to move a piece and logic to validate the users move  | June 2, 2016 |
| Functionality to show users possible moves ( higlighting )  | [expected date] |
|  | April 21, 2016  |
| ...                        | [expected date] |
| Demonstration and Delivery | June 16, 2016    |
