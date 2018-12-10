package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class MyGraph<E> {
	public class Node<E> {
		E myValue;
		boolean tag;					//must be set to something in method
		ArrayList<Node<E>> myNeighbors;
		public Node(E val){
			myValue = val;
			myNeighbors = new ArrayList<Node<E>>();
		}
	}

	ArrayList<Node<E>> myNodes;
	
	public void addNode(E val) {
		if(myNodes == null) {
			myNodes = new ArrayList<Node<E>>();
		}
		Node<E> n = new Node<E>(val);
		myNodes.add(n);
	}
	
	public void addEdge(E start, E end) {
		Node<E> a = null, b = null;
		for(Node<E> cursor: myNodes) {
			if(cursor.myValue == start)
				a = cursor;
			else if(cursor.myValue == end)
				b = cursor;
		}
		
		if(a != null && b != null) {
			if(!a.myNeighbors.contains(b))
				a.myNeighbors.add(b);
			if(!b.myNeighbors.contains(a))
				b.myNeighbors.add(a);
		}
	}
	
	void visitNode(Node<E> n) {
		/* Action to be performed when traversing node */
		System.out.println(n.myValue.toString());
	}
	
	void test() {
		return;
	}

	void depthFirstSearch(Node n) {
		if(n == null)
			return;
		Stack<Node<E>> stack = new Stack<Node<E>>();
		Node<E> cursor;
		
		for(Node<E> node: myNodes) {
			node.tag = false;
		}
		
		stack.push(n);
		
		while(!stack.empty()) {
			cursor = stack.pop();
			if(!cursor.tag) {
				visitNode(cursor);
				cursor.tag = true;
				for(Node<E> neighbor: cursor.myNeighbors) {
					if(!neighbor.tag) {
						stack.push(neighbor);
					}
				}
			}
		}
		
	}
}
