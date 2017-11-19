package groceryApplication.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ShoppingList {
	@Id
	private int shoppingListId;
	@Column
	private String title;
	
	public ShoppingList() { }
	
	public ShoppingList(int shoppingListId, String title) {
		super();
		this.shoppingListId = shoppingListId;
		this.title = title;
	}

	public int getShoppingListId() {
		return shoppingListId;
	}
	
	public void setShoppingListId(int shoppingListId) {
		this.shoppingListId = shoppingListId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
