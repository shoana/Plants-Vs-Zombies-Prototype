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
- Unit tests for the complete model, view and controller. They run using JUnit to test edge cases and parameters
- UML models (class & sequence diagrams)
- Separated the source code into packages (model, controller, ...) to better organize the code and avoid "smell"

=================================================================================================
 Specifications to better understand the game:
 
-Plants:
	- Peashooter - Kills the zombies with its peas by decreasing the damage points of the zombie (-100 damage points) --- 100 Sunshines
 	- Sunflowers - Produces a sun (+25 sunshines) when bought --- 50 Sunshines
	- Walnut - Pauses the movement of a zombie in the same grid for 2 turns (a red light for the zombie) --- 200 Sunshines
	- Cherry Bomb - blows up all the zombies in the area --- 200 Sunshines
 - Zombies:
	- Normal (z): They are randomly generated onto the board form the rightside of the grid. The normal zombies start with 200 life 			points. 
	- Pylon (x): They are randomly generated onto the board form the rightside of the grid. It is harder to kill this zombie as it 			starts with 200 life points. 
	- Flag (f): Is placed in the center of board at the beginning of the game. It starts with 100 life points. Will see the purpose 		of this zombie when we implement the levels
 - Sunshine(Money) -- starts with 1000
=================================================================================================
LEVEL ONE VISUAL REPRESENTATION:

- grid = JButton board[column][row]
- zombies life bar:  the visual representation is not implemented in this milestone but the idea is
- sunshine counter -- used like money
- planting sunflowers allow users to gain more sunshine
- a legend for the type of zombies that are going to be on the board
- undo and redo buttons to unlimitedly undo and redo the user moves (planting plants) 
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
- Unit tests for all methods in the model (which was not done in the previous milestone), view and controller. They run using JUnit to test edge cases and parameters. Test the new classes (new plants and new zombies). Test case "gameover" is now changed to "gameplay". 
- UML diagrams (class and sequence) are modified according to the code (addition of event model, controller, view and inheritance)
- Changed the way zombies are killed. In the previous milestone, the zombies were killed according to the distance between the plant and zombie but now we have implemented a life counter for the zombies. Different zombies are given different life values (explained above) and when the peashooter "shoots" its peas the life decreases by 100. When it reaches 0, the zombie is dead.
- A major change is now the View class reads from the Model's grid to keep track of the game board rather than checking the zombies and plants arraylists 
- Implemented a 2D array in the model class (gamePlay) to help the undo and redo methods of the game.
- Created packages for the code to organize the classes and avoid smell
=================================================================================================
Changes to UML from:
 - Class Diagrams:
   The class diagrams have not changed much from last time. In this milestone we included a plant super class and a zombie super class. This was also added in the UML class diagram using the specific arrow heads to show inheritance of the subs-classes sunflower, cherry bomb, walnut peashooter to the plants class. And sub-classes normal zombie, flag zombie and pylon zombie to the zombie super class. We also removed the gameEnum class as we use an GUI and show no console logs as a game form. 
 
 - Sequence Diagrams:
  The sequence diagrams now includes new methods that were added to the model 'gamePlay' class such as 'flagZombieComing' & 'moveZombie' as well as the same MVC EventModel driven sequence diagram from Milestone 2. All edge cases for the methods 'plantTurn', 'zombieTime', 'plantOrZombie', 'flagZombieComing' & 'moveZombie' are also present from the gamePlay class. The diagram also considers the addition of new plants (cherrybomb & walnut) as well as new zombies (flagzombie, pylonzombie).
 
==================================================================================================
User-visible Changes:

- JFrame is used as the display and GridLayout using JButton is used for choosing and placing plant. 
- JButton is used for the undo and redo functionalities
- There is a live counter used for money (sunshines) that changes after every move and after using redo/undo
- JOptionPane is used to generate pop-ups that ask the user for the type of plant they want to buy
- Pop-ups are also used to collect suns, to notify if a game is finished (either the plants or the zombies win)
- The intermediate steps for the zombies are now visible in the GUI
=================================================================================================
Known Errors:

- Zombies start from the 2nd rightmost grid space, not the furthest right grid space
- Zombies and Plants sometimes disappear from the board and reappear when the user takes another turn. This happens rarely but it happens because our game is event based
- Undo/Redo functionalities work one frame late as it an event based game. So when the next plant is placed, the changes can be viewed (changes are only reflected when the user takes another turn). 
- If you press undo more that the times you placed a plant, it gives an EvenQueue error, this will be fixed. Same goes with redoing, if you redo without undoing, eclipse gives an error but the game can continue to play.
- We will be changing the class names from "gamePlay" into "GamePlay" for better Java conventions
=================================================================================================
Roadmap Ahead:
Milestone 4: Level implementation and get rid of the known errors and make it more of a challenging game. Save/Load features. 
=================================================================================================
ZIP folder contains:
- README file
- Design Decisions
- Unit Tests
- Source Code
- UML Class and Sequence Diagrams
=================================================================================================
Who did what:

Sarah Lamonica: 
- Implemented undo/redo functionality using 2 stacks: undoPlantStack, redoPlantStack
- Implemented walnut & cherrybomb plants and their functionality
- Implemented flag zombie and pylon zombie and their functionality
- Refactored gameplay class with a 2d array to represent the grid and
updated the view to display based on the model's grid array
- Refactored the zombie class to add damage points
- Refactored the win (plantOrZombie) function to decrease zombie's
damage points and check for plant wins based on the zombie's damage points

Mounica Pillarisetty:
	- Worked on Undo/Redo Functionalities in gamePlay class
	- Wrote the ReadMe file
	- Wrote the User Manual
	- Worked on implementing some of the types of zombies/plants
	- Wrote the Design Description
  
Shoana Sharma:
	- Javadocs for all classes and test-cases
	- Class diagram for the classes using MVC
	- All test cases required to test the model, view and controller
	- Restructured the gamePlay class
	- Tried to implement a timer for the zombies to make the game more user friendly, will continue constructing for 	milestone 4

Fatima Hashi:
	- Sequence diagram for the classes using MVC
	- All test cases required to test the model, view and controller
	- Restructured the gamePlay class
	- Tried to implement a timer for the zombies to make the game more user friendly, will continue constructing for 	milestone 4
