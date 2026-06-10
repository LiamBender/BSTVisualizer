package datastructure;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class BSTTest {

	@Test
	void testAdd() {
		BST<Integer> bst = new BST<>();
		
		bst.add(10);
		bst.add(9);
		bst.add(11);
		
		assertTrue(bst.contains(10));
		assertTrue(bst.contains(9));
		assertTrue(bst.contains(11));
		assertEquals(3, bst.size());
	}
	
	@Test
	void testRemove() {
		BST<Integer> bst = new BST<>();
		
		bst.add(10);
		bst.add(9);
		bst.add(11);
		bst.add(13);
		bst.add(16);
		bst.add(49);
		
		assertTrue(bst.contains(11));
		assertEquals(6, bst.size());
		
		bst.remove(11);
		
		assertFalse(bst.contains(11));
		assertEquals(5, bst.size());
	}
	
	@Test
	void testRemoveLeaf() {
		BST<Integer> bst = new BST<>();
		
		bst.add(10);
		bst.add(9);
		bst.add(11);
		
		assertTrue(bst.remove(9));
		assertFalse(bst.contains(9));
		assertEquals(2, bst.size());
	}
	
	@Test
	void testRemoveOneChild() {
		BST<Integer> bst = new BST<>();
		
		bst.add(10);
		bst.add(11);
		bst.add(13);
		
		assertTrue(bst.remove(11));
		assertFalse(bst.contains(11));
		assertTrue(bst.contains(13));
		assertEquals(2, bst.size());
	}
	
	@Test
	void testRemoveTwoChildren() {
		BST<Integer> bst = new BST<>();
		
		bst.add(10);
		bst.add(5);
		bst.add(15);
		bst.add(12);
		bst.add(20);
		
		assertTrue(bst.remove(15));
		assertFalse(bst.contains(15));
		assertTrue(bst.contains(12));
		assertTrue(bst.contains(20));
		assertEquals(4, bst.size());
	}
	
	@Test
	void testRemoveNonExistingItem() {
		BST<Integer> bst = new BST<>();
		
		bst.add(10);
		
		assertFalse(bst.remove(99));
		assertEquals(1, bst.size());
	}
	
	@Test
	void testContains() {
		BST<Integer> bst = new BST<>();
		
		bst.add(50);
		
		assertTrue(bst.contains(50));
		assertFalse(bst.contains(40));
	}
	
	@Test
	void testFindMin() {
		BST<Integer> bst = new BST<>();
		
		bst.add(50);
		bst.add(49);
		bst.add(51);
		
		assertEquals(49, bst.findMin());
	}
	
	@Test
	void testFindMax() {
		BST<Integer> bst = new BST<>();
		
		bst.add(50);
		bst.add(49);
		bst.add(51);
		
		assertEquals(51, bst.findMax());
	}
	
	@Test
	void testClear() {
		BST<Integer> bst = new BST<>();
		
		bst.add(10);
		bst.add(20);
		bst.clear();
		
		assertTrue(bst.isEmpty());
		assertEquals(0, bst.size());
	}

}
