package tree;

import java.util.TreeMap;

public class Main {
	public static void main(String[] args) {
		BinarySearchTree<Integer, Integer> bst = new BinarySearchTree<Integer, Integer>();
		bst.insert(4, 1);
		bst.insert(2, 5);
		bst.insert(3, 2);
		bst.insert(1, 2);
		bst.insert(5, 4);
		bst.insert(6, 3);
		/*System.out.println(bst.find(3));
		System.out.println(bst.treeHeight());
		bst.preorderPrint();
		BinarySearchTree<Integer, Integer> subMap = bst.subMap(0, 7);
		System.out.println("submap");
		subMap.preorderPrint();
		System.out.println("Size: " + bst.size());*/
		
		bst.nonRecursiveThreadInOrder();
		bst.threadedWalk();
		
		TreeMap<Integer, Integer> tree = new TreeMap<Integer, Integer>();
		bst.retrieveLeaves(tree);
		System.out.println(tree.toString());
		bst.preorderPrint();
		System.out.println("Size: " + bst.size());
		
		
		
	}

}
