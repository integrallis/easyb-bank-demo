import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;



/**
 * The ShoppingCartTest is an example JUnit TestCase
 * as described in the JUnit Primer.
 *
 * @author Mike Clark, http://clarkware.com
 */
 
public class ShoppingCartTest  {
    
    private ShoppingCart cart;
    private Product book1;
    
    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp() {
	
        cart = new ShoppingCart();
	
        book1 = new Product("Pragmatic Unit Testing", 29.95);
	
        cart.addItem(book1);
    }
    
    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown() {
        // release objects under test here, as necessary
    }
    
    /**
     * Tests emptying the cart.
     */
    @Test
    public void testEmpty() {
	
        cart.empty();
    
        assertEquals(0, cart.getItemCount());
    }

    /**
     * Tests adding an item to the cart.
     */
    @Test
    public void testAddItem() {
	
        Product book2 = new Product("Pragmatic Project Automation", 29.95);
        cart.addItem(book2);

        assertEquals(2, cart.getItemCount());
	
        double expectedBalance = book1.getPrice() + book2.getPrice();	
        assertEquals(expectedBalance, cart.getBalance(), 0.0);
    }
        
    /**
     * Tests removing an item from the cart.
     */
    @Test
    public void testRemoveItem() {
        cart.removeItem(book1);
        assertEquals(0, cart.getItemCount());
    }
    
    /**
     * Tests removing an unknown item from the cart.
     *
     * This test is successful if the 
     * ProductNotFoundException is raised.
     */
    @Test(expected = ProductNotFoundException.class)
    public void testRemoveItemNotInCart() {
        Product book3 = new Product("Pragmatic Version Control", 29.95);
        cart.removeItem(book3); 
        fail("Should raise a ProductNotFoundException");
    }
}
