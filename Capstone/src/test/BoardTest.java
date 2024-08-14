package test;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import production.Monopoly.Board;

public class BoardTest {
  
    private Board board;

    @Before
    public void setUp() {
        board = new Board();

    }
    @Test
    public void getSquareAt(){
        assertEquals(board.getSquareAt(0).getName(), "GO");
       assertEquals(board.getSquareAt(8).getName(), "Vermont Avenue");
    }
}
