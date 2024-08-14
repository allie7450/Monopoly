package test;

import production.Monopoly.Main;
import production.Monopoly.Player;
import java.io.ByteArrayInputStream;

import org.junit.Test;
import static org.junit.Assert.*;

public class WillPassGoTest {
    @Test
    public void checkPassingGoTest() {
        ByteArrayInputStream inputStream = new ByteArrayInputStream("1\n".getBytes());

        System.setIn(inputStream);

        Main.initialize();
        Main.mg.addPlayer("Alice", Main.mg.getPiece(1));
        Player alice = Main.mg.getPlayer(0);
        Main.mg.setDice(5, 5);
        Main.mg.performTurn();
        alice.getPosition();
        assertEquals(10, alice.getPosition());
        Main.mg.setDice(5, 5);
        Main.mg.performTurn();
        assertEquals(20, alice.getPosition());

        Main.mg.setDice(5, 5);
        Main.mg.performTurn();
        assertEquals(30, alice.getPosition());
        Main.mg.setDice(5, 5);
        Main.mg.willPassGo(alice);
        Main.mg.checkPassingGo(alice);

        assertEquals(true, Main.mg.willPassGo(alice));

        assertEquals(alice.getBalance(), 1500 + 200);
    }

}
