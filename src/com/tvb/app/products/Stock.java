import java.util.ArrayList;

public class Stock {
	private ArrayList<Product> products;
	
	public Stock() {
		this.products = new ArrayList<Product>();
	}
	
	public void addProduct(Product prod) {
		this.products.add(prod);
	}
	
	public void removeProduct(Product prod) {
		this.products.remove(prod);
	}
	
	@Override
	public String toString() {
		StringBuilder strBuild = new StringBuilder();
		for(Product prod : products) {
			strBuild.append(prod.toString() + "\n");
		}
		return strBuild.toString();
	}
}
