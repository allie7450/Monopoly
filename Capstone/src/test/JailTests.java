package test;

import production.Monopoly.Main;
import production.Monopoly.Player;

import org.junit.Test;
import static org.junit.Assert.*;

public class JailTests {
  @Test
  public void checkGoToJailTest() {
    Main.initialize();
    Main.mg.addPlayer("Alice", Main.mg.getPiece(1));
    Player alice = Main.mg.getPlayer(0);

    alice.setPosition(30);
    assertEquals(30, alice.getPosition());
    Main.mg.checkGoToJail(alice);

    assertEquals(true, alice.getIsInJail());

    assertEquals(alice.getPosition(), 10);
  }

}
