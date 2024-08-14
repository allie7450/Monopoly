package production.Monopoly;

import java.util.List;

import java.util.ArrayList;

/**
 * Player is a class that is used to create a player with their assosiciated
 * name, name, balance, position, gamepiece, and properties
 *
 */
public class Player {

    private String name;
    private int balance;
    private int position;
    private Piece piece;
    private boolean isInJail;
    List<Property> ownedProperties;
    private MonopolyGame game;

    /**
     * This method is setting the current piece to a piece variable
     *
     *
     * @param aPiece the gamepiece to be set
     *
     */
    public void setPiece(Piece aPiece) {
        piece = aPiece;
    }

    /**
     * This method gets the game piece that the player chose
     *
     *
     * @return game piece of the player
     */
    public Piece getPiece() {
        return piece;
    }

    /**
     * This method is the Player class constructor, it creates Player object
     * with given parameters.
     *
     * @param aName    the name of player
     * @param aBalance the balance of the player
     * @param aPiece   the gamepiece the player chose
     * @param game     players have reference to game
     */
    public Player(String aName, int aBalance, Piece aPiece, MonopolyGame game) {
        name = aName;
        balance = aBalance;
        piece = aPiece;
        isInJail = false;
        ownedProperties = new ArrayList<Property>();
        position = 0;
        this.game = game;
    }

    /**
     * This method is the getBalance method it returns a int data type of the
     * balance of the player
     *
     * @return balance of the player
     */
    public int getBalance() {
        return balance;
    }

    /**
     * This method is the setBalance method it updates the players current
     * balance
     *
     *
     * @param newBalance is an int data type representing the updated balance
     */
    public void setBalance(int newBalance) {
        balance = newBalance;
    }

    /**
     * This method is the getPosition method it gets players position in the
     * game
     *
     * @return position is an int data type representing current position of
     *         player
     */
    public int getPosition() {
        return position;
    }

    /**
     * This method is the setPosition method it updates the players current
     * position
     *
     *
     * @param newPosition is an int data type representing the updated position
     */
    public void setPosition(int newPosition) {
        position = newPosition;
    }

    /**
     * This method is the getOwnedProperties method it is a list of properties
     *
     *
     * @return ownedProperties is a list representing the properties owned
     */
    public List<Property> getOwnedProperties() {
        return ownedProperties;
    }

    /**
     * This method is the setOwnedPropertiesmethod it updates the list of owned
     * properties
     *
     *
     * @param newOwnedProperties is a list showing the updated owned properties
     */
    public void setOwnedProperties(List<Property> newOwnedProperties) {
        ownedProperties = newOwnedProperties;
    }

    /**
     * This method is checking to see if a player is in jail by returning a
     * boolean data type
     *
     * @return isInJail returns true if the player is in jail
     */
    public boolean getIsInJail() {
        return isInJail;
    }

    /**
     * This method is setting the IsInJail flag if a player is in jail
     *
     *
     * @param newIsInJail updates the isInJail flag
     */
    public void setIsInJail(boolean newIsInJail) {
        isInJail = newIsInJail;
    }

    /**
     * This method is the getName method it returns a string data type of the
     * name of the player
     *
     * @return name of the player
     */
    public String getName() {
        return name;
    }

    /**
     * This method is setting the name of the player
     *
     *
     * @param newName is the name of the player
     */
    public void setName(String newName) {
        name = newName;
    }

    /**
     * This method is adding property to the ownedProperties list
     *
     *
     * @param property is the property being added
     */
    public void addProperty(Property property) {
        ownedProperties.add(property);
    }

    /**
     * This method is checking to see if the player owns a full colorgroup of a
     * property
     *
     *
     * @param color is the colorGroup of the property
     * @return true or false
     */
    public boolean ownsColorGroup(Property.colorGroup color) {
        for (int i = 0; i < 40; i++) {
            if (game.getSquareAt(i) instanceof Property) {

                Property prop = (Property) game.getSquareAt(i);

                if (prop.getColor() == color && prop.getOwner() != this) {
                    return false;
                }
            }
        }
        return true;
    }

}
