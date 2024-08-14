package production.Monopoly;

/**
 * Square is a class that is used to create a name for each square
 * 
 */
public class Square {
    private String name;

    /**
     * The Square constructor creates a name for each square object
     * @param aName the name of the square
     */
    public Square(String aName) {
        name = aName;
    }

    /**
     * This method is the getName it gets the name of the square
     * 
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * This method is the toString it returns the string
     * representation of the square object
     * 
     * @return name
     */
    public String toString() {
        return name;
    }
}
