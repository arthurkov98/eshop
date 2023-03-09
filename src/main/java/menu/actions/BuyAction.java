package menu.actions;

import cart.Cart;
import shop.Shop;

/* my OCD is very sad again */
/* what's with that formatting? */
/* ctrl+alt+l magic required */
/* also we wanted to change cart status here */
public class BuyAction {
 public void run(Cart cart, Shop shop){
     shop.buy(cart);
 }
}
