package groceryApplication.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import groceryApplication.models.ShoppingList;
import groceryApplication.repositories.ShoppingListRepository;

@Service
public class ShoppingListService {
	@Autowired
	private ShoppingListRepository repository;
	
	private List<ShoppingList> shoppingLists;
	
	public ShoppingListService() {
		this.shoppingLists = new ArrayList<ShoppingList>();

		this.shoppingLists.add(new ShoppingList(1,"HEB"));
		this.shoppingLists.add(new ShoppingList(2,"Walmart"));
		this.shoppingLists.add(new ShoppingList(3,"Fiesta"));
	}
	
	public void deleteShoppingList(int shoppingListId) {
		ShoppingList shoppingList = this.repository.findOne(shoppingListId);
		
		this.repository.delete(shoppingList);
	}
	
	public void addShoppingList(ShoppingList shoppingList) {
		this.repository.save(shoppingList);
	}
	
	public void updateShoppingList(ShoppingList shoppingList) {
		ShoppingList persistenceShoppingList = getShoppingListById(shoppingList.getShoppingListId());
		
		persistenceShoppingList.setTitle(shoppingList.getTitle());
		
		this.repository.save(persistenceShoppingList);
	}
	
	public ShoppingList getShoppingListById(int shoppingListId) {
		return this.repository.findOne(shoppingListId);
	}
	
	public List<ShoppingList> getAllShoppingList() {
		List<ShoppingList> shoppingList = new ArrayList<>();
		//Outro jeito
		//repository.findAll().forEach(shoppingLists::add)
		this.repository.findAll().forEach(x -> shoppingList.add(x));
		
		return shoppingList;
	}
}
