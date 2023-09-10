package app;
import java.util.ArrayList;

public class Cart {
	private ArrayList<Product> cartList;

	public Cart() {
		cartList = new ArrayList<Product>();
	}
	public void addList(Product item) {
	     cartList.add(item);
	     // still need to account for a separate in cart quantity
	}
	public void removeList(Product item) {
		cartList.remove(item);
	}
	public void displayCart() {
		for (Product item: cartList) {
			item.displayInCart();
		}
		}
	
	public int size() {
		return cartList.size();
	}
	/*public Product matchItem(String name) {
		for (Product item: cartList) {
			if (name.equals(item.getName())) {
				getItem(item);
				return item;
			}
		}
		System.out.println("This item is not in your cart.");
		return null;

	} */
	public Product matchItem(String name) {
		for (Product item: cartList) {
			int m = item.compareTo(name);
			if (m == 0) {
				//getItem(item);
				return item;
			}
		}
		System.out.println("Please select an item in stock");
		return null;

	}
	public void getItem(Product item) {
		//System.out.println(item.getName());
		System.out.println(item.toString());
	}
	public void changeCart(Product item, int change) { // decreases quantity by one
		int newQuantity = item.getCartQuant() + change;
		item.setCartQuant(newQuantity);
	}
	public void addCart(Product item) {
		changeCart(item, 1);
	}
	public void removeCart(Product item) {
		changeCart(item, -1);
	}
	public void emptyCart(Inventory inventoryList) {
		for (Product item: cartList) {
			int change = item.cartQuant;
			inventoryList.changeQuantity(item, change);
			item.setCartQuant(0);
		}
		cartList.clear();
	}
}
