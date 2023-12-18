## LDTS_G1102 - SIMPLE TOMB OF THE MASK

In this game your task is to avoid the hazards trying to kill you and make it to the end of the levels. Sliding into walls
and trying to avoid imminent danger.

This game was developed by *Afonso Moura(*up202207931*@fe.up.pt)*,*Rubem Neto* (*up202207086*@fe.up.pt), *Diogo Goiana*(*up202207944*@fe.up.pt)

### TECHNOLOGIES USED
- Java Language
- Lanterna Framework
- Pitest
- Mockito
- Error-prone from Google

### IMPLEMENTED FEATURES

- **Sliding** - The character slides into a wall to move when any of the move keys are pressed.
- **Different Levels** - When the player gets to the end of a level, another level appears (up to 10 levels)
- **Bats** - These are little bats that move in a random starting direction (left or right) and if it collides with the 
player, the game ends.
- **Spikes** - Structures similar to walls but, when the player collides with it, the game ends.
- **Dart Trap** - Shoot darts from time to time that hits the player.
- **PowerUps**:
  - Freeze - Freezes only bats for 5 seconds.
  - Coin Magnet - Collects all adjacent collectables (Coins,Starts,Points) for 10 seconds.
  - Shield - Protects player for one hit for 10 seconds.
- **Trampoline** - Bounces player to the next wall in a direction (UP,DOWN,LEFT,RIGHT).
- **Store** - The player can buy a range of different skins, using collected coins during gameplay.

### CONTROLS

'^' : moves mask up until he finds an obstacle as, for example, a wall or a spike.<br>
'<' : moves mask to the left until he finds an obstacle as,for example, a wall or a spike.<br>
'>' : moves mask to the right until he finds an obstacle as,for example, a wall or a spike.<br>
'v' : moves mask down until he finds an obstacle as, for example, a wall or a spike.<br>
'ESC' : press ESC to leave the level you are playing.<br>
'exit' : option in the menu to exit the game.

### PLANNED FEATURES

Power-ups:
- **Freeze**: Freezes all elements of the game except the player for 20 seconds.
- **Coin Magnet**: Collects all adjacent points, stars, coins.
- **Shield**: Protects player from one hit for 30 seconds.

Hazards:
- **Spikes**: Non-moveable elements that kills player if collides.
- **Dart Trap**: Shoots darts from time to time that kills plays.

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

![placeholder.png](images%2Fplaceholder.png)

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

- Eliminates the need for long conditional statements scattered throughout the code.
- The Controller is now mainly responsible for changing the current state (via creating another).
- More complex code.

### Interaction with the Laterna Framework is complicated

**Problem in Context**

Making direct calls into a dozen of different frameworks can make the code messy. From the screen to the text calls for 
different frameworks are needed.

**The Pattern**

For this problem, the **Facade** pattern was used which encapsulates all the external dependencies into the GUI class 
simplifying the development.

**Implementation**

![placeholder.png](images%2Fplaceholder.png)

**Consequences**

- Simpler code.
- Increased dependency on abstractions.
- More predictable code.

### PowerUps implement the same method in a slightly different way

**Problem in Context**

The powerUps classes are responsible for implementing the same method in different ways. Then having one class for each
powerUps would make the code repetitive and harder to maintain.

**The Pattern**

The **Strategy** pattern was used to solve this problem. With this pattern each powerUp is defined as a strategy to define
a different behavior for the same method.

**Implementation**

![placeholder.png](images%2Fplaceholder.png)

**Consequences**

- Removes repetition in code.
- Facilitates extensibility.
- Respects the Open-Closed Principle.

### Draw method can be called for a list of Elements or a single Element

**Problem in Context**

When the arena is drawn, the draw method is called for each element present in the arena, but some of them are stored
in a list of elements (Bats,Walls,Spikes) and others are stored as a single element (Mask,endLevel), creating the need of
two different functions that are essentially doing the same.

**The Pattern**

The **Composite** pattern seemed to be the best solution for this problem, because, using this strategy, there is no 
difference between a composite or a leaf (single element).

**Implementation**

![placeholder.png](images%2Fplaceholder.png)

**Consequences**

- Makes code depend more on abstractions.
- Increases the complexity of the code.

### Increase number of State classes create more confusing code

**Problem in Context**

During development more and more state classes needed to be defined, but in the previous state of the codebase, a lot of
code is repeated and more importantly a lot of dependencies needed to be dealt with.

**The Pattern**

The **Factory Method** patter was used to solve this problem. Having this design pattern helped when extending the complexity
of the game and its features, since a new State Class, at some point, is going to be declared.

**Implementation**

![placeholder.png](images%2Fplaceholder.png)

**Consequences**

- More complex code
- Increased number of classes
- Guarantees Single Responsibility Principle

### TESTING

![img.png](images%2Fpitest.png)

[Pitest](pitest/index.html)

**The current coverage is not 100% because:**
- Some of the methods of the GUI are exclusively responsible by the Laterna Framework which cannot be tested using any of
the strategies presented in lectures.

**Code Smells present in the project:**

- Switch statements
- Dead code
- Speculative Generality
- Message Chains (drawModel -> drawGame -> draw)

### SELF-EVALUATION

- Afonso Moura: 33.3%
- Diogo Goiana: 33.3%
- Rubem Neto: 33.3%