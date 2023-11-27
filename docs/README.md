# ldts-project-assignment-l11gr02

# We present to you our version of Tomb of the Mask!

<img src="begin.jpg" alt="Begin" width="300">

## Table of contents

- [Controls](#controls)
- [Implemented Features](#implemented-features)
    - [Menu](#menu)
    - [Hero movement](#hero)
    - [Enemies](#enemies)
    - [Collisions](#collisions)
    - [Levels](#levels)
    - [End of Level and Game](#end-of-level-and-game)
    - [Future plans](#future-plans)
- [Design Patterns](#design-patterns)
    - [State Pattern](#state-pattern)
    - [Future plans](#future-plans)
- [Tests](#tests)


## Controls

'^' : moves hero up until he finds an obstacle as, for example, a wall or a spike.<br>
'<' : moves hero to the left until he finds an obstacle as,for example, a wall or a spike.<br>
'>' : moves hero to the right until he finds an obstacle as,for example, a wall or a spike.<br>
'v' : moves hero down until he finds an obstacle as, for example, a wall or a spike.<br>
'ESC' : press ESC to leave the level you are playing.<br>
'exit' : option in the menu to exit the game.

## Implemented features

### Menu

When starting the program, appears an initial menu where the user can choose to start playing or exit the game.
- Play;
- Exit;

### Hero movement

Our hero moves using arrow keys. If the player wants to keep moving in the same direction he will only need to press one time the arrow key in the desired direction.
In other words, the hero is going to move in the direction chosen until he bumps into an obstacle. Then, he waits for a new
input. The class that handles with the input from the user and makes it move is 
HeroController.

### Enemies

In our game, there are static and dynamic enemies. The static one is the spike. When the hero touches the spike,
the game is over. The same happens with the bat, which instead is a dynamic enemy (moves in a random direction: left or right).
If the hero touches it, the game is over.

### Collisions

There are implemented many types of collisions:
- Hero and the walls, which prevents Hero from moving and passing through walls.
- Hero and spikes, which leads to the end of the game.
- Hero and bats, which leads to the end of the game.
- Bats and the walls, which prevents the bats from moving through walls.

The collision methods are implemented in the class Arena.

### Levels

For now, 3 levels were designed. If the player passes all levels, he wins the game.

### End of Level and Game

In each level, the player must take the hero to the end of the level, which is in our game an "e".
In the final of the three levels, if the player passed successfully them, he wins the game,
and, logically, it is the end of it.

### Future plans

We intend to introduce the following features:
* Power-ups:
  * Freeze: Freezes all elements of the game except the hero for 20 seconds;
  * Coin Magnet: Collects all adjacent points, stars, coins;
  * Shield: Protects hero for 30 seconds.
* Hazards:
  * Dart Trap: shoots darts from time to time that could kill the hero.
* Trampoline: Bounces hero to next wall according to the trampoline's location.
* Teleporter: Teleports hero to connected teleporter, always appear as pairs.

## Design Patterns

### State Pattern

State Pattern was used when an Object changes its behavior based on its internal state. In more detail, this 
design pattern was used to provide a systematic and loosely-coupled way to achieve the change of the behaviour of an
Object based on its state through context and state implementations.

### Future plans

* Strategy pattern for coins/points/stars;
* Observer pattern for collectable (coins/points/stars and power-ups) collection;
* Request for different power-ups (each of them make a different request);
* Perhaps a Command pattern for event handling.
* And, lastly, a Prototype for the elements (already being used)

## Tests

There were implemented several tests in order to check some methods of the classes created.
In the second delivery, we intend to make use of existing applications, like Jacoco and Pitest, 
to ensure code coverage and the quality of the tests.


