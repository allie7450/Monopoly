package test;

import production.Monopoly.Piece;

import org.junit.Test;
//import org.junit.After;
import org.junit.Before;
import static org.junit.Assert.*;

public class PieceTest {

    Piece piece;
    String aName;

    @Before
    public void setUp() {
        aName = "thimble";
        piece = new Piece(aName);

    }

    @Test
    public void getName() {
        assertEquals("thimble", piece.getName());
    }

    @Test
    public void testSetName() {
        piece.setName("TopHat");
        assertEquals("TopHat", piece.getName());
    }
}
