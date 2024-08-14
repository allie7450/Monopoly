package test;

import production.Monopoly.Main;
import production.Monopoly.Property;
import production.Monopoly.Player;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.Test;
import static org.junit.Assert.*;

//test for charge rent also uses get rent method to be able to charge right amount
public class ChargeRentTest {
    @Test
    public void testChargeRent() {
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

        int startingBalance = alice.getBalance();
        int cost = prop.getRent(dice1, dice2);

        Main.chargeRent(alice, prop);

        assertEquals(alice.getBalance(), startingBalance - cost);

        System.setIn(originalIn);
    }

}
