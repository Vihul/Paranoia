Paranoia
----------
Bitcamp 2018 Project


This program is meant to keep track of the game state of a game of Paranoia, a game in which people are given targets and words and must make their target say their assigned word.

---

## Commands

(for these commands, omit the '' around the fields in the actual command)

* "add_player 'name'": adds a new player to the list of players that will be in the game and gives it a name of 'name'.
* "create_game": creates the game. This should be run *after* adding all of the players. This will assign all of the players random words and targets.
* "print_list": prints the current game state with players, their targets,
* "kill_player 'name'": removes player 'name' from the game, awards their killer with points, and assigns the killer a new target and word.
* "target_killed 'name'": removes <name>'s target from the game and awards <name> with points and assigns them a new target and word.
* "quit": exits the program
