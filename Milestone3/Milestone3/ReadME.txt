# SYSC3310_Group6_PvZ -- Milestone 3

Authors:
- Sarah Lamonica
- Shoana Sharma 
- Fatima Hashi 
- Mounica Pillarisetty

Plants vs. Zombies

Milestone 3: 
- This milestone is a visual game that is fully-featured with various types of plants and zombies, and unlimited undo/redo feature of user moves (in other words, the user can undo or redo the placement of the plants and the sunshine works along with the choice but not the zombies -- to keep the game more interesting)
- GUI-based version (with the View and the Controller) 
- Utilized the Event Model design pattern to ensure the game followed the previous iteration of the game (loop-based)
- Unit tests for the complete model, view and controller. They run using JUnit to test egde cases and parameters
- UML models (class & sequence diagrams)
- Seperated the source code into packages (plants, zombies, ...) to better organize the code and avoid "smell"

=================================================================================================
 Specifications to better understand the game:
 
-Plants:
	- Peashooter - Kills the zombies with its peas by decreasing the damage points of the zombie (-100 damage points) --- 100 Sunshines
 	- Sunflowers - Produces a sun (+25 sunshines) when bought --- 50 Sunshines
	- Walnut - Pauses the movement of a zombie in the same grid for 2 turns (a red light for the zombie) --- 200 Sunshines
	- Cherry Bomb - blows up all the zombies in the area --- 200 Sunshines
 - Zombies:
	- Normal (z): They are randomly genrated onto the board form the rightside of the grid. The normal zombies start with 200 life 			points. 
	- Pylon (x): They are randomly genrated onto the board form the rightside of the grid. It is harder to kill this zombie as it 			starts with 200 life points. 
	- Flag (f): Is placed in the center of board at the beginning of the game. It starts with 100 life points. Will see the purpose 		of this zombie when we implement the levels
 - Sunshine(Money) -- starts with 1000
=================================================================================================
LEVEL ONE VISUAL REPRESENTATION:

- grid = JButton board[column][row]
- zombies life bar:  the visual representation is not implemented in this milestone but the idea is
- sunshine counter -- used like money
- planting sunflowers allow users to gain more sunshine
- a legend for the type of zombies that are going to be on the board
- undo and redo buttons to unlimetdly undo and redo the user moves (planting plants) 
- pop up when the user presses on the grid to place a plant with the various choice of plants to plant
=================================================================================================
Classes:

- Plant: Sunflower, Peashooter, Walnut, CherryBomb
- Zombie: NormalZombie, PylonZombie, FlagZombie
- gamePlay (model)
- View -- the game is run through this class
- Controller
- gamePlayEvent 
- gamePlayListener
=================================================================================================
Change Log:

- Rather than the bare-bones of the game, this milestone is a GUI-based version that is fully-featured with various types of plants and zombies, and unlimited undo/redo feature
- The intermediate steps for the zombies are now visible in the GUI, rather than the console
- Unit tests for all methods in the model (which was not done in the previous milestone), view and controller. They run using JUnit to test egde cases and parameters. Test the new classes (new plants and new zombies). Test case "gameover" is now changed to "gameplay". 
- UML diagrams (class and sequence) are modified according to the code (addition of event model, controller, view and inhertance)
- Changed the way zombies are killed. In the previous milestone, the zombies were killed according to the distance between the plant and zombie but now we have implemented a life counter for the zombies. Different zombies are given differnt life values (explained above) and when the peashooter "shoots" its peas the life decreases by 100. When it reaches 0, the zombie is dead.
- A major change is now the View class reads from the Model's grid to keep track of the game board rather than checking the zombies and plants arraylists 
- Implemeted a 2D array in the model class (gamePlay) to help the undo and redo methods of the game.
- Created packages for the code to organize the classes and avoid smell
=================================================================================================
Changes to UML from:
 - Class Diagrams:

 
 - Sequence Diagrams:
  The sequence digrams now includes new methods that were added to the model 'gamePlay' class such as 'flagZombieComing' & 'moveZombie' as well as the same MVC EventModel driven seqence diagram from Milestone 2. All edge cases for the methods 'plantTurn', 'zombieTime', 'plantOrZombie', 'flagZombieComing' & 'moveZombie' are also present from the gamePlay class.
 
==================================================================================================
User-visible Changes:

- JFrame is used as the display and GridLayout using JButton is used for choosing and placing plant. 
- JButton is used for the undo and redo functionalities
- There is a live counter used for money (sunshines) that changes after every move and after using redo/undo
- JOptionPane is used to generate pop-ups that ask the user for the type of plant they want to buy
- Pop-ups are also used to collect suns, to notify if a game is finshed (either the plants or the zombies win)
- The intermediate steps for the zombies are now visible in the GUI
=================================================================================================
Known Errors:

- Zombies start from the 2nd rightmost grid space, not the furthest right grid space
- Zombies and Plants sometimes disappear from the board and reappear when the user takes another turn. This happens rarely but it happens because our game is event based
- Undo/Redo funstionalities work one frame late as it an event based game. So when the next plant is placed, the changes can be viewed (changes are only reflected when the user takes another turn). 
=================================================================================================
Roadmap Ahead:
Milestone 4: Level implemetation and get rid of the known errors and make it more of a challenging game. Save/Load features. 
=================================================================================================
ZIP folder contains:
- README file
- Design Decisions
- Unit Tests
- Source Code
- UML Class and Sequenece Diagrams
=================================================================================================
Who did what:

Sarah Lamonica: 

Mounica Pillarisetty:
  
Shoana Sharma:

Fatima Hashi:
