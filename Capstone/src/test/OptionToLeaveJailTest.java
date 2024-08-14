package test;

import production.Monopoly.Main;
import production.Monopoly.Player;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.Test;
import static org.junit.Assert.*;

public class OptionToLeaveJailTest {
    @Test
    public void testPayFine() {
        InputStream originalIn = System.in;
        ByteArrayInputStream inputStream = new ByteArrayInputStream("1\n".getBytes());
        System.setIn(inputStream);

        Main.initialize();
        Main.mg.addPlayer("Alice", Main.mg.getPiece(1));
        Main.mg.addPlayer("Bob", Main.mg.getPiece(2));

        Player alice = Main.mg.getPlayer(0);
        alice.setIsInJail(true);
        assertEquals(true, alice.getIsInJail());

        Main.optionToLeaveJail(alice);
        assertEquals(1500 - 50, alice.getBalance());
        assertEquals(false, alice.getIsInJail());

        System.setIn(originalIn);
    }

    @Test
    public void testRollDoubles() {
        InputStream originalIn = System.in;
        ByteArrayInputStream inputStream = new ByteArrayInputStream(
                "2\n2\n2\n2\n2\n2\n2\n2\n2\n2\n2\n2\n2\n2\n2\n2\n2\n2\n2\n2\n2".getBytes());
        System.setIn(inputStream);

        Main.initialize();
        Main.mg.addPlayer("Alice", Main.mg.getPiece(1));
        Main.mg.addPlayer("Bob", Main.mg.getPiece(2));

        Player alice = Main.mg.getPlayer(0);
        alice.setIsInJail(true);
        Main.optionToLeaveJail(alice);
        while (Main.mg.getDice1() != Main.mg.getDice2()) {
            Main.optionToLeaveJail(alice);

        }
        assertEquals(false, alice.getIsInJail());
    }
}
