package test;

import production.Monopoly.Main;
import production.Monopoly.Property;
import production.Monopoly.Player;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.Test;
import static org.junit.Assert.*;

public class PayRentTest {

    @Test
    public void testPayRentNoHouses() {
        InputStream originalIn = System.in;
        ByteArrayInputStream inputStream = new ByteArrayInputStream("1\n".getBytes());

        System.setIn(inputStream);

        Main.initialize();
        Main.mg.addPlayer("Alice", Main.mg.getPiece(1));
        Main.mg.addPlayer("Bob", Main.mg.getPiece(2));

        Property prop = (Property) Main.mg.getSquareAt(1);

        Player alice = Main.mg.getPlayer(0);
        Player bob = Main.mg.getPlayer(1);
        prop.setOwner(bob);
        int dice1 = Main.mg.getDice1();
        int dice2 = Main.mg.getDice2();

        prop.payRent(dice1, dice2, alice);

        assertEquals(alice.getBalance(), 1500 - 2);

        System.setIn(originalIn);
    }

    @Test
    public void testPayRentWithThreeHouses() {
        InputStream originalIn = System.in;
        ByteArrayInputStream inputStream = new ByteArrayInputStream("1\n1\n1\n1\n1\n1\n1\n1\n1\n1".getBytes());
        System.setIn(inputStream);

        Main.initialize();
        Main.mg.addPlayer("Alice", Main.mg.getPiece(1));
        Main.mg.addPlayer("Bob", Main.mg.getPiece(2));
        Property prop1 = (Property) Main.mg.getSquareAt(1);
        Property prop2 = (Property) Main.mg.getSquareAt(3);

        Player alice = Main.mg.getPlayer(0);

        Main.purchaseProperty(alice, prop1);
        Main.purchaseProperty(alice, prop2);

        prop1.buyHouse(alice);
        prop1.buyHouse(alice);
        prop1.buyHouse(alice);
        Player bob = Main.mg.getPlayer(1);
        prop1.setOwner(alice);
        int dice1 = Main.mg.getDice1();
        int dice2 = Main.mg.getDice2();

        prop1.payRent(dice1, dice2, bob);

        assertEquals(bob.getBalance(), 1500 - 90);

        System.setIn(originalIn);
    }

    // 5 houses = 1 hotel
    @Test
    public void testPayRentWithAHotel() {
        InputStream originalIn = System.in;
        ByteArrayInputStream inputStream = new ByteArrayInputStream("1\n1\n1\n1\n1\n1\n1\n1\n1\n1".getBytes());
        System.setIn(inputStream);

        Main.initialize();
        Main.mg.addPlayer("Alice", Main.mg.getPiece(1));
        Main.mg.addPlayer("Bob", Main.mg.getPiece(2));
        Property prop1 = (Property) Main.mg.getSquareAt(1);
        Property prop2 = (Property) Main.mg.getSquareAt(3);

        Player alice = Main.mg.getPlayer(0);

        Main.purchaseProperty(alice, prop1);
        Main.purchaseProperty(alice, prop2);

        prop1.buyHouse(alice);
        prop1.buyHouse(alice);
        prop1.buyHouse(alice);
        prop1.buyHouse(alice);
        prop1.buyHouse(alice);

        Player bob = Main.mg.getPlayer(1);
        prop1.setOwner(alice);
        int dice1 = Main.mg.getDice1();
        int dice2 = Main.mg.getDice2();

        prop1.payRent(dice1, dice2, bob);

        assertEquals(bob.getBalance(), 1500 - 250);

        System.setIn(originalIn);
    }

}
