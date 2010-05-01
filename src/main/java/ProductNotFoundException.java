/**
 * Exception thrown when a product is not found in a shopping cart as described
 * in the JUnit Primer.
 * 
 * @author Mike Clark, http://clarkware.com
 */

@SuppressWarnings("serial")
public class ProductNotFoundException extends RuntimeException {

	public ProductNotFoundException() {
		super();
	}
}
