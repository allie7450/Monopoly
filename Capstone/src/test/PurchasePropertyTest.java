package test;

import production.Monopoly.Main;
import production.Monopoly.Property;
import production.Monopoly.Player;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.Test;
import static org.junit.Assert.*;
public class PurchasePropertyTest 
{

    @Test
    public void testAliceBuysProperty() 
    {
      InputStream originalIn = System.in;
      ByteArrayInputStream inputStream = new ByteArrayInputStream("1\n".getBytes());
      
      System.setIn(inputStream);
      
      	Main.initialize();
      	Main.mg.addPlayer("Alice", Main.mg.getPiece(1));
      	Main.mg.addPlayer("Bob", Main.mg.getPiece(2));
      
      	Property prop = (Property) Main.mg.getSquareAt(1);
      
      	Player alice = Main.mg.getPlayer(0);
      
      	Main.purchaseProperty(alice, prop);
      	assertEquals(alice, prop.getOwner());
      	assertTrue(alice.getOwnedProperties().contains(prop));
      
      System.setIn(originalIn);
   }
  
  
  	@Test
  	public void testAliceDoesNotBuyProperty()
    {
      InputStream originalIn = System.in;
            ByteArrayInputStream inputStream = new ByteArrayInputStream("2\n".getBytes());
      System.setIn(inputStream);
      
            	Main.initialize();
      	Main.mg.addPlayer("Alice", Main.mg.getPiece(1));
      	Main.mg.addPlayer("Bob", Main.mg.getPiece(2));
      
      Property prop = (Property) Main.mg.getSquareAt(1);
      
      	Player alice = Main.mg.getPlayer(0);
      
      	Main.purchaseProperty(alice, prop);
      	assertFalse(alice == prop.getOwner());
      	assertFalse(alice.getOwnedProperties().contains(prop));
      
      System.setIn(originalIn);
      
    }
  
  	
}
