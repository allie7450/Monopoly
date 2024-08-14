

package production.Monopoly;

/**
 * Board is a class that is used to create a squares on the board with their
 * associated
 * name
 */
public class Board {
    private Square squares[];

    /**
     * The Board constructor adds 40 default squares onto the gameBoard
     *
     */
    public Board() 
    {
        squares = new Square[40];
      
        squares[0] = new Square("GO");
      
        squares[1] = new Property("Mediterranean Avenue", 60, Property.colorGroup.BROWN, 50, new int[] { 2, 10, 30, 90, 160, 250 });
      
        squares[2] = new Square("Community Chest");
        squares[3] = new Property("Baltic Avenue", 60, Property.colorGroup.BROWN, 50, new int[] { 4, 20, 60, 180, 320, 450 });
        squares[4] = new Square("Income Tax");
        squares[5] = new Property("Reading Railroad", 200, Property.colorGroup.RAILROAD, 0, new int[] { 0, 25, 50, 100, 200 });
        squares[6] = new Property("Oriental Avenue", 100, Property.colorGroup.LIGHTBLUE, 50, new int[] { 6, 30, 90, 270, 400, 550 });
        squares[7] = new Square("Chance");
        squares[8] = new Property("Vermont Avenue", 100, Property.colorGroup.LIGHTBLUE, 50, new int[] { 6, 30, 90, 270, 400, 550 });
        squares[9] = new Property("Connecticut Avenue", 120, Property.colorGroup.LIGHTBLUE, 50, new int[] { 8, 40, 100, 300, 450, 600 });
        squares[10] = new Square("Jail");
        squares[11] = new Property("St. Charles Place", 140, Property.colorGroup.PINK, 100, new int[] { 10, 50, 150, 450, 625, 750 });
        squares[12] = new Property("Electric Company", 150,Property.colorGroup.UTILITY, 0, new int[] {0, 5, 10});
        squares[13] = new Property("States Avenue", 140, Property.colorGroup.PINK, 100, new int[] { 10, 50, 150, 450, 625, 750 });
        squares[14] = new Property("Virgina Avenue", 160, Property.colorGroup.PINK, 100, new int[] { 12, 60, 180, 500, 700, 900 });
        squares[15] = new Property("Pennslyvannia Railroad", 200, Property.colorGroup.RAILROAD, 0, new int[] { 0, 25, 50, 100, 200 });
        squares[16] = new Property("St. James Place", 180, Property.colorGroup.ORANGE, 100, new int[] { 14, 70, 200, 550, 750, 950 });
        squares[17] = new Square("Community Chest");
        squares[18] = new Property("Tenesee Avenue", 180, Property.colorGroup.ORANGE, 100, new int[] { 14, 70, 200, 550, 750, 950 });
        squares[19] = new Property("New York Avenue", 200, Property.colorGroup.ORANGE, 100, new int[] { 16, 80, 220, 600, 800, 1000 });
        squares[20] = new Square("Free Parking");
        squares[21] = new Property("Kentucky Avenue", 220, Property.colorGroup.RED, 150, new int[] { 18, 90, 250, 700, 875, 1050 });
        squares[22] = new Square("Chance");
        squares[23] = new Property("Indiana Avenue", 220, Property.colorGroup.RED, 150, new int[] { 18, 90, 250, 700, 875, 1050 });
        squares[24] = new Property("Illinois Avenue", 240, Property.colorGroup.RED, 150, new int[] { 20, 100, 300, 750, 925, 1100 });
        squares[25] = new Property("B & O Railroad", 200, Property.colorGroup.RAILROAD, 0, new int[] { 0, 25, 50, 100, 200 });
        squares[26] = new Property("Alantic Avenue", 260, Property.colorGroup.YELLOW, 150, new int[] { 22, 110, 330, 800, 975, 1150 });
        squares[27] = new Property("Ventnor Avenue", 260, Property.colorGroup.YELLOW, 150, new int[] { 22, 110, 330, 800, 975, 1150 });
        squares[28] = new Property("Water Works", 150,Property.colorGroup.UTILITY, 0, new int[] {0, 5, 10});
        squares[29] = new Property("Marvin Gardens", 280, Property.colorGroup.YELLOW, 150, new int[] { 24, 120, 360, 850, 1025, 1200 });
        squares[30] = new Square("Go To Jail");
        squares[31] = new Property("Pacific Avenue", 300, Property.colorGroup.GREEN, 200, new int[] { 26, 130, 390, 900, 1100, 1275 });
        squares[32] = new Property("North Carolina Avenue", 300, Property.colorGroup.GREEN, 200, new int[] { 26, 130, 390, 900, 1100, 1275 });
        squares[33] = new Square("Community Chest");
        squares[34] = new Property("Pennslyvannia Avenue", 320, Property.colorGroup.GREEN, 200, new int[] { 28, 150, 450, 1000, 1200, 1400 });
        squares[35] = new Property("Short Line", 200, Property.colorGroup.RAILROAD, 0, new int[] { 0, 25, 50, 100, 200 });
        squares[36] = new Square("Chance");
        squares[37] = new Property("Park Place", 350, Property.colorGroup.BLUE, 200, new int[] { 35, 175, 500, 1100, 1300, 1500 });
        squares[38] = new Square("Luxury Tax");
        squares[39] = new Property("Board Walk", 400, Property.colorGroup.BLUE, 200, new int[] { 50, 200, 600, 1400, 1700, 2000 });
    }

    /**
     * This method is the getSquareAt it gets the square at any
     * position
     * 
     * @param position is the position of the desired square
     * @return squares[position]
     */
    public Square getSquareAt(int position) {
        return squares[position];
    }
}
