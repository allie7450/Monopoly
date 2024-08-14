package production.Monopoly;

/**
 * Property is a class that is used to create properties for players to purchase
 * throughout the game
 * 
 */
public class Property extends Square {
    /**
     * enum is a class lists the different color groups for the
     * properties in the game such as PINK, ORANGE, RED, YELLOW,
     * GREEN, BLUE, BROWN, LIGHTBLUE, RAILROAD, UTILITY
     * 
     */
    public enum colorGroup {
        /**
         * PINK color
         */
        PINK,
        /**
         * Orange color
         */
        ORANGE,
        /**
         * Red color
         */
        RED,
        /**
         * yellow color
         */
        YELLOW,
        /**
         * green color
         */
        GREEN,
        /**
         * blue color
         */
        BLUE,
        /**
         * brown color
         */
        BROWN,
        /**
         * lightblue color
         */
        LIGHTBLUE,
        /**
         * Railroad
         */
        RAILROAD,
        /**
         * utility
         */
        UTILITY

    }

    private Player owner = null;
    private int price;
    private colorGroup color;
    private int numOfHouses = 0; // 5 houses is 1 hotel
    private int housePrice;
    private int[] rents;

    /**
     * This method is the Property class constructor, it creates Propety object
     * with given parameters.
     *
     * @param propertyName the name of the property
     * @param aPrice       the price of the property
     * @param aColor       the color of the property
     * @param aHousePrice  the house price on a property
     * @param aRents array of rents for 0 to 5 houses
     */
    public Property(String propertyName, int aPrice, colorGroup aColor, int aHousePrice, int[] aRents) {
        super(propertyName);
        price = aPrice;
        color = aColor;
        housePrice = aHousePrice;
        rents = aRents;
    }

    /**
     * This method is getting the owner of the property
     *
     *
     * @return owner is the owner of the property
     */
    public Player getOwner() {
        return owner;
    }

    /**
     * This method is setting the owner of the property
     *
     *
     * @param aOwner is the owner of the property
     */
    public void setOwner(Player aOwner) {
        owner = aOwner;
    }

    /**
     * This method is getting the price of the property
     *
     *
     * @return price is the price of the property
     */
    public int getPrice() {
        return price;
    }

    /**
     * This method is letting the player buy different properties, it checks their
     * funds
     * and if the property is already owned
     *
     * @param purchasingPlayer is the player wanting to buy property
     */
    public void buyProperty(Player purchasingPlayer) {
        if (purchasingPlayer.getBalance() < price) {
            throw new IllegalStateException("Player has insufficient funds to buy this property.");
        }

        if (owner != null) {

            throw new IllegalStateException("This Property is already owned");

        }
        purchasingPlayer.setBalance(purchasingPlayer.getBalance() - price);
        purchasingPlayer.addProperty(this);
        owner = purchasingPlayer;
    }

    /**
     * This method is getting the color of the property
     *
     *
     * @return color is the color of the property
     */
    public colorGroup getColor() {
        return color;
    }

    /**
     * This method is getting the number of houses on a property
     *
     *
     * @return numOfHouses is the number of houses on a property
     */
    public int getNumberOfHouses() {
        return numOfHouses;
    }

    /**
     * This method is letting the player buy houses on properties, if they own a
     * entire colorGroup of properties
     *
     * @param purchasingPlayer is the player wanting to buy a house
     */
    public void buyHouse(Player purchasingPlayer) {
        if (purchasingPlayer.getBalance() < housePrice) {
            throw new IllegalStateException("Player has insufficient funds to buy a house.");
        }
        if (!purchasingPlayer.ownsColorGroup(color)) {
            throw new IllegalStateException("Player does not own the color group.");
        }
        if (housePrice == 0) {
            throw new IllegalStateException("Player cannot purchase a house for railroad or utility");
        }
        purchasingPlayer.setBalance(purchasingPlayer.getBalance() - housePrice);
        numOfHouses++;
    }

    public String toString() {
        if (this.numOfHouses == 0) {
            return this.getName();
        }
        return this.getName() + "+" + this.numOfHouses;

    }
/**
     * This method is getRent it gets the price of rent for all properties
     *
     * @param dice1 value of dice1
     * @param dice2 value of dice2
     * @return rents[numOfHouses]  returns rent according to number of houses on property
     * */
    public int getRent(int dice1, int dice2) 
    {
        int numberOfRailroadsOwned = 0;
        int numberOfUtilitiesOwned = 0;
     	
      	for (Property property : owner.getOwnedProperties()) 
        {
           if (property.getColor() == colorGroup.RAILROAD) {
            numberOfRailroadsOwned++;
           }
          else if (property.getColor() == colorGroup.UTILITY) {
          	numberOfUtilitiesOwned++;
          }
        }
        if (owner != null) {
            if (color == colorGroup.RAILROAD) 
            {
                return rents[numberOfRailroadsOwned];
            } 
          	else if (color == colorGroup.UTILITY) 
            {
              	
              int sum = dice1 +dice2;
                return rents[numberOfUtilitiesOwned] * sum;
            } 
          	else 
            {
                return rents[numOfHouses];
            }
        }
      
		return 0;
    }
    /**
     * This method is payRent pays rent according to the houses numbers on the property
     *
     * @param dice1 value of dice1
     * @param dice2 value of dice2
     * @param currentPlayer is the player on the property
     * */
    public void payRent(int dice1, int dice2, Player currentPlayer){
        if (owner != null){
          int rentResult = getRent(dice1, dice2);
          if(rentResult < currentPlayer.getBalance() ){
          currentPlayer.setBalance(currentPlayer.getBalance() - rentResult);
            
            owner.setBalance(owner.getBalance() +rentResult);
          } else {
            while(!(currentPlayer.getOwnedProperties().isEmpty())){
           Property removedProp = currentPlayer.getOwnedProperties().remove(0);
              removedProp.setOwner(owner);
              owner.getOwnedProperties().add(removedProp);
            }
            owner.setBalance(owner .getBalance() + currentPlayer.getBalance());
            currentPlayer.setBalance(0);
          }
        }
      }
    

}
        
