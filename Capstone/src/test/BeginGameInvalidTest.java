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

//testing for invalid input having Try again when more than one player tries to choose the same gamepiece
public class BeginGameInvalidTest {

    InputStream originalIn = System.in;
    PrintStream originalOut = System.out;
    ByteArrayOutputStream outputStream;

    @Before
    public void setUp() {
        ByteArrayInputStream inputStream = new ByteArrayInputStream("1\n1\n2\nAllison\n9\n1\nBob\n1\n2\n-1\n".getBytes());
        System.setIn(inputStream);

        outputStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(outputStream);
        System.setOut(ps);
    }

    @Test
    public void testBegin() {
        Main.main(null);
        String programOutput = outputStream.toString();
      	assertTrue(programOutput.contains("Invalid input. Please enter a number between 2-8"));
        assertTrue(programOutput.contains("Try again"));
    }

    @After
    public void tearDown() {
        System.setIn(originalIn);
        System.setOut(originalOut);
    }
}
