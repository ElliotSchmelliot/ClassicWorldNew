package items;

import java.util.ArrayList;
import java.util.List;

public class Shop {
	public List<Item> stock;
	
	public Shop(int level) {
		stock = new ArrayList<Item>();
		stockShelves(level);
	}
	
	public void getContents() {
		if (stock.size() > 0) {
			System.out.println("Current stock:");
			for (int i = 0; i < stock.size(); i++) {
				System.out.println(i + 1 + ") " + stock.get(i).name + ": " + stock.get(i).value + "coin");
			}
		} else {
			System.out.println("The shop is currently empty");
		}
	}
	
	public void stockShelves(int level) {
		stock.add(new Consumable("Top Ramen", level, level * 5));
		stock.get(0).value = 10;
	}
}
