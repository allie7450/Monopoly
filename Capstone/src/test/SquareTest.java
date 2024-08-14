package test;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import production.Monopoly.Square;

public class SquareTest {
  
    private Square square;

    @Before
    public void setUp() {
        square = new Square("sName");

    }
    @Test
    public void getName(){
assertEquals("sName", square.getName());
    }
    @Test
    public void TesttoString(){
assertEquals("sName", square.toString());
    }
}
