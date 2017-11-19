package groceryApplication.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import groceryApplication.models.ShoppingList;
import groceryApplication.services.ShoppingListService;

@RestController
public class ShoppingListController {
	
	//Autowired = Automatically creates an instance of service
	@Autowired
	private ShoppingListService service;
	
	@RequestMapping(method=RequestMethod.DELETE, value="shoppingList")
	public void deleteShoppingList(@RequestBody ShoppingList shoppingList) {
		this.service.deleteShoppingList(shoppingList.getShoppingListId());
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/shoppingList")
	public void addShoppingList(@RequestBody ShoppingList shoppingList) {
		this.service.addShoppingList(shoppingList);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/shoppingList")
	public void updateShoppingList(@RequestBody ShoppingList shoppingList) {
		this.service.updateShoppingList(shoppingList);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/shoppingList/{shoppingListId}")
	public ShoppingList getShoppingList(@PathVariable int shoppingListId) {
		return this.service.getShoppingListById(shoppingListId);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/shoppingLists")
	public List<ShoppingList> getShoppingLists() {
		return this.service.getAllShoppingList();
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/")
	public String hello() {
		return "Server's running.";
	}
}
