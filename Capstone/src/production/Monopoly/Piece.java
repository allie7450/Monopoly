package production.Monopoly;
//import javax.swing.Icon;

/**
 * Piece is a class that is used to create a gamePiece with their associated
 * name and their icon
 *
 */
public class Piece {

    private String name;
    //private Icon icon;

    /**
     * This is the Piece class constructor, it creates Piece object with given
     * parameters.
     *
     * @param aName the name of a piece
     */
    public Piece(String aName) {
        name = aName;
        //icon = aIcon;
    }

    /**
     * The getName method it returns a string data type of the name of the game
     * piece
     *
     * @return name of the game piece
     */
    public String getName() {
        return name;
    }

    /**
     * This method is the setName it updates the name of the players gamepiece
     *
     *
     * @param newName is an String data type representing the updated name of
     * the players gamepiece
     */
    public void setName(String newName) {
        name = newName;
    }
    /**
     * This method is the getIcon method it returns the icon of the Piece object
     * that is associated with it
     *
     * @return icon
     */
    //  public Icon getIcon() {
    //     return icon;
    //}
}
