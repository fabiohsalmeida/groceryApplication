package groceryApplication.repositories;

import org.springframework.data.repository.CrudRepository;

import groceryApplication.models.ShoppingList;

public interface ShoppingListRepository extends CrudRepository<ShoppingList, Integer> {
	// getAllShoppingList
	// getShoppingList(int shoppingListId)
	// updateShoppingList(ShoppingList shoppingList)
	// deleteShoppingList(int shoppingListId)
	// addShoppingList(ShoppingList shoppingList)
}