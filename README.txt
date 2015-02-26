This is a game of battleships that uses Java swing for its GUI and some design patterns for the game engine. There are two
options, easy -- computer is random, and hard -- computer makes AI move. Also, there are options on the size of the board and
the number of ships. The board and game use factory pattern to construct whichever of the choices the user picks. The strategy
pattern is used for the difficulty. That way, if the code needs maintenance (such as adding an algorithm or editing one of the 
existing ones) it is easy to maintain. Finally, since there are a lot of classes to this project, I use the facade pattern in 
order to simplify the code in the "front-end" of the program. Go ahead! Challenge the computer and see how good you're in battleships!
