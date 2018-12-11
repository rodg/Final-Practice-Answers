package tree;

import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

public class BinarySearchTree<K extends Comparable<K>, V> {
	private class Node {
		private K key;
		private V data;
		private Node left, right, thread;

		public Node(K key, V data) {
			this.key = key;
			this.data = data;
		}
	}
	
	private Node root;

	public void insert(K key, V value) {
		if(key == null || value == null) {
			return;
		}
		Node temp = new Node(key, value);
		if(root == null) {
			root = temp;
		}else {
			insertAux(temp, root);
		}
	}
	
	private void insertAux(Node add, Node cursor) {
		if(cursor!=null) {
			int comp = cursor.key.compareTo(add.key);
			if(comp == 0) {
				cursor.data = add.data;
				return;
			}else if(comp > 0) {
				if(cursor.left == null) 
					cursor.left = add;
				else 
					insertAux(add, cursor.left);
			}else {
				if(cursor.right == null)
					cursor.right = add;
				else
					insertAux(add, cursor.right);
			}
		}
	}
	
	public void remove(K key) {
		if(key == null || root == null) {
			return;
		}else {
			removeAux(key, root);
		}
	}
	
	public Node removeAux(K key, Node cursor) {
		if(cursor == null || cursor.key == null) {
			return null;
		}else {
			cursor.left = removeAux(key, cursor.left);
			cursor.right = removeAux(key, cursor.right);
			return cursor;
		}
	}
	

	
	public V find(K key){
		if(root == null)
			return null;
		else
			return findAux(key, root);
	}	

	public V findAux(K key, Node cursor){
		if(cursor == null)
			return null; //or throw an error or something
		int compare = cursor.key.compareTo(key);
		if(compare == 0)
			return cursor.data;
		else if (compare > 0)
			return findAux(key, cursor.left);
		else
			return findAux(key, cursor.right);
	}

	public int treeHeight(){
		return treeHeightAux(root);
	}

	public int treeHeightAux(Node cursor){
		if(cursor == null)
			return 0;
		int left = treeHeightAux(cursor.left);
		int right = treeHeightAux(cursor.right);
		return (left>=right) ? left+1 : right+1;
	}
	
	public void preorderPrint() {
		if(root == null) {
			System.out.println("Empty tree");
		}else {
			printAux(root);
		}
	}
	
	private void printAux(Node cursor) {
		if(cursor != null) {
			System.out.println("Key: " + cursor.key.toString() +
					" Data: " + cursor.data.toString());
			printAux(cursor.left);
			printAux(cursor.right);
		}
	}
	
	public BinarySearchTree<K,V> subMap(K lower, K upper){
		BinarySearchTree<K,V> subMap = new BinarySearchTree<K,V>();
		subMap.root = subMapAux(root, lower, upper);
		return subMap;
	}
	
	private Node subMapAux(Node cursor, K lower, K upper) {
		if(cursor == null) {
			return null;
		}
		Node copy;
		int lb = cursor.key.compareTo(lower);
		int ub = cursor.key.compareTo(upper);
		if(lb >= 0 && ub <= 0) {
			copy = new Node(cursor.key, cursor.data);
			copy.left = subMapAux(cursor.left, lower, upper);
			copy.right = subMapAux(cursor.right, lower, upper);
			return copy;
		}else {
			if( lb < 0 ) {
				return subMapAux(cursor.right, lower, upper);
			}else{
				return subMapAux(cursor.left, lower, upper);
			}
		}
		
		
	}
	
	public void retrieveLeaves(Map<K,V> map) {
		root = retrieveLeavesAux(map, root);
	}
	
	private Node retrieveLeavesAux(Map<K,V> map, Node cursor) {
		if(cursor == null) {
			return null;
		}else {
			if(cursor.left == null && cursor.right == null) {
				map.put(cursor.key, cursor.data);
				return null;
			}else {
				cursor.left = retrieveLeavesAux(map, cursor.left);
				cursor.right = retrieveLeavesAux(map, cursor.right);
				return cursor;
			}
		}
	}
	
	public int size() {
		Node cursor;
		int sum = 0;
		Stack<Node> stack = new Stack<Node>();
//		HashSet<K> visited = new HashSet<K>();
		stack.push(root);
		while(!stack.empty()) {
			cursor = stack.pop();
			if(cursor!= null) {// && !visited.contains(cursor.key)) {
				sum+=1;
			//	visited.add(cursor.key);
				stack.push(cursor.left);
				stack.push(cursor.right);
			}
		}
		return sum;
	}
	
	public void nonRecursiveThreadInOrder() {
		if(root == null)
			return;
		
		Node cursor;
		TreeMap<K, Node> ordered = new TreeMap<K, Node>();
		Stack<Node> stack = new Stack<Node>();
		stack.push(root);
		while(!stack.empty()) {
			cursor = stack.pop();
			if(cursor != null && !ordered.containsKey(cursor.key)) {
				ordered.put(cursor.key, cursor);
				stack.push(cursor.left);
				stack.push(cursor.right);
			}
		}
		Node next;
		cursor = null;
		for(K key: ordered.keySet()) {
			if(cursor == null)
				cursor = ordered.get(key);
			else {
				next = ordered.get(key);
				cursor.thread = next;
				
				cursor = next;
			}
		}
	}
	
	public void threadedWalk() {
		Node cursor = root;
		if(cursor == null) {
			System.out.println("Threaded walk failed, empty tree");
			return;
		}
		
		while(cursor.left != null) {
			cursor = cursor.left;
		}
		
		System.out.println("Key: " + cursor.key.toString() +
				" Data: " + cursor.data.toString());
		
		while(cursor.thread != null) {
			System.out.println("Key: " + cursor.thread.key.toString() +
					" Data: " + cursor.thread.data.toString());
			cursor = cursor.thread;
		}
	}
	
	public void threadInOrder() {
		threadAux(root);
		
	}
	
	private Node threadAux(Node cursor) {
		if(cursor == null) 
			return null;
		return null;
	}
}

























