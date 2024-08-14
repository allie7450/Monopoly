package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import production.Monopoly.MonopolyGame;
import production.Monopoly.Player;
import production.Monopoly.Piece;
import production.Monopoly.Property;

public class PropertyTest {
    Property property1;
    Property property2;
    Player owner;
    String aName;
    int aBalance;
    Piece aPiece;
    MonopolyGame game;

    @Before
    public void setUp() {
        property1 = new Property("Mediterranean Avenue", 60, Property.colorGroup.BROWN, 50, new int[] { 2, 10, 30, 90, 160, 250 });
        property2 = new Property("Baltic Avenue", 60, Property.colorGroup.BROWN, 50,  new int[] { 4, 20, 60, 180, 320, 450 });
        aName = "Bob";
        aBalance = 1500;
        aPiece = new Piece("TopHat");
        game = new MonopolyGame();
        owner = new Player(aName, aBalance, aPiece, game);
    }

    @Test
    public void getOwner() {
        property1.setOwner(owner);
        assertEquals(owner, property1.getOwner());
    }

    @Test
    public void setOwner() {
        property1.setOwner(owner);
        assertEquals(owner, property1.getOwner());
    }

    @Test
    public void getPrice() {
        assertEquals(60, property1.getPrice());
    }

    @Test
    public void buyProperty() {
        property1.buyProperty(owner);
        assertEquals(owner, property1.getOwner());
        assertEquals(1440, owner.getBalance());
        assertTrue(owner.getOwnedProperties().contains(property1));
    }

    @Test
    public void getColor() {
        assertEquals(Property.colorGroup.BROWN, property1.getColor());
    }

    @Test
    public void getNumberOfHouses() {
        assertEquals(0, property1.getNumberOfHouses());

    }

    @Test
    public void buyHouse() {
        Property mediterraneanAvenue = (Property) game.getSquareAt(1);
        Property balticAvenue = (Property) game.getSquareAt(3);
        mediterraneanAvenue.buyProperty(owner);
        balticAvenue.buyProperty(owner);

        mediterraneanAvenue.buyHouse(owner);

        assertEquals(owner, mediterraneanAvenue.getOwner());
        assertEquals(1330, owner.getBalance());
    }

}
