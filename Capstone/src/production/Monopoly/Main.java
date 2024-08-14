package production.Monopoly;

import java.util.Scanner;
import java.util.ArrayList;

/**
 * This class is the entry point of the MonopolyGame program it interacts with
 * the user to recieve their input of how many players, the player's name, and
 * the desired gamepiece
 * 
 */
public class Main {

    private static int numberOfPlayers;
    /**
     * mg is the monopolygame
     */
    public static MonopolyGame mg;
    private static Scanner userInput;

    /**
     * beginGame initalizes the game based on user input and establishes how many
     * players are in the game with their name and gamepiece
     * 
     *
     */
    public static void beginGame() {
        System.out.println("How Many players are there? (2-8 can play)");
        numberOfPlayers = userInput.nextInt();
        while (numberOfPlayers < 2 || numberOfPlayers > 8) {
            System.out.println("Invalid input. Please enter a number between 2-8");
            numberOfPlayers = userInput.nextInt();
        }

        for (int i = 0; i < numberOfPlayers; i++) {
            userInput.nextLine();
            System.out.println("Please type in your name ");
            String name = userInput.nextLine();
            boolean validChoice = false;
            Piece selectedPiece = null;
            while (!validChoice) {
                System.out.println(
                        "Please chose your game piece: 1- TopHat, 2-Thimble, 3-Battleship, 4-wheelBarrow, 5-Shoe, 6-dog, 7-raceCar, 8-iron");
                int gamePiece = userInput.nextInt();

                if (gamePiece >= 1 && gamePiece <= 8) {
                    selectedPiece = mg.getPiece(gamePiece - 1);
                    if (mg.getAvailablePieces().contains(selectedPiece)) {
                        validChoice = true;
                    }

                }
                if (!validChoice) {
                    System.out.println("Try again");
                }

            }

            mg.addPlayer(name, selectedPiece);
            System.out.println("player: " + name + " piece: " + selectedPiece.getName());
        }

    }

    /**
     * runGame runs play loop until all but one player is bankrupt, granting each
     * player a turn to roll the dice and move on the gameboard
     * 
     * @return false if user does not chose -1 to end game
     */
    public static boolean runGame() {
        boolean gameOver = false;
        int bankruptCount = 0;
        while (!gameOver) {
            int currentPlayerIndex = mg.getCurrentPlayerIndex();

            Player currentPlayer = mg.getPlayer(currentPlayerIndex);

            System.out.println("It is now Player " + currentPlayer.getName() + "'s turn.");
            System.out.println("You own these properties: " + currentPlayer.getOwnedProperties());
            if (currentPlayer.getIsInJail() == true) {
                optionToLeaveJail(currentPlayer);
            }
            if (currentPlayer.getIsInJail() == false) {
                System.out.println("To Roll the dice please click 1. To quit game please click -1");
                int input = userInput.nextInt();
                if (input == -1) {
                    return true;
                }
                while (input != 1) {
                    System.out.println("To Roll the dice please click 1");
                    input = userInput.nextInt();
                }
                mg.rollDice();
                System.out.println("You have rolled " + mg.getDice1() + " and " + mg.getDice2());
                mg.checkPassingGo(currentPlayer);
                mg.performTurn();
                System.out.println("You landed on " + mg.getSquareAt(currentPlayer.getPosition()));
                mg.checkGoToJail(currentPlayer);
                if (mg.getSquareAt(currentPlayer.getPosition()) instanceof Property) {

                    Property prop = (Property) mg.getSquareAt(currentPlayer.getPosition());

                    if (prop.getOwner() == currentPlayer) {
                        System.out.println("You already own this property.");
                    } else if (prop.getOwner() != null) {
                        chargeRent(currentPlayer, prop);
                    } else {
                        purchaseProperty(currentPlayer, prop);
                    }

                }
            }

            optionToBuyHouses(currentPlayer);

            mg.changePlayer();

            for (int i = 0; i < numberOfPlayers; i++) {
                Player p = mg.getPlayer(i);
                if (p.getBalance() <= 0) {
                    bankruptCount++;
                    System.out.println(p.getName() + " is bankrupt");
                }
            }

            if (bankruptCount == numberOfPlayers - 1)
                gameOver = true;

        }
        return false;
    }

    /**
     * chargeRent charges rent to each player when they land on an owned property
     * 
     * @param currentPlayer is the current player
     * @param prop          is the property they are being charged for
     */
    public static void chargeRent(Player currentPlayer, Property prop) {
        int rent = prop.getRent(mg.getDice1(), mg.getDice2());
        prop.payRent(mg.getDice1(), mg.getDice2(), currentPlayer);
        System.out.println("The Player: " + currentPlayer.getName() + " was charged: " + rent);

    }

    /**
     * purchaseProperty checks to see if the property is already owned if it is not
     * owned
     * it gives the option to buy that property then displays the properties
     * that user owns
     * 
     * @param currentPlayer is the current player
     * @param prop          is the property
     */
    public static void purchaseProperty(Player currentPlayer, Property prop) {

        if (prop.getOwner() != null) {
            System.out.println("This property is already owned by " + prop.getOwner().getName());
        } else if (currentPlayer.getBalance() < prop.getPrice()) {
            System.out.println("You do not have sufficent funds to purchase");
        } else {
            System.out.println("Would you like to buy this property?");
            System.out.println("1-Buy Property, 2-Do not Buy");
            int input = userInput.nextInt();

            if (input == 1) {
                prop.buyProperty(currentPlayer);
                System.out.println("You own these properties: " + currentPlayer.getOwnedProperties());

            }
        }

    }

    /**
     * optionToBuyHouses checks to see if the user wants to buy a house on a full
     * colorgroup property and then prompts the user to chose which property they
     * want to buy the house on
     * 
     * @param currentPlayer is the current player
     */
    public static void optionToBuyHouses(Player currentPlayer) {

        ArrayList<Property> buildableProperties = new ArrayList<Property>();
        for (Property property : currentPlayer.getOwnedProperties()) {
            if (currentPlayer.ownsColorGroup(property.getColor()) == true) {
                buildableProperties.add(property);

            }
        }

        if (buildableProperties.isEmpty()) {
            return;
        }

        System.out.println("Would you like to buy houses on your properties");
        System.out.println("1-Buy House, 2-Do not Buy");
        int input = userInput.nextInt();

        if (input == 1) {

            for (int i = 0; i < buildableProperties.size(); i++) {
                System.out.println(i + ":" + buildableProperties.get(i));
            }
            System.out.println("Please select which property you would like to buy a house on:");
            input = userInput.nextInt();
            buildableProperties.get(input).buyHouse(currentPlayer);
        }
    }

    /**
     * hasWon checks to see who has won the monopolyGame by seeing which player has
     * a positive balance and then displays it
     * 
     */
    public static void hasWon() {
        for (int i = 0; i < numberOfPlayers; i++) {
            Player p = mg.getPlayer(i);
            if (p.getBalance() > 0) {
                System.out.println(p.getName() + " has won!! Congrats");
                break;
            }
        }
    }

    /**
     * initialize initializes the monopolyGame and userInput
     * 
     * 
     */
    public static void initialize() {
        mg = new MonopolyGame();
        userInput = new Scanner(System.in);
    }

    /**
     * This method is option to leave jail it prompts the current player who is in
     * jail to pay a fine or roll doubles
     *
     * @param currentPlayer is the player
     *
     */
    public static void optionToLeaveJail(Player currentPlayer) {
        System.out.println(
                "You are currently in jail. Would you like to 1) Pay a $50 fine to get out now, or 2) attempt to roll a double?");

        int jailInput = userInput.nextInt();

        while (jailInput != 1 && jailInput != 2) {
            System.out.println(
                    "You are currently in jail. Would you like to 1) Pay a $50 fine to get out now, or 2) attempt to roll a double?");

            jailInput = userInput.nextInt();

        }
        if (jailInput == 2) {
            mg.rollDice();
            System.out.println("You rolled: " + mg.getDice1() + " and " + mg.getDice2());
            if (mg.getDice1() == mg.getDice2()) {

                currentPlayer.setIsInJail(false);
                System.out.println("You are now out of jail");
            }
        } else if (jailInput == 1) {
            currentPlayer.setBalance(currentPlayer.getBalance() - 50);
            currentPlayer.setIsInJail(false);
            System.out.println("You are now out of jail");
        }
    }

    /**
     * This method is the main method, and it is running the monopoly game
     *
     * @param args is parameter for main
     *
     */

    public static void main(String[] args) {

        initialize();

        System.out.println("Welcome to Monopoly!!");
        System.out.println("Menu: 1-Play game, 2-Quit");
        int menuChoice = userInput.nextInt();

        if (menuChoice == 1) {
            beginGame();
            boolean result = runGame();
            if (result == true) {
                System.out.println("player has quit");
            } else {
                hasWon();
            }

        }

        userInput.close();
    }
}
