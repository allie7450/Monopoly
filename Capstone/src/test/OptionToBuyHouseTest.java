package test;

import production.Monopoly.Main;
import production.Monopoly.Property;
import production.Monopoly.Player;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.Test;
import static org.junit.Assert.*;
public class OptionToBuyHouseTest 
{
    @Test
    public void testBuysHouse() 
    {
    InputStream originalIn = System.in;
      ByteArrayInputStream inputStream = new ByteArrayInputStream("1\n1\n1\n1\n".getBytes());
      System.setIn(inputStream);
      
      	Main.initialize();
      	Main.mg.addPlayer("Alice", Main.mg.getPiece(1));
      	Main.mg.addPlayer("Bob", Main.mg.getPiece(2));
            	Property prop1 = (Property) Main.mg.getSquareAt(1);
      Property prop2 = (Property) Main.mg.getSquareAt(3);
      
      
      	Player alice = Main.mg.getPlayer(0);
      
      	Main.purchaseProperty(alice, prop1);
      Main.purchaseProperty(alice, prop2);
      Main.optionToBuyHouses(alice);
      
      	assertEquals(1, prop2.getNumberOfHouses());
      
      
      System.setIn(originalIn);
    }
}
