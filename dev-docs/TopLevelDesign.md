Object Oriented Architecture

Idea-Java only swing-based gui interface using object-oriented architecture.

For Object Oriented Programming, it relies mainly around classes, methods, and their attributes. My Program will consist of a couple different classes such as MonopolyGame, Player, Piece, and Property.

MonopolyGame class
----------------------
List of players

List of pieces

currentPlayer

Player getPlayer(int index);

MonopolyGame(int numberOfPlayers)

List<Piece> getAvailablePieces();

nextPlayer();

rollDice();

getPropertiesWithinGroup(colorGroup);

TurnStatus performTurn();  --> roll the dice, moves the current player forward that number of squares, if the player passes go, give $200
                               Whichever property the current player lands on,the cost of rent is deducted from the current player's 
                               balance.Returns the current player's status, indicating 
                                they paid rent, cannot afford rent, have to go to jail, landed
                                on a Chance square, etc.
                                detect if player landed on "go to jail" set isInJail flag accordingly(players do 
                                not pay rent can roll to get out or pay the fine)

Player class
------------------
-name

-piece

-balance

-position

-ownedProperties

-isInJail

setPiece(Piece)

getBalance()

setBalance()

getIsInJail()

setIsInJail()  

Piece class
-----------------
-name

-icon

Piece(String name, Icon icon);

String getName()

Icon getIcon()

Property class
-----------------
 - name
 - price
 - color group
 - owner
 - number of houses
 - int rentByNumberHouses[6] 	--> 6 different values for the rent (0 through 5 houses)
   
 - Player getOwner() --> returns null if not owned
   
  boolean ownerHasGroup()
  
  purchaseProperty()
  
  purchaseHouse();   <-- increases number of houses
                         and charges the owner
			 
  int getRent()

	               
![image](https://github.com/user-attachments/assets/1421ef3a-a57e-41a0-8792-a00559ccf5d3)


            




