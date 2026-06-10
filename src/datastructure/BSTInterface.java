package datastructure;

/**
 * Interface that defines the operations supported by a Binary Search Tree
 * (BST).
 * 
 * @param <T> the type of elements stored in the Binary Search Tree
 * @author Liam Bendiksen
 * @since 2026-06-10
 */
public interface BSTInterface<T> {

	/**
	 * Adds an item to the Binary Search Tree.
	 * 
	 * @param item the item to add
	 */
	void add(T item);

	/**
	 * Checks whether the specified item exists in the tree.
	 * 
	 * @param item the item to search for
	 * @return true if found, otherwise false
	 */
	boolean contains(T item);

	/**
	 * Removes an item from the Binary Search Tree.
	 * 
	 * @param item the item to remove
	 * @return true if the item was removed, otherwise false
	 */
	boolean remove(T item);

	/**
	 * Finds the smallest element in the Binary Search Tree.
	 * 
	 * @return the smallest element, or null if the tree is empty
	 */
	T findMin();

	/**
	 * Finds the largest element in the Binary Search Tree.
	 * 
	 * @return the largest element, or null if the tree is empty
	 */
	T findMax();

	/**
	 * Prints the tree using inorder traversal.
	 */
	void printInOrder();

	/**
	 * Prints the tree using preorder traversal.
	 */
	void printPreOrder();

	/**
	 * Prints the tree using postorder traversal.
	 */
	void printPostOrder();

	/**
	 * Returns the number of elements currently stored in the Binary Search Tree.
	 * 
	 * @return the number of elements
	 */
	int size();

	/**
	 * Checks whether the Binary Search Tree is empty.
	 * 
	 * @return true if the tree contains no elements, otherwise false
	 */
	boolean isEmpty();

	/**
	 * Removes all elements from the tree.
	 */
	void clear();
}
