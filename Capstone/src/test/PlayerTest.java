package test;

import production.Monopoly.Player;
import production.Monopoly.Property;
import production.Monopoly.Piece;
import production.Monopoly.MonopolyGame;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;

public class PlayerTest {

    Player player;
    String aName;
    int aBalance;
    Piece aPiece;
    MonopolyGame game;

    @Before
    public void setUp() {
        aName = "Bob";
        aBalance = 1500;
        aPiece = new Piece("TopHat");
        game = new MonopolyGame();
        player = new Player(aName, aBalance, aPiece, game);

    }

    @Test
    public void testSetBalance() {
        player.setBalance(1600);
        assertEquals(1600, player.getBalance());
    }

    @Test
    public void testGetBalance() {
        assertEquals(1500, player.getBalance());
    }

    @Test
    public void testSetPiece() {
        Piece piece = new Piece("thimble");
        player.setPiece(piece);
        assertEquals(piece, player.getPiece());
    }

    @Test
    public void testGetPiece() {
        assertEquals(aPiece, player.getPiece());
    }

    @Test
    public void testSetPosition() {
        player.setPosition(2);
        assertEquals(2, player.getPosition());
    }

    @Test
    public void testGetPosition() {
        assertEquals(0, player.getPosition());
    }

    @Test
    public void testSetOwnedProperties() {
        List<Property> newOwnedProperties = new ArrayList<>();
        newOwnedProperties.add(new Property("Mediterranean Avenue", 60, Property.colorGroup.BROWN, 50, new int[] { 2, 10, 30, 90, 160, 250 }));
        player.setOwnedProperties(newOwnedProperties);
        assertEquals(newOwnedProperties, player.getOwnedProperties());
    }

    @Test
    public void testGetOwnedProperties() {
        assertEquals(0, player.getOwnedProperties().size());
    }

    @Test
    public void testSetIsInJail() {
        player.setIsInJail(true);
        assertEquals(true, player.getIsInJail());
    }

    @Test
    public void testGetIsInJail() {
        assertEquals(false, player.getIsInJail());
    }

    @Test
    public void testSetName() {
        player.setName("Allison");
        assertEquals("Allison", player.getName());
    }

    @Test
    public void testGetName() {
        assertEquals("Bob", player.getName());
    }

    @Test
    public void ownsColorGroup() {
        List<Property> newOwnedProperties = new ArrayList<>();
        newOwnedProperties.add(new Property("Mediterranean Avenue", 60, Property.colorGroup.BROWN, 50, new int[] { 2, 10, 30, 90, 160, 250 }));
        newOwnedProperties.add(new Property("Baltic Avenue", 60, Property.colorGroup.BROWN, 50,  new int[] { 4, 20, 60, 180, 320, 450 }));
        player.setOwnedProperties(newOwnedProperties);
        assertEquals(false, player.ownsColorGroup(Property.colorGroup.BROWN));
    }

    @Test
    public void addProperty() {
        Property property = new Property("Mediterranean Avenue", 60, Property.colorGroup.BROWN, 50, new int[] { 2, 10, 30, 90, 160, 250 });
        player.addProperty(property);
        assertTrue(player.getOwnedProperties().contains(property));
    }

}
