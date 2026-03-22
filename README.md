# GameofSurvival
**- This simulation like "Game of Survival" that plays out on a grid.**
Humans (Green) trying to get to a Safe Zone (Cyan) without getting caught by Zombies (Red). If a Zombie "tags" a Human, that Human turns into a Zombie. But, if a Human finds a Weapon (Orange), they "level up" and become a Soldier (Blue).  Walls (Grey) are like locked doors that block the way for everyone. 

**- Game Rules**
The game ends when the number of steps reaches 0. The game starts with 50 steps and counts down to 0.

**- Points System**
+1 Human point if a Soldier kills a Zombie.
+1 Human point if a Human or Zombie reaches the Safe Zone.
+1 Zombie point if a Zombie tags a Human.

When the step limit (50 steps) is reached, the game compares the points of Humans and Zombies.
 + If Human points ≥ Zombie points, Humans win. Otherwise, Zombies win.

**-Simulation Features**
-The simulation can load a map from a file.
-It can also save the current map to an output file to store the game status.
-The saved output file can later be loaded to continue the simulation.
-The simulation can also reset the current map.
