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

Reflection On The Design 
- During the first milestone, individual classes for all the different types of plants and zombies was used. 
Inheritance was then implemented in the next iteration to promote better organization of the classes. 

- All zombies and plants were stored in two array lists. This design process was useful as 
it was able to keeptrack of all the zombie and plant positions, and also if they were eaten or not. This 
was useful in determining which zombies/plants to take off the board (when eaten) and 
determining if the zombies and plants won. The plantsOrZombies() method in gamePlay 
is a good example of how the arraylists were utilized to check for win/lose.  

- The model contained a 6X6 2d array which contained all the zombies and plants present on the board. 
The grid used chars to store the plant and zombie 'types' which was useful when the view displayed 
the plants and zombies on a grid of JButtons. We just checked what the char was in each grid space 
and displayed it accordingly.  

- The event model design pattern was useful in updating the view every time the user takes a turn.
Whenever a user placed a plant, the model updates the position of the zombies and check if the 
zombies or plants had won. It was a valid MVC design pattern where the model updates the view 
whenever there is a change, which was a very big topic in the SYSC 3110 course this semester. 

Likes: 
- The array lists were a great data structure to use to keep track of all the plants and 
zombies. The arraylist was unchanged since the first milestone and proved to be extremely
useful as more methods were added. The arraylists were of type "Plant" and "Zombie", which 
were superclasses so they were able to store each different subclass of zombie and plant. 
- Updating the view from the "grid" inside of the model was a good idea as it was very easy 
to iterate over the grid and display each char on the buttons in the view. It was useful to have 
the model keep track of its own grid since the grid changed after each event (to only update 
the grid on the view after an event).
- The event model pattern was useful in making sure that the view ONLY changed 
when the user takes a turn (i.e the model "changes"). This way keeps the 
implementation of the view & model separate and delegation occurs in the controller. 

Dislikes:
- The event model sometimes caused a "lag" between frames of the game. Sometimes, the plant 
or zombie is eaten but it doesn't dissappear off the board until the next turn. This is because of 
the event model pattern and the fact that it only updates when the user takes a turn. So, it is not 
"real time" and can be confusing to the user. 
- As we're unsure if whether we needed to implement multiple levels (we kept is as 3), having a 'Level' class would make 
including multiple levels easier. 

Reflection on the process
The code was refactored multiple times after each iteration. Some major changes are:
- Having a grid[][] array in the model which updates in the view. Originally, the view changed by 
iterating through the array lists and placing a plant or zombie based on their x and y coordinates.
This was very long code and it was shortened to a few lines just by having the model's grid array. 
- Checking if a zombie or plant won was changed by adding damage points to the zombie. Originally, 
the zombies won by being two spaces away from the plants and killing the plant. We changed this by 
only having the zombies win by reaching the end of the board (reaches the house) and the zombies 
can only be killed by peashooters and cherrybombs. 

Likes:
- As a group, we were easily able to communicate and collabroate with each other. 
- As this course was a first project development course, we've learned foundations of a MVC implementation as well as UML digrams. 
- As we were documenting each milestone, it became easier to make new and improved modifications on the next iterations. 
- Documentation is also a skill we've improved on throughout this course.  
- We were not familiar with the game, so it pushed us out of our comfort zome. 

Dislikes:
- At the start of the course, we were hoping to choose our game (project). 
- The Plant vs. Zombie game was not particularly appealing to us as a group. 

Overall, the process was a good learning experience in software development. 
 
 ========================================================================================================
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
 - Sunshine(Money) -- starts with 800 at the begining of every level
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
- UML diagrams (class and sequence) are modified according to the changes from Milestone 3 to Milestone 4. 
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
- Implemented Save/Load functionality using Java Serialization
- Implemented level builder by including different functions for different levels and logic for switching between levels
- Added buttons for save/load and multi-level menu bar and its implementation in gamePlay

Mounica Pillarisetty:
- ReadMe File
- User Manual
- Detailed Discription
- Refactored gamePlay and View classes to suit the changes to the game
- Worked on level builder as well as the visual representation of it

Shoana Sharma:
- Class Diagrams 
- Java Documentation
- Test Cases for MVC
- Refactoring gamePlay class

Fatima Hashi:
- Sequence Diagram
- Test Cases for MVC
- Refactoring gamePlay class
