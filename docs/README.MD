## LDTS_G1102 - SIMPLE TOMB OF THE MASK

In this game your task is to avoid the hazards trying to kill you and make it to the end of the levels. Sliding into walls
and trying to avoid imminent danger.

This game was developed by *Afonso Moura(*up202207931*@fe.up.pt)*,*Rubem Neto* (*up202207086*@fe.up.pt), *Diogo Goiana*(*up202207944*@fe.up.pt)

### IMPLEMENTED FEATURES

- **Sliding** - The character slides into a wall to move when any of the move keys are pressed.
- **Different Levels** - When the player gets to the end of a level, another level appears (up to 3 levels)
- **Bats** - These are little bats that move in a random starting direction (left or right) and if it collides with the 
player, the game ends.
- **Spikes** - Structures similar to walls but, when the player collides with it, the game ends.

### CONTROLS

'^' : moves hero up until he finds an obstacle as, for example, a wall or a spike.<br>
'<' : moves hero to the left until he finds an obstacle as,for example, a wall or a spike.<br>
'>' : moves hero to the right until he finds an obstacle as,for example, a wall or a spike.<br>
'v' : moves hero down until he finds an obstacle as, for example, a wall or a spike.<br>
'ESC' : press ESC to leave the level you are playing.<br>
'exit' : option in the menu to exit the game.

### PLANNED FEATURES

Power-ups:
- **Freeze**: Freezes all elements of the game except the player for 20 seconds.
- **Coin Magnet**: Collects all adjacent points, stars, coins.
- **Shield**: Protects players from one hit for 30 seconds.

Hazards:
- **Spikes**: Non-moveable elements that kills player if collides.
- **Dart Trap**: shoots darts from time to time that kills plays.

Elements:
- **Trampoline**: Bounces player to next wall according to the trampoline's location.
- **Teleporter**: Teleports player to connected teleporter, always appear as pairs.

### DESIGN

#### MODEL VIEW CONTROLLER (MVC)

This design is a good design for this project as it divides the responsibility of dealing with the display and 
business logic.Which provides for a better maintainability and extensibility.

- **Model**: Holds the current data and provides that data to the **View**.
- **Controller**: Brain of the operation, changes the **Model** data.
- **View**: Responsible for the display,get input from the user and send it to the **Controller**.

#### THE GAME NEEDS TO RUN IN A LOOP

**Problem in Context**

The game needs to run independent of the user input, changing it state from time to time.

**The Pattern**

The Pattern used was the **Game Loop** pattern.

**Implementation**

The following image represents how the solution was implemented in UML diagram.

![img.png](img.png)

**Consequences**

- The game loop needs to be taken in account for every new feature.
- It removes the dependence in the user input.

#### THE WHOLE GAME AND MENU IS DEPENDENT ON THEIR STATE

**Problem in Context**

There needed to be some logic related to the movement of each element to avoid unnecessary bloated conditional statements
in each one of the classes.

**The Pattern**

We then found a possible solution, use the **State** pattern. Using it, it is possible to determine which state the classes
are in a given moment and, using it, determine how should be the behavior of the game.

**Implementation**

The following image represents how the solution was implemented in UML diagram.

![state_pattern.png](images%2Fstate_pattern.png)

**Consequences**

The use of the State Pattern in the current design allows the following benefits:

- Eliminates the need for long conditional statements scattered throughout the code.
- The Controller is now mainly responsible for changing the current state (via creating another).
- More complex code.

### MOST VIEW ELEMENTS OF THE GAME HAVE SAME METHODS

**Problem in Context**
For the view Elements present in the game, they have the same methods. For that, it would lead to a lot of repetitive code.
Also for creating new elements into the game would need to modify the code which violates the **Open-Closed** Principle.

**The Pattern**

The **Prototype** pattern was used to solve this problem. With most of the elements deriving from the same superclass 
(*ElementView*) it is only necessary to implement those methods.

**Implementation**

The following image represents how the solution was implemented in UML diagram.

![prototype_pattern.png](images%2Fprototype_pattern.png)

**Consequences**

- Removes repetition in code.
- Facilitates extensibility.
- Respects the Open-Closed Principle.
- Increases number of classes.

### TESTING


### SELF-EVALUATION

- Afonso Moura: 33.3%
- Diogo Goiana: 33.3%
- Rubem Neto: 33.3%