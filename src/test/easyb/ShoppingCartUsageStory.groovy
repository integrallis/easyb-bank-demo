import ShoppingCart
import ProductNotFoundException

/**
 * SCENARIO #1 
 */
scenario "adding an item to an empty shopping cart", {
    given "an empty shopping cart",{
       cart = new ShoppingCart()
    }
    when "an item is added to the cart", {
       book = new Product("Pragmatic Unit Testing", 29.95)
       cart.addItem(book);
    }
    then "the balance should be equal to the price of the item added", {
        cart.balance.shouldBe book.price
    }
}

/**
 * SCENARIO #2
 */
scenario "removing an item from a shopping cart", {
    given "a shopping cart with a known item", {
        cart = new ShoppingCart()
        book = new Product("Pragmatic Unit Testing", 29.95)
        cart.addItem(book)   
    }
    when "the item is removed", {
        cart.removeItem(book)
    }
    then "the cart should be empty", {
        cart.itemCount.shouldBe 0
    }
    and "the balance should be zero", {
        cart.balance.shouldBe 0
    }
}

/**
 * SCENARIO #3
 */
scenario "attempting to remove an item not in a shopping cart", {
    given "an empty shopping cart",{
       book = new Product("Pragmatic Unit Testing", 29.95)
       cart = new ShoppingCart()
    }
    when "an attempting to remove an item not in the shopping cart", {
        removeNonExistingItem = {
            cart.removeItem(book)
        }
    }
    then "an exception should be thrown", {
        ensureThrows(ProductNotFoundException) {
            removeNonExistingItem()
        }
    }
    and "the cart should still be empty", {
        cart.itemCount.shouldBe 0
    }
    and "the balance should still be zero", {
        cart.balance.shouldBe 0
    }
}
