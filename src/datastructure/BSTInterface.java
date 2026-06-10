package datastructure;

public interface BSTInterface<T> {
	
	void add(T item);
	
	boolean contains(T item);
	
	boolean remove(T item);
	
	T findMin();
	
	T findMax();
	
	void printInOrder();

	void printPreOrder();

	void printPostOrder();
	
	int size();
	
	boolean isEmpty();
	
	void clear();
}
