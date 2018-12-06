# SYSC3310_Group6_PvZ -- Milestone 4

Authors:
- Sarah Lamonica
- Shoana Sharma 
- Fatima Hashi 
- Mounica Pillarisetty

Plants vs. Zombies

Milestone 4: 

- This milestone is a GUI-based version that is fully-featured with various types of plants and zombies, unlimited undo/redo feature of user moves (in other words, the user can undo or redo the placement of the plants and the sunshine works along with the choice but not the zombies -- to keep the game more interesting), save and load functionality as well as level implementation  
- Utilized the Event Model design pattern to ensure the game followed the previous iteration of the game (loop-based)
- Unit tests for the complete model, view and controller. They run using JUnit to test edge cases and parameters
- UML models (class & sequence diagrams)
- Separated the source code into packages (model, controller, ...) to better organize the code and avoid "smell"

=================================================================================================
 Specifications to better understand the game:
 
-Plants:
	- Peashooter(p): Kills the zombies with its peas by decreasing the damage points of the zombie (-100 damage points) --- 100 Sunshines
 	- Sunflowers(s): Produces a sun (+25 sunshines) when bought --- 50 Sunshines
	- Walnut(w): Pauses the movement of a zombie in the same grid for 2 turns (a red light for the zombie) --- 200 Sunshines
	- Cherry Bomb(c): blows up all the zombies on the board after another move (one frame after)--- 200 Sunshines
 - Zombies:
	- Normal (z): They are randomly generated onto the board form the rightside of the grid. The normal zombies start with 200 life 			points. 
	- Pylon (x): They are randomly generated onto the board form the rightside of the grid. It is harder to kill this zombie as it 			starts with 200 life points. 
	- Flag (f): Is placed in the center of board at the beginning of the game. It starts with 100 life points. Allways in the same position.
 - Sunshine(Money) -- starts with 800
=================================================================================================
LEVEL REPRESENTATION:
There are 3 levels that are of different difficulties and different zombies to kill

Level 1: The player figths upto 2 normal zombies randomly positioned on the grid (every time you play level 1, they will be in diffrent locations)

Level 2:The player fights upto 4 zombies, 3 normal zombies randomly positioned on the grid and a flag zombie

Level 3: The player fights multiple zombies of all types. This is the more challenging level as the sunshines are low and possibly more zombies are attacking

When you select a level, there are pop-ups to inform about the types of zombies you are playing against. Follow the instructions on the pop-ups to access all the levels. Also the sunshines (used to buy plants) doesn't restock after each level, so be careful and play stratigically. 

=================================================================================================
Visual Representation (GUI):
- sunshine counter -- used like money
- planting sunflowers allow users to gain more sunshine
- a legend for the type of zombies that are going to be on the board
- undo and redo buttons to unlimitedly undo and redo the user moves (planting plants) 
- save and load buttons -- saving the board is like taking a snapshot of all the elements of the board (not including the score) and when load is pressed, that saved board is what you will be playing. 
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

- Unit tests for all methods in the model, view and controller. They run using JUnit to test edge cases and parameters. Test the new classes (new plants and new zombies) and the save/load feature. Test case "gameover" is now changed to "gameplay". 
- UML diagrams (class and sequence) are modified according to the code 
- Changed the way zombies are killed. In the previous milestone, the zombies were killed according to the distance between the plant and zombie but now we have implemented a life counter for the zombies. Different zombies are given different life values (explained above). ie. when the peashooter "shoots" its peas the life decreases by 100. When the life (damagePoints) reaches 0, the zombie is dead. The Cherry Bomb kills all the zombies off the board. 
- The Undo and Redo implementations were lagging one frame last milestone, and that is now fixed
- The zombies sometimes started from the second rightmost square rather than starting at the rightmost square. This is now fixed and all the zombies start at the righmost square and try to reach the house (leftmost square)
- Created packages for the code to organize the classes and avoid smell
- Save/Load feautures are now implemented in the model. The methods use throw exceptions. Saving the board is like taking a snapshot of all the elements of the board (not including the score) and when load is pressed, that saved board is what you will be playing. We decided to not make the score change to make the game more chalenging and follow the rules of classic games.
- Levels are added onto this milestone as well. For better understanding, read the thorough explaination of levels above. 
=================================================================================================
Changes to UML from:
 - Class Diagrams:
The class duagrams does not include any major changes from the previous milestone. The only changes in the class diagram are including the new methods save, load and level implemtations. The class digrams still are based on a MVC pattern. All the varied types of plants inherits from the super class plants and all the different zombies inherit from super class zombies.
 
 - Sequence Diagrams:
The sequence diagrams now includes newly added implemetations in the game such as levels, save, load, undo & redo features. 
All edge cases are shown for when a user invokes one of the following methods in the game: 'plantTurn', 'plantOrZombie', 'flagZombieComing', 
'moveZombie', 'save', 'load', 'redo', 'undo', 'lvlOne', 'lvlTwo' & 'lvlThree' from the gamePlay class.

==================================================================================================
User-visible Changes:
- JFrame is used as the display and GridLayout using JButton is used for choosing and placing different type of plants. 
- JButton is used for the undo and redo functionalities
- JButton is used for the save and load functionalities
- There is a live counter used for money (sunshines) that changes after every move and after using redo/undo
- JOptionPane is used to generate pop-ups that ask the user for the type of plant they want to buy
- Pop-ups are also used to collect suns, to notify if a game is finished (either the plants or the zombies win)
- The starting sunshine is now 800 rather than 1000 to make the game more interesting
- More buttons are added to the top, the load and save buttons along side undo, redo. 
- There are pop-ups to inform about the types of zombies you are playing against before they start a new level.
=================================================================================================
Known Errors:
- 
=================================================================================================
ZIP folder contains:
- User Manual
- README file
- Design Decisions
- Unit Tests
- Source Code
- UML Class and Sequence Diagrams
=================================================================================================
Who did what:

Sarah Lamonica: 

Mounica Pillarisetty:

Shoana Sharma:
- Class Diagrams 
- Java Documentation
_ Test Cases for MVC
_ Refactoring gamePlay class

Fatima Hashi:
