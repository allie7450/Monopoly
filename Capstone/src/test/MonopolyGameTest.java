package test;

import production.Monopoly.MonopolyGame;
import production.Monopoly.Piece;
import production.Monopoly.Player;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

public class MonopolyGameTest {

    private MonopolyGame monopolyGame;

    @Before
    public void setUp() {
        monopolyGame = new MonopolyGame();

    }

    @Test
    public void getAvailablePieces() {
        assertEquals(8, monopolyGame.getAvailablePieces().size());
    }

    @Test
    public void getPieceCount() {
        assertEquals(8, monopolyGame.getPieceCount());

    }

    @Test
    public void getPiece() {
        int index = 2;
        assertEquals("Battleship", monopolyGame.getPiece(index).getName());
    }

    @Test
    public void addPlayer() {
        String name = "allison";
        Piece selectedPiece = monopolyGame.getPiece(2);
        monopolyGame.addPlayer(name, selectedPiece);

        assertEquals(name, monopolyGame.getPlayer(0).getName());
        assertEquals(7, monopolyGame.getAvailablePieces().size());
    }

    @Test
    public void performTurn() {
        monopolyGame.addPlayer("allison", monopolyGame.getPiece(2));
        monopolyGame.addPlayer("alli", monopolyGame.getPiece(3));
        int index = monopolyGame.getCurrentPlayerIndex();
        Player currentPlayer = monopolyGame.getPlayer(index);
        int startingPosition = currentPlayer.getPosition();

        monopolyGame.rollDice();
        monopolyGame.performTurn();
        assertTrue(startingPosition != currentPlayer.getPosition());
    }

    @Test
    public void rollDice() {
        int originalDice1 = 0;
        int originalDice2 = 0;
        boolean hasDice1Changed = false;
        boolean hasDice2Changed = false;

        monopolyGame.rollDice();
        originalDice1 = monopolyGame.getDice1();
        originalDice2 = monopolyGame.getDice2();
        for (int i = 0; i < 100; i++) {
            monopolyGame.rollDice();
            if (monopolyGame.getDice1() != originalDice1) {
                hasDice1Changed = true;
            }
            if (monopolyGame.getDice2() != originalDice2) {
                hasDice2Changed = true;
            }
            assertEquals(monopolyGame.getDice1() >= 1, true);
            assertEquals(monopolyGame.getDice1() <= 6, true);

            assertEquals(monopolyGame.getDice2() >= 1, true);
            assertEquals(monopolyGame.getDice2() <= 6, true);
        }
        assertEquals(hasDice1Changed, true);
        assertEquals(hasDice2Changed, true);
    }

    @Test
    public void getSquareAt() {
        assertEquals(monopolyGame.getSquareAt(0).getName(), "GO");
        assertEquals(monopolyGame.getSquareAt(4).getName(), "Income Tax");
        assertEquals(monopolyGame.getSquareAt(39).getName(), "Board Walk");

    }

}
