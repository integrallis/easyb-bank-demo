import java.util.ArrayList;
import java.util.Iterator;

/**
 * An example shopping cart.
 * 
 * This class should not be mistaken for a production-quality shopping cart.
 * It's merely provided as an example class under test as described in the JUnit
 * Primer.
 * 
 * @author Mike Clark, http://clarkware.com
 */

public class ShoppingCart {

	private ArrayList<Product> items;

	public ShoppingCart() {
		items = new ArrayList<Product>();
	}

	public double getBalance() {
		double balance = 0.00;
		for (Iterator<Product> i = items.iterator(); i.hasNext();) {
			Product item = (Product) i.next();
			balance += item.getPrice();
		}

		return balance;
	}

	public void addItem(Product item) {
		items.add(item);
	}

	public void removeItem(Product item) throws ProductNotFoundException {
		if (!items.remove(item)) {
			throw new ProductNotFoundException();
		}
	}

	public int getItemCount() {
		return items.size();
	}

	public void empty() {
		items.clear();
	}
}
