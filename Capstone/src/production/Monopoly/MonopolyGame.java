package production.Monopoly;

import java.util.Random;
import java.util.ArrayList;
import java.util.List;
//import javax.swing.Icon; 
//import javax.swing.ImageIcon; //need for image of game piece

/**
 * MonopolyGame is a class that keeps track of available pieces for * players
 * and adds the players to the player list. MonopolyGame
 * controls the overall game and all rules of the original Monopoly
 * game are implemented here
 *
 */

public class MonopolyGame {

    private List<Player> players = new ArrayList<>();
    private List<Piece> pieces = new ArrayList<>();
    private int currentPlayerIndex = 0;
    private int dice1 = 1;
    private int dice2 = 1;
    private Board board = new Board();

    /**
     * This method creates a temporary list of the available game pieces that
     * were not already chose by a player
     *
     * @return piecesTemp which is the temporay list of available pieces
     */
    public List<Piece> getAvailablePieces() {
        List<Piece> piecesTemp = new ArrayList<>();
        for (int i = 0; i < pieces.size(); ++i) {
            piecesTemp.add(pieces.get(i));
        }

        for (int i = 0; i < players.size(); ++i) {
            piecesTemp.remove(players.get(i).getPiece());
        }

        return piecesTemp;

    }

    /**
     * The MonopolyGame constructor adds eight default game pieces
     *
     */
    public MonopolyGame() {
        pieces.add(new Piece("TopHat"));
        pieces.add(new Piece("Thimble"));
        pieces.add(new Piece("Battleship"));
        pieces.add(new Piece("wheelBarrow"));
        pieces.add(new Piece("Shoe"));
        pieces.add(new Piece("Dog"));
        pieces.add(new Piece("raceCar"));
        pieces.add(new Piece("Iron"));
    }

    /**
     * This method is the getPieceCount method it returns a int data type of the
     * number of gamePieces
     *
     * @return size of piece list
     */
    public int getPieceCount() {
        return pieces.size();
    }

    /**
     * This method is the getPiece method it returns the index of the piece list
     *
     * @param index is the number of game pieces
     * @return size of piece list
     */
    public Piece getPiece(int index) {
        return pieces.get(index);
    }

    /**
     * This method is the addPlayer method it adds the player to the player list
     *
     * @param name          is the name of the player
     * @param selectedPiece is the gamepiece the player chose
     */
    public void addPlayer(String name, Piece selectedPiece) {
        Player player = new Player(name, 1500, selectedPiece, this);
        players.add(player);
    }

    /**
     * This method is the getPlayer method it returns the player
     *
     * @param index is the number of the player
     * @return player
     */
    public Player getPlayer(int index) {
        return players.get(index);
    }

    /**
     * This method is the performTurn method it moves the currentPlayer around the
     * board according to the dice roll then switches to the next player
     *
     */
    public void performTurn() {

        Player currentPlayer = players.get(currentPlayerIndex);

        int position = currentPlayer.getPosition();
        position = (position + dice1 + dice2) % 40;
        currentPlayer.setPosition(position);

    }

    /**
     * This method switches to the next player after perform turn is completed
     *
     */
    public void changePlayer() {
        currentPlayerIndex++;
        currentPlayerIndex = currentPlayerIndex % players.size();
    }

    /**
     * This method is the getCurrentPlayer it gets the current Player that is
     * performing their turn
     *
     * @return currentPlayer
     */
    public int getCurrentPlayerIndex() {
        return currentPlayerIndex;
    }

    /**
     * This method is the getDice1 it gets the value of dice 1
     *
     * @return dice1
     */
    public int getDice1() {
        return dice1;
    }

    /**
     * This method is the getDice2 it gets the value of dice 2
     *
     * @return dice2
     */
    public int getDice2() {
        return dice2;
    }

    /**
     * This method is the rollDice it generates a random number between 1 and 6 for
     * 2 six sided dices
     *
     */
    public void rollDice() {
        Random randomDiceGen = new Random();
        dice1 = randomDiceGen.nextInt(6) + 1;
        dice2 = randomDiceGen.nextInt(6) + 1;
    }

    /**
     * This method is the getSquareAt it uses the board to get the position of the
     * square the current player is on
     * 
     * @param position is the position of the player
     * @return result
     */
    public Square getSquareAt(int position) {
        Square result = board.getSquareAt(position);
        return result;
    }

    /**
     * This method is willPassGo checks the players postion compared to their next
     * to see if they will pass "go"
     * 
     * @param currentPlayer the player passing go
     * @return false if nextPosition is not less than current
     */

    public boolean willPassGo(Player currentPlayer) {
        int nextPosition = currentPlayer.getPosition();

        nextPosition = (nextPosition + dice1 + dice2) % 40;
        if (nextPosition < currentPlayer.getPosition()) {
            return true;
        }

        return false;
    }

    /**
     * This method is checkPassingGo checks willPassGo returns true and adds 200 to
     * players current balance
     * 
     * @param currentPlayer the player passing go
     */
    public void checkPassingGo(Player currentPlayer) {
        if (willPassGo(currentPlayer) == true) {
            currentPlayer.setBalance(currentPlayer.getBalance() + 200);
            System.out.println("Your balance is now " +currentPlayer.getBalance()); 
        }
    }

    /**
     * This method is used to set the dice for automated testing
     * 
     * @param d1 is dice1
     * @param d2 is dice2
     */
    public void setDice(int d1, int d2) {
        dice1 = d1;
        dice2 = d2;
    }
    /**
     * This method is used to check if a player is on sqaure 30 and if they are it sends them to jail square 10
     * 
     * @param currentPlayer is the player being sent to jail
     * 
     */ 
  public void checkGoToJail(Player currentPlayer){
  if(currentPlayer.getPosition() == 30){
  currentPlayer.setPosition(10);
    currentPlayer.setIsInJail(true);
    System.out.println("You are currently in jail");
  }
  }
}
