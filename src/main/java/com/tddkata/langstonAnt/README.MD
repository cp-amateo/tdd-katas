# Ants Kata

## Introduction 
Considering the rules:
* At a white square turn 90° clockwise (R), flip the colour of the square, move forward one unit.
* At a black square, turn 90° counter-clockwise (L), flip the colour of the square, move forward one unit.

This is how the first 200 steps of the ant would look like with the rules above (using the notation 'RL'):

[ant-example]: https://upload.wikimedia.org/wikipedia/commons/0/09/LangtonsAntAnimated.gif
"Ant example"
  ![ant-example][ant-example]

## Rules
* The sequence passed must have at least 2 characters, like 'RL', which will be looped for the defined number of steps.
* All squares start as white.
* The grid should be odd sized so that the ant can be placed in the center.
* The grid must be shown after every step so we can observe it.
* We must be able to stop the code after x iterations.

## Harder version
To make things more interesting we can change the amount of colours we are using. The colours are modified in a cyclic fashion. A simple naming scheme is used for each of the successive colours, a letter "L" or "R" is used to indicate whether a left or right turn should be taken. Langton's ant has the name "RL" in this naming scheme.

If you decide to implement an hexagonal grid for example, you open up the following notations as well:
* U turns 180°
* R1 turns 60° clockwise
* R2 turns 120° clockwise
* L1 turns 60° counter-clockwise
* L2 turns 120° counter-clockwise
This allows you to create interesting visualisations, such as R1R2NUR2R1L2: