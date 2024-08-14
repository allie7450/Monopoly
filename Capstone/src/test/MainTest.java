package test;

import production.Monopoly.Main;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import static org.junit.Assert.*;

public class MainTest {

    InputStream originalIn = System.in;
    PrintStream originalOut = System.out;
    ByteArrayOutputStream outputStream;

    @Before
    public void setUp() {
        ByteArrayInputStream inputStream = new ByteArrayInputStream("1\n2\nAllison\n1\nAl\n2\n-1\n".getBytes());
        System.setIn(inputStream);

        outputStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(outputStream);
        System.setOut(ps);
    }

    @Test
    public void testMain() {
        Main.main(null);
        String strs[] = outputStream.toString().split("\\r?\\n");
        assertEquals("Welcome to Monopoly!!", strs[0]);
        assertEquals("Menu: 1-Play game, 2-Quit", strs[1]);
        assertEquals("How Many players are there? (2-8 can play)", strs[2]);
        assertEquals("Please type in your name ", strs[3]);
        assertEquals(
                "Please chose your game piece: 1- TopHat, 2-Thimble, 3-Battleship, 4-wheelBarrow, 5-Shoe, 6-dog, 7-raceCar, 8-iron",
                strs[4]);
        assertEquals("player: Allison piece: TopHat", strs[5]);
        assertEquals("Please type in your name ", strs[6]);
        assertEquals(
                "Please chose your game piece: 1- TopHat, 2-Thimble, 3-Battleship, 4-wheelBarrow, 5-Shoe, 6-dog, 7-raceCar, 8-iron",
                strs[7]);
        assertEquals("player: Al piece: Thimble", strs[8]);

    }

    @After
    public void tearDown() {
        System.setIn(originalIn);
        System.setOut(originalOut);
    }
}
