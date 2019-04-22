import java.util.HashMap;
import java.util.Map;

public class Product_old {
	private String name;
	private double price;
	
	private HashMap<String, Integer> sizes;
	
	public Product_old() {
		this.sizes = new HashMap<String, Integer>();
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	//Returns true and creates a size if "size" doesnt exist, else adds quantity and returns false
	public boolean addSize(String size, int quantity) {
		if(this.sizes.containsKey(size)) {
			this.sizes.put(size, this.sizes.get(size) + quantity);
			return false;
		}
		else {
			this.sizes.put(size, quantity);
			return true;
		}
	}
	
	
	@Override
	public String toString() {
		StringBuilder strBuild = new StringBuilder();
		strBuild.append("Name: "  + this.name + "\n");
		strBuild.append("Price: " + String.valueOf(this.price) + "\n");
		strBuild.append("Sizes: " + "\n");
		for(Map.Entry<String, Integer> entry : this.sizes.entrySet()) {
			strBuild.append("  " + entry.getKey() + ": " + entry.getValue().toString() + "\n");
		}
		return strBuild.toString();
	}
}
