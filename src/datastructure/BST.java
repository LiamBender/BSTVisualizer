package datastructure;

/**
 * Implementation of a Binary Search Tree (BST).
 * 
 * @param <T> the specific type of element stored in the tree. Must implement
 *            Comparable.
 * 
 * @author Liam Bendiksen
 * @since 2026-06-10
 */

public class BST<T extends Comparable<? super T>> implements BSTInterface<T> {

	public class BSTNode {
		T item;
		BSTNode r;
		BSTNode l;

		/**
		 * Returns the item stored in this node.
		 * 
		 * @return the item stored in this node
		 */
		public T getItem() {
			return item;
		}

		/**
		 * Returns the left child of this node.
		 * 
		 * @return the left child, or null if there is no left child
		 */
		public BSTNode getLeft() {
			return l;
		}

		/**
		 * Returns the right child of this node.
		 * 
		 * @return the right child, or null if there is no right child
		 */
		public BSTNode getRight() {
			return r;
		}
	}

	private BSTNode root;
	private int size;

	/**
	 * Adds a new item to the Binary Search Tree.
	 * 
	 * if the item is less than or equal to the current node, it is inserted into
	 * the left subtree. Otherwise it is inserted into the right subtree.
	 * 
	 * @param item the specific item to add
	 */
	@Override
	public void add(T item) {
		if (root == null) {
			BSTNode node = new BSTNode();
			node.item = item;
			root = node;
			size++;
		} else {
			addRecursive(root, item);
		}
	}

	private void addRecursive(BSTNode node, T itemToAdd) {
		int cmp = itemToAdd.compareTo(node.item);

		if (cmp <= 0) {
			if (node.l == null) {
				BSTNode left = new BSTNode();
				left.item = itemToAdd;
				node.l = left;
				size++;
			} else {
				addRecursive(node.l, itemToAdd);
			}
		} else {
			if (node.r == null) {
				BSTNode right = new BSTNode();
				right.item = itemToAdd;
				node.r = right;
				size++;
			} else {
				addRecursive(node.r, itemToAdd);
			}
		}
	}

	/**
	 * Checks if the specified item already exists in the Binary Search Tree.
	 * 
	 * @param item the specific item to search for
	 * @return true if the item exists, otherwise false
	 */

	@Override
	public boolean contains(T item) {
		return containsRecursive(root, item);
	}

	private boolean containsRecursive(BSTNode node, T item) {
		if (node == null) {
			return false;
		}

		int cmp = item.compareTo(node.item);

		if (cmp == 0) {
			return true;
		} else if (cmp < 0) {
			return containsRecursive(node.l, item);
		} else if (cmp > 0) {
			return containsRecursive(node.r, item);
		}

		return false;
	}

	/**
	 * Removes the specified item from the Binary Search Tree.
	 * 
	 * Handles the following three cases:
	 * <ul>
	 * <li>Node with no children</li>
	 * <li>Node with one child</li>
	 * <li>Node with two children</li>
	 * </ul>
	 * 
	 * @param item the specified item to remove
	 * @return true if the item was removed, otherwise false
	 */
	@Override
	public boolean remove(T item) {
		if (!contains(item)) {
			return false;
		}

		root = removeRecursive(root, item);
		size--;
		return true;
	}

	private BSTNode removeRecursive(BSTNode node, T itemToRemove) {
		if (node == null) {
			return null;
		}

		int cmp = itemToRemove.compareTo(node.item);

		if (cmp < 0) {
			node.l = removeRecursive(node.l, itemToRemove);
		} else if (cmp > 0) {
			node.r = removeRecursive(node.r, itemToRemove);
		} else {

			// Case: No Children
			if (node.l == null && node.r == null) {
				return null;
			}

			// Case: One Child
			if (node.l == null) {
				return node.r;
			}

			if (node.r == null) {
				return node.l;
			}

			// Case: Two Children
			T smallestValue = findMin(node.r);
			node.item = smallestValue;
			node.r = removeRecursive(node.r, smallestValue);
		}

		return node;
	}

	/**
	 * Finds the smallest element in the Binary Search Tree.
	 * 
	 * @return the smallest element, or null if the tree is empty
	 */
	@Override
	public T findMin() {
		if (root == null) {
			return null;
		}

		BSTNode current = root;

		while (current.l != null) {
			current = current.l;
		}

		return current.item;
	}

	private T findMin(BSTNode node) {
		if (node == null) {
			return null;
		}

		BSTNode current = node;

		while (current.l != null) {
			current = current.l;
		}

		return current.item;
	}

	/**
	 * Finds the largest element in the Binary Search Tree.
	 * 
	 * @return the largest element, or null if the tree is empty
	 */
	@Override
	public T findMax() {
		if (root == null) {
			return null;
		}

		BSTNode current = root;

		while (current.r != null) {
			current = current.r;
		}

		return current.item;
	}

	/**
	 * Prints the Binary Search Tree using the inorder traversal.
	 * 
	 * Traversal order: left -> root -> right
	 */
	@Override
	public void printInOrder() {
		printInOrderRecursive(root);
	}

	private void printInOrderRecursive(BSTNode node) {
		if (node == null) {
			return;
		}

		printInOrderRecursive(node.l);
		System.out.println(node.item);
		printInOrderRecursive(node.r);
	}
	
	/**
	 * Returns a string representation of the Binary Search Tree using the inorder
	 * traversal.
	 * 
	 * Traversal order: left -> root -> right
	 * 
	 * @return a string representation of the tree in inorder traversal
	 */
	public String inOrderString() {
		StringBuilder sb = new StringBuilder();
		inOrderStringRecursive(root, sb);
		return sb.toString().trim();
	}
	
	private void inOrderStringRecursive(BSTNode node, StringBuilder sb) {
		if (node == null) {
			return;
		}

		inOrderStringRecursive(node.l, sb);
		sb.append(node.item).append(" ");
		inOrderStringRecursive(node.r, sb);
	}

	/**
	 * Prints the Binary Search Tree using the preorder traversal.
	 * 
	 * Traversal order: root -> left -> right
	 */
	@Override
	public void printPreOrder() {
		printPreOrderRecursive(root);

	}

	private void printPreOrderRecursive(BSTNode node) {
		if (node == null) {
			return;
		}

		System.out.println(node.item);
		printPreOrderRecursive(node.l);
		printPreOrderRecursive(node.r);
	}

	/**
	 * Returns a string representation of the Binary Search Tree using the preorder
	 * traversal.
	 * 
	 * Traversal order: root -> left -> right
	 * 
	 * @return a string representation of the tree in preorder traversal
	 */
	public String preOrderString() {
		StringBuilder sb = new StringBuilder();
		preOrderStringRecursive(root, sb);
		return sb.toString().trim();
	}
	
	private void preOrderStringRecursive(BSTNode node, StringBuilder sb) {
		if (node == null) {
			return;
		}

		sb.append(node.item).append(" ");
		preOrderStringRecursive(node.l, sb);
		preOrderStringRecursive(node.r, sb);
	}
	
	/**
	 * Prints the Binary Search Tree using the postorder traversal.
	 * 
	 * Traversal order: left -> right -> root
	 */
	@Override
	public void printPostOrder() {
		printPostOrderRecursive(root);

	}

	private void printPostOrderRecursive(BSTNode node) {
		if (node == null) {
			return;
		}

		printPostOrderRecursive(node.l);
		printPostOrderRecursive(node.r);
		System.out.println(node.item);
	}
	
	/**
	 * Returns a string representation of the Binary Search Tree using the postorder
	 * traversal.
	 * 
	 * Traversal order: left -> right -> root
	 * 
	 * @return a string representation of the tree in postorder traversal
	 */
	public String postOrderString() {
		StringBuilder sb = new StringBuilder();
		postOrderStringRecursive(root, sb);
		return sb.toString().trim();
	}
	
	private void postOrderStringRecursive(BSTNode node, StringBuilder sb) {
		if (node == null) {
			return;
		}

		postOrderStringRecursive(node.l, sb);
		postOrderStringRecursive(node.r, sb);
		sb.append(node.item).append(" ");
	}

	/**
	 * Returns the number of elements that are currently stored in the Binary Search
	 * Tree.
	 * 
	 * @return the number of elements
	 */
	@Override
	public int size() {
		return size;
	}

	/**
	 * Checks if the Binary Search Tree contains any elements.
	 * 
	 * @return true if the tree is empty, otherwise false
	 */
	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * Removes all elements from the Binary Search Tree.
	 */
	@Override
	public void clear() {
		root = null;
		size = 0;
	}

	/**
	 * Returns the root node of the Binary Search Tree.
	 * 
	 * @return the root node, or null if the tree is empty
	 */
	public BSTNode getRoot() {
		return root;
	}

	/**
	 * Returns the item stored in the root node of the Binary Search Tree.
	 * 
	 * @return the item in the root node, or null if the tree is empty
	 */
	public T getRootItem() {
		if (root == null) {
			return null;
		}

		return root.item;
	}
}
