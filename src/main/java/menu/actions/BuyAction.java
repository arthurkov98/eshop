package menu.actions;

import cart.Cart;
import shop.Shop;

public class BuyAction {
 public void run(Cart cart, Shop shop){
     shop.buy(cart);
 }
}
