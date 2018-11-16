# SYSC3310_Group6_PvZ -- Milestone 2

Authors:
- Sarah Lamonica
- Shoana Sharma 
- Fatima Hashi 
- Mounica Pillarisetty

Plants vs. Zombies

Milestone 1 feedback was given at 11:40pm on Thursday, Nov 16th 2018. Therefore, we could not implement all required changes from the feedback file for this milestone, however we will work on adding them to the next iteration (due Nov. 25th)

Milestone 2: 
- This milestone is a visual game rather than a text-base game
- GUI-based version (with the View and the Controller) of the bare-bones version of the game 
- Utilized the Event Model design pattern to ensure the game followed the previous iteration of the game (loop-based)
- Unit tests for the Model (gamePlay class)
- Game includes sunflowers, one other type of plant (peashooters), one type of zombie at Level 1
- UML models (class & sequence diagrams)

=================================================================================================
 Requirements:
 - Peashooter -- one type
 - Sunflowers
 - Zombies -- one type
 - Sunshine(Money) -- starts with 1000
 - Type of zombie the user wants to fight (NOT IMPLEMENTED IN MILESTONE 2)
 - Zombies Life Bar (NOT IMPLEMENTED IN MILESTONE 2)
 - Lawn Mower (lives) (NOT IMPLEMENTED IN MILESTONE 2)

=================================================================================================
LEVEL ONE 
- grid = JButton board[column][row]
- bar increses as zombies decreases (NOT IMPLEMENTED IN MILESTONE 2)
- sunshine counter -- used like money
- game state: zombie state, plant state
- plant state: sunflower and peashooter
- planting sunflowers allow users to gain more sunshine
- lawnMower = number of rows (NOT IMPLEMENTED IN MILESTONE 2)
- enum: different states of the game

=================================================================================================
Classes:
- Plants
   - sunflowers
   - peashooter
- Zombie
- gamePlay (model)
- View -- the game is run through this class
- Controller
- gameEnum -- the states of the game
- gamePlayEvent 
- gamePlayListener

=================================================================================================
Change Log:
- The user will be given a 1000 sunshines to start the game rather than 300 (like the last milestone). It will allow the user to win  
  much easier.
- This milestone is a visual game rather than a text-base game
- GUI-based version (with the View and the Controller) of the bare-bones version of the game 
- Utilized the Event Model design pattern to ensure the game followed the previous iteration of the game (loop-based)
- Unit tests for classes
- UML diagrams (class and sequence) are modified according to the code (addition of event model, controller, view ...)

=================================================================================================
Chnages to UML from:
 - Class Diagrams:
This UML differs from the previous UML because it now includes a MVC model based class diagram. It now has an addtional class for controller, view, gamePlayEvent and a gamePlayListener. The view class inerits from the JFrame class from the java biuld-in libraries. The GUI implemetations are also included in the view class with its distinct methods.  
 
 - Sequence Diagrams:
 
==================================================================================================
User-visible Changes:
- In this milestone the game has become a visul rather than a textual base
- JFrame is used as the display and GridLayout using JButton is used for choosing and placing plant
- There is a live counter used for money (sunshines) that changes after every move
- JOptionPane is used to generate pop-ups that ask the user for the type of plant they want to buy
- Pop-ups are also used to collect suns, to notify if a game is finshed (either the plants or the zombies win)

=================================================================================================
Known Errors:
- The intermediate steps for the zombies are not visible in the GUI, but take a look at the console for them (will be fixed in the next milestone)
   - The intermediate steps include: the movement of the zombies on the grid, the removal of the zombie once it leaves its initial 
     position. * please note while testing, check the intermediate steps on the console if wary of how zombies behave. 
     
=================================================================================================
Roadmap Ahead:
- Milestone 3: Complete implementation of the game which includes multiple types of zombies, plants, etc. 
  To complete this, we will be utilizing inheritance to group plants and zombies together. They will each have their own behaviour but     will act similar on the grid and in the game.
  Inhertance will be implemented for the plants as we will have multiple plant types in this milestone. 

We will also include the types of zombies that the user wants to fight and 
- Milestone 4: Save/Load features.
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
- Worked on implementing the View and Controller classes 
- Implemented the Event Model pattern in the project so the Model could update the View using event listeners.
- Worked on JavaDoc

Mounica Pillarisetty:
- Worked on implementing the View and sunflower classes
- Edited the gamePlay class (model)
- Detailed Discription (documentation)
- README file
- User Manual
  
Shoana Sharma:
- JavaDoc
- Test Classes
- UML Class diagrams
- worked on gamePlay

Fatima Hashi:
- Test Classes
- UML Sequence diagrams
- worked on gamePlay
